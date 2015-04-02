
import java.awt.event.*;
import java.text.DecimalFormat;
	
public class TrajectoryController {
	
		private static final double G_EARTH = -9.8;
		private static final double G_MOON = -1.6;
		private static final double G_MARS = -3.7;
		private static final double G_JUPITER = -24.8;
		private static final double G_PLUTO = -0.66;
		
		public Double initialHeight = null;
		public Double initialVelocity = null;
		public double timeFlight;
		public double maxHeight;
		DecimalFormat decimal = new DecimalFormat("0.0");
		double acceleration = 0;
		
		public TrajectoryController (final TrajectoryView view, final TrajectoryModel model){
		
			view.addEarthGravityListener(new ActionListener(){  
				public void actionPerformed (ActionEvent e){
					acceleration = G_EARTH;
					//view.timeSolutionText.setText("earth");
				}
			});
			
			view.addMoonGravityListener( new ActionListener(){
				public void actionPerformed (ActionEvent e){
					acceleration = G_MOON;	
				}
			});
			
			view.addMarsGravityListener( new ActionListener(){
				public void actionPerformed (ActionEvent e){
					acceleration = G_MARS;	
				}
			});
			
			view.addJupiterGravityListener( new ActionListener(){
				public void actionPerformed (ActionEvent e){
					acceleration = G_JUPITER;	
				}
			});
			
			view.addPlutoGravityListener( new ActionListener(){
				public void actionPerformed (ActionEvent e){
					acceleration = G_PLUTO;	
				}
			});
			
						
			view.addCalculateButtonListener(new ActionListener(){  
				public void actionPerformed (ActionEvent e){
					
					String height = view.heightText.getText();
					String velocity = view.velocityText.getText();
					
					if (height.isEmpty() | velocity.isEmpty() ){
						view.timeSolutionLabel.setText("Please enter a real value for your given parameters. ");
					}
					
					else if (acceleration == 0 ) {
						view.heightSolutionLabel.setText("Please select a gravitational acceleration.");
					}
					
					
					else {
										
							try {
								initialHeight = Double.parseDouble(height);
								initialVelocity = Double.parseDouble(velocity);
							}
							catch (NumberFormatException except) {
								view.timeSolutionLabel.setText("Please enter a real value. ");
							}
							
							model.solveMaxHeight(initialHeight, initialVelocity, acceleration);
							model.solveTimeInFlight(initialHeight, initialVelocity, acceleration);
							
							maxHeight = model.getMaxHeight();
							timeFlight = model.getTimeInFlight();
							
							view.heightSolutionLabel.setText("  " + decimal.format(maxHeight) + "  (m)");
							view.timeSolutionLabel.setText("  " + decimal.format(timeFlight) + "  (s)");
							}
							
						}
					});			
			
//			view.addResetButtonListener(new ActionListener(){
//				public void actionPerformed (ActionEvent e){
//					
//				}
//			});
			
			view.addExitButtonListener(new ActionListener() {
				public void actionPerformed (ActionEvent e){
					System.exit(0);
				}
			});
		
		}


	}