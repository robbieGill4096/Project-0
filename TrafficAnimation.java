import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.text.StyleConstants.ColorConstants;

/**
 * CS 121 Project 1: Traffic Animation
 *
 * Animates a [Pirate ship sailing past a salty Sailor]
 *
 * @author BSU CS 121 Instructors
 * @author Robbie Gill
 */

@SuppressWarnings("serial")
public class TrafficAnimation extends JPanel
{
	// This is where you declare constants and variables that need to keep their
	// values between calls	to paintComponent(). Any other variables should be
	// declared locally, in the method where they are used.

	/**
	 * A constant to regulate the frequency of Timer events.
	 * Note: 100ms is 10 frames per second - you should not need
	 * a faster refresh rate than this
	 */
	private final int DELAY = 100; //milliseconds

	/**
	 * The anchor coordinate for drawing / animating. All of your vehicle's
	 * coordinates should be relative to this offset value.
	 */
	private int xOffset = 0;
	/**
	 * The number of pixels added to xOffset each time paintComponent() is called.
	 */
	private int stepSize = 10;

	private final Color BACKGROUND_COLOR = Color.white;

	/* This method draws on the panel's Graphics context.
	 * This is where the majority of your work will be.
	 *
	 * (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g)
	{
		// Get the current width and height of the window.
		int width = getWidth(); // panel width
		int height = getHeight(); // panel height
		
		// Fill the graphics page with the background color.
		g.setColor(BACKGROUND_COLOR);
		g.fillRect(0, 0, width, height);

		// Calculate the new xOffset position of the moving object.
		xOffset  = (xOffset + stepSize) % width;
		
		
		//BACKGROUND with SCENERY
		
		//sky
		Color skyBlue = new Color(56,176,222);
		g.setColor(skyBlue);
		g.fillRect(dimensionScalerX(0), dimensionScalerY(0), dimensionScalerX(620), dimensionScalerY(233));
		
		//sun
		Color sunOrange = new Color(255,196,0);
		g.setColor(sunOrange);
		g.fillArc(dimensionScalerX(100), dimensionScalerY(0), dimensionScalerX(110), dimensionScalerY(117),180,360);
		
		//sea
		g.setColor(Color.BLUE);
		g.fillRect(dimensionScalerX(0), dimensionScalerY(167), dimensionScalerX(620), dimensionScalerY(133));
		
		//ground
		Color sand = new Color(255,255,196);
		g.setColor(sand);
		g.fillRect(dimensionScalerX(0), dimensionScalerY(280), dimensionScalerX(620), dimensionScalerY(133));
		
		//cloud mid of screen
		g.setColor(Color.white);
		g.fillOval(dimensionScalerX(250), dimensionScalerY(33), dimensionScalerX(50), dimensionScalerY(33));
		g.fillOval(dimensionScalerX(280), dimensionScalerY(33), dimensionScalerX(40), dimensionScalerY(27));
		g.fillOval(dimensionScalerX(300), dimensionScalerY(37), dimensionScalerX(30), dimensionScalerY(20));
		
		//cloud left corner of screen
		g.setColor(Color.white);
		g.fillOval(dimensionScalerX(100), dimensionScalerY(47), dimensionScalerX(50), dimensionScalerY(33));
		g.fillOval(dimensionScalerX(130), dimensionScalerY(47), dimensionScalerX(40), dimensionScalerY(27));
		g.fillOval(dimensionScalerX(160), dimensionScalerY(47), dimensionScalerX(30), dimensionScalerY(20));
		
		//Vehicle SHIP
		
		//main mast
		Color hullBrown = new Color(65,41,6);
		g.setColor(hullBrown);
		g.fillRect(xOffset + dimensionScalerX(170), dimensionScalerY(33), dimensionScalerX(19), dimensionScalerY(167));
		g.fillRect(xOffset + dimensionScalerX(120), dimensionScalerY(50), dimensionScalerX(100), dimensionScalerY(10));
		
		//main sail
		Color shipSail = new Color(240,234,213);
		g.setColor(shipSail);
		g.fillRect(xOffset + dimensionScalerX(120), dimensionScalerY(50), dimensionScalerX(100), dimensionScalerY(100));
		
		//ships hull.
		g.setColor(hullBrown);
		g.fillRect(xOffset + dimensionScalerX(0), dimensionScalerY(167), dimensionScalerX(300), dimensionScalerY(50));
		g.setColor(hullBrown);
		g.fillRect(xOffset + dimensionScalerX(25), dimensionScalerY(200), dimensionScalerX(250), dimensionScalerY(33));
		g.setColor(Color.BLACK);
		g.drawRect(xOffset + dimensionScalerX(0), dimensionScalerY(167), dimensionScalerX(300), dimensionScalerY(50));
		g.setColor(hullBrown);
		g.fillRect(xOffset + dimensionScalerX(300), dimensionScalerY(167), dimensionScalerX(30), dimensionScalerY(33));
		
		//front rig post
		g.setColor(hullBrown);
		g.fillRect(xOffset + dimensionScalerX(325), dimensionScalerY(160), dimensionScalerX(20), dimensionScalerY(20));
		g.setColor(hullBrown);
		g.fillRect(xOffset + dimensionScalerX(340), dimensionScalerY(146), dimensionScalerX(15), dimensionScalerY(17));
		g.setColor(Color.BLACK);
		g.drawRect(xOffset + dimensionScalerX(340), dimensionScalerY(147), dimensionScalerX(15), dimensionScalerY(17));
		g.setColor(Color.BLACK);
		g.drawRect(xOffset + dimensionScalerX(25), dimensionScalerY(167), dimensionScalerX(250), dimensionScalerY(10));
		g.setColor(Color.BLACK);
		g.drawRect(xOffset + dimensionScalerX(35), dimensionScalerY(177), dimensionScalerX(250), dimensionScalerY(10));
		g.setColor(hullBrown);
		g.fillRect(xOffset + dimensionScalerX(350), dimensionScalerY(133), dimensionScalerX(30), dimensionScalerY(16));
		
		//cabin.
		g.setColor(hullBrown);
		g.fillRect(xOffset + dimensionScalerX(0), dimensionScalerY(135), dimensionScalerX(100), dimensionScalerY(33));
		
		// windows.
		g.setColor(Color.DARK_GRAY);
		g.fillOval(xOffset + dimensionScalerX(250), dimensionScalerY(183), dimensionScalerX(17), dimensionScalerY(17));
		g.fillOval(xOffset + dimensionScalerX(200), dimensionScalerY(183), dimensionScalerX(17), dimensionScalerY(17));
		g.fillOval(xOffset + dimensionScalerX(150), dimensionScalerY(183), dimensionScalerX(17), dimensionScalerY(17));
		g.fillOval(xOffset + dimensionScalerX(100), dimensionScalerY(2183), dimensionScalerX(17), dimensionScalerY(17));
	
		//AVATAR
		
		//pirates hat
	/*This is a blue print of how the x,y values are oriented,
	 * to form a hat on my avatar.
	 * 			(x3,y3)*(x4,y4)*
 * 			(x2,y2)* 		(x5,y5)* 
	 * 	(x1,y1)*				(x6,y6)*
 * 			(x10,y10)*		(x7,y7)*	
	 * 			(x9,y9)*(x8,y8)*
	 * 
	 */
		//X values pirate hat
		int x1 = dimensionScalerX(300);
		int x2 = dimensionScalerX(320);
		int x3 = dimensionScalerX(340);
		int x4 = dimensionScalerX(360);
		int x5 = dimensionScalerX(380);
		int x6 = dimensionScalerX(400);
		int x7 = dimensionScalerX(380);
		int x8 = dimensionScalerX(360);
		int x9 = dimensionScalerX(340);
		int x10 = dimensionScalerX(320);
	
		//Y values pirate hat
		int y1 = dimensionScalerY(350);
		int y2 = dimensionScalerY(337);
		int y3 = dimensionScalerY(320);
		int y4 = dimensionScalerY(320);
		int y5 = dimensionScalerY(337);
		int y6 = dimensionScalerY(350);
		int y7 = dimensionScalerY(362);
		int y8 = dimensionScalerY(370);
		int y9 = dimensionScalerY(370);
		int y10 =dimensionScalerY(362);
		
		int[] xPoints = {x1,x2,x3,x4,x5,x6,x7,x8,x9,x10};
		int[] yPoints = {y1,y2,y3,y4,y5,y6,y7,y8,y9,y10}; 
		
		/*creates a polygon based on the ordered x,y values.
		In this case in the shape of a pirate hat
		*/
		g.setColor(Color.BLACK);
		g.fillPolygon(xPoints, yPoints,10);
	
		//head
		Color skinColor = new Color(255, 205, 148);
		g.setColor(skinColor);
		g.fillOval(dimensionScalerX(325), dimensionScalerY(343), dimensionScalerX(50), dimensionScalerY(57));
		
		//eye
		g.setColor(Color.white);
		g.fillOval(dimensionScalerX(330), dimensionScalerY(355), dimensionScalerX(15), dimensionScalerY(15));
		g.setColor(Color.blue);
		g.fillOval(dimensionScalerX(333), dimensionScalerY(358), dimensionScalerX(10), dimensionScalerY(10));
		
		//eye patch
		g.setColor(Color.BLACK);
		g.fillRect(dimensionScalerX(327), dimensionScalerY(355), dimensionScalerX(50), dimensionScalerY(4));
		g.fillArc(dimensionScalerX(350), dimensionScalerY(343), dimensionScalerX(20), dimensionScalerY(27),180, 180);
		
		//mouth
		g.setColor(Color.BLACK);
		g.fillArc(dimensionScalerX(342), dimensionScalerY(372), dimensionScalerX(11), dimensionScalerY(11),360,360 );
		
		//mustache
		Color mustacheBrown = new Color(102,51,0);
		g.setColor(mustacheBrown);
		g.fillArc(dimensionScalerX(338), dimensionScalerY(370), dimensionScalerX(20), dimensionScalerY(14),340,210 );
		
		// nose
		g.setColor(skinColor);
		g.fillRect(dimensionScalerX(345), dimensionScalerY(359),dimensionScalerX(5), dimensionScalerY(15));
		g.setColor(Color.black);
		g.drawRect(dimensionScalerX(345), dimensionScalerY(359),dimensionScalerX(5), dimensionScalerY(15));
		
		//TEXT
		g.setColor(Color.RED);
		g.setFont(new Font("TimesRoman",Font.PLAIN, dimensionScalerX(25)));
		g.drawString("'YARGGGG!!'",dimensionScalerX(150), dimensionScalerY(359));
		
		// Put your code above this line. This makes the drawing smoother.
		Toolkit.getDefaultToolkit().sync();
	}
	
/**
The dimensionScalerX
*Scales a value based on the current dimension of the screen.
*@param var takes a integer value representing an X value and scales it 
*to the current dimensions of the screen.
*@retun The equivilant X value for that screen size.
*/
	//Input desired x location you want to scale.
		public int dimensionScalerX(int var) {
			int width = getWidth();
			int result = ((width/6)*var)/100;
			return (result);
		}
		//Input desired Y location you want to scale.
		public int dimensionScalerY(int var) {
			int height = getHeight();
			int result = ((height/4)*var)/100;
			return (result);
		}
	

	//==============================================================
	// You don't need to modify anything beyond this point.
	//==============================================================


	/**
	 * Starting point for this program. Your code will not go in the
	 * main method for this program. It will go in the paintComponent
	 * method above.
	 *
	 * DO NOT MODIFY this method!
	 *
	 * @param args unused
	 */
	public static void main (String[] args)
	{
		// DO NOT MODIFY THIS CODE.
		JFrame frame = new JFrame ("Traffic Animation");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new TrafficAnimation());
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Constructor for the display panel initializes necessary variables.
	 * Only called once, when the program first begins. This method also
	 * sets up a Timer that will call paint() with frequency specified by
	 * the DELAY constant.
	 */
	public TrafficAnimation()
	{
		// Do not initialize larger than 800x600. I won't be able to
		// grade your project if you do.
		int initWidth = 600;
		int initHeight = 400;
		setPreferredSize(new Dimension(initWidth, initHeight));
		this.setDoubleBuffered(true);

		//Start the animation - DO NOT REMOVE
		startAnimation();
	}

	/**
	 * Create an animation thread that runs periodically.
	 * DO NOT MODIFY this method!
	 */
	private void startAnimation()
	{
		ActionListener timerListener = new TimerListener();
		Timer timer = new Timer(DELAY, timerListener);
		timer.start();
	}

	/**
	 * Repaints the graphics panel every time the timer fires.
	 * DO NOT MODIFY this class!
	 */
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}
}  
