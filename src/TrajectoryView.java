
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.border.Border;


public class TrajectoryView extends JFrame{

	private static final long serialVersionUID = 1L;
	private static final String TITLE = "VERTICAL TRAJECTORY CALCULATOR";
	private static final String CALCULATE = "CALCULATE";
	//private static final String RESET = "RESET";
	private static final String EXIT = "EXIT";
	private static final String GIVEN_PARAMETERS = "Given Parameters";
	private static final String INITIAL_VELOCITY = "Enter the initial velocity of the pojectile (m/s):  ";
	private static final String INITIAL_HEIGHT = "Enter the initial height of the projectile (m):  ";
	private static final String BLANK = "";
	private static final String EARTH_LABEL = "Earth (g  = - 9.8 m/s^2)";
	private static final String MOON_LABEL = "Moon (g  = - 1.6 m/s^2)";
	private static final String MARS_LABEL = "Mars (g = - 3.7 m/s^2)";
	private static final String JUPITER_LABEL = "Jupiter (g = - 24.8 m/s^2)";
	private static final String PLUTO_LABEL = "Pluto (g = - 0.66 m/s^2)";
	private static final String TIME_FLIGHT = "The time in flight for the projectile:  ";
	private static final String MAX_HEIGHT = "The maxiumum height reached:  ";

	private static final String GRAVITY_SELECTION = "What massive body are you on?";
	private static final int FRAME_WIDTH = 700;
	private static final int FRAME_HEIGHT = 420;
	DecimalFormat decimal = new DecimalFormat("0.0");
	
	Dimension labelDim = new Dimension(300,40);
	Dimension buttonDim = new Dimension(200,80);
	Dimension panelDim = new Dimension(600,100);
	Border labelBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
	Border buttonBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 15);
	
	JPanel contentPanel = new JPanel();
	JPanel userInputPanel = new JPanel();
	JPanel gravityPanel = new JPanel();
	JPanel solutionPanel = new JPanel();
	JPanel commandPanel = new JPanel();

	JTextField heightText = new JTextField(20);
	JTextField velocityText = new JTextField(20);

	
	JLabel gravitySelectionLabel = new JLabel(GRAVITY_SELECTION);
	JLabel initialHeightLabel = new JLabel(INITIAL_HEIGHT, SwingConstants.RIGHT);
	JLabel initialVelocityLabel = new JLabel(INITIAL_VELOCITY, SwingConstants.RIGHT);
	JLabel timeInFlightLabel = new JLabel(TIME_FLIGHT, SwingConstants.RIGHT);
	JLabel timeSolutionLabel = new JLabel( "" , SwingConstants.CENTER);
	JLabel maxHeightLabel = new JLabel(MAX_HEIGHT, SwingConstants.RIGHT);
	JLabel heightSolutionLabel = new JLabel("", SwingConstants.CENTER);
	JLabel blankSpace = new JLabel(BLANK);
		
	JButton exitButton = new JButton(EXIT);
	JButton calculateButton = new JButton(CALCULATE);
//	JButton resetButton = new JButton(RESET);
	
	JRadioButton earthGravityButton = new JRadioButton(EARTH_LABEL);
	JRadioButton moonGravityButton = new JRadioButton(MOON_LABEL);
	JRadioButton marsGravityButton = new JRadioButton(MARS_LABEL);
	JRadioButton jupiterGravityButton = new JRadioButton(JUPITER_LABEL);
	JRadioButton plutoGravityButton = new JRadioButton(PLUTO_LABEL);	
	ButtonGroup gravityButtonGroup = new ButtonGroup();
	
	JFrame programFrame = new JFrame();

	public TrajectoryView(){
		
		
		userInputPanel.setLayout(new GridLayout(2, 2));
		userInputPanel.setName(GIVEN_PARAMETERS);
		userInputPanel.add(initialHeightLabel);
		userInputPanel.add(heightText);
		userInputPanel.add(initialVelocityLabel);
		userInputPanel.add(velocityText);
		velocityText.setHorizontalAlignment(JTextField.CENTER);
		heightText.setHorizontalAlignment(JTextField.CENTER);
		userInputPanel.setBorder(labelBorder);
		initialHeightLabel.setPreferredSize(labelDim);
		initialVelocityLabel.setPreferredSize(labelDim);
		
		
		gravityButtonGroup.add(earthGravityButton);
		gravityButtonGroup.add(moonGravityButton);
		gravityButtonGroup.add(marsGravityButton);
		gravityButtonGroup.add(jupiterGravityButton);
		gravityButtonGroup.add(plutoGravityButton);
		
		gravityPanel.setLayout(new GridLayout(2,3));
		gravityPanel.add(earthGravityButton);
		gravityPanel.add(moonGravityButton);
		gravityPanel.add(marsGravityButton);
		gravityPanel.add(jupiterGravityButton);
		gravityPanel.add(plutoGravityButton);
		gravityPanel.setBorder(labelBorder);
		gravityPanel.setPreferredSize(panelDim);
	
		
		solutionPanel.setLayout(new GridLayout(2,2));
		solutionPanel.add(timeInFlightLabel);
		solutionPanel.add(timeSolutionLabel);
		solutionPanel.add(maxHeightLabel);
		solutionPanel.add(heightSolutionLabel);
		solutionPanel.setBorder(labelBorder);
		timeInFlightLabel.setPreferredSize(labelDim);
		timeSolutionLabel.setBorder(labelBorder);
		timeSolutionLabel.setPreferredSize(labelDim);
		maxHeightLabel.setPreferredSize(labelDim);
		heightSolutionLabel.setBorder(labelBorder);
		heightSolutionLabel.setPreferredSize(labelDim);
		
		
		commandPanel.setLayout(new GridLayout(1,2));
		commandPanel.add(exitButton);
		//commandPanel.add(resetButton);
		commandPanel.add(calculateButton);
		exitButton.setPreferredSize(buttonDim);
		calculateButton.setPreferredSize(buttonDim);
		exitButton.setBorder(buttonBorder);
		calculateButton.setBorder(buttonBorder);
		
		contentPanel.setLayout(new GridLayout(3,1));
		contentPanel.add(userInputPanel);
		contentPanel.add(gravityPanel);
		contentPanel.add(solutionPanel);
		
		programFrame.setLayout(new GridLayout(4,1));
		programFrame.add(userInputPanel);
		programFrame.add(gravityPanel);
		programFrame.add(solutionPanel);
		programFrame.add(commandPanel);
		programFrame.setTitle(TITLE);
		programFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		programFrame.setLayout(new FlowLayout());
		programFrame.setVisible(true);
		
		programFrame.setVisible(true);
		
	}
	
	void addEarthGravityListener(ActionListener g){
		earthGravityButton.addActionListener(g);
		}
	
	void addMoonGravityListener(ActionListener g){
		moonGravityButton.addActionListener(g);
		}
	
	void addMarsGravityListener(ActionListener g){
		marsGravityButton.addActionListener(g);
		}
	
	void addJupiterGravityListener(ActionListener g){
		jupiterGravityButton.addActionListener(g);
		}
	
	void addPlutoGravityListener(ActionListener g){
		plutoGravityButton.addActionListener(g);
		}
	
	void addCalculateButtonListener(ActionListener s){
		calculateButton.addActionListener(s);
		}
	
	void addExitButtonListener(ActionListener e){
		 exitButton.addActionListener(e);
		}
	
//	void addResetButtonListener(ActionListener r){
//		resetButton.addActionListener(r);
//		}


}