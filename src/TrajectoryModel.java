
public class TrajectoryModel {

	/* This class is the physics portion of the trajectory calculator problem.
	 * It assumes one-dimensional, vertical motion, and the equation used depends on which variables are given.
	 * The class uses the four standard kinematic equations to solve for the following:
	 * 
	 * - The maximum height reached by a projectile and
	 * - The time in flight before the projectile hits the ground.
	 */
	
	private double maxHeight, timeInFlight;
	
	public double getMaxHeight() {
		return maxHeight;
	}
	
	public double getTimeInFlight(){	
		return timeInFlight;
	}
	


/** Solve for time of flight
 * 
 * Equation: y_f = y_i + v_0*t + 1/2*a*t^2
 * 	 Or: height_final = height_initial + velocity_initial * time  + 1/2 * acceleration * time^2
 * 
 * @param initialHeight
 * @param finalHeight
 * @param initialVelocity
 * @param acceleration
 */

public void solveTimeInFlight (double initialHeight, double initialVelocity, double acceleration) {
	
	// Delta is the difference between final and initial height
	double delta = - initialHeight;
	
	// This separates the radical portion of the quadratic from the rest for simplicity
	double radical = Math.sqrt(Math.pow(initialVelocity, 2) + 2 * acceleration * delta);
	
	// The quadratic equation has two roots, two time solutions
	double timeSolution1 = (-initialVelocity + radical)/ acceleration ;
	double timeSolution2 = (-initialVelocity - radical)/ acceleration ;
	
	// Selecting the correct time solution
	
	if (timeSolution1 > 0 && timeSolution2 <= 0){
		timeInFlight = timeSolution1;
	}
	
	else {	
		timeInFlight = timeSolution2;
	}		
	}

/** Solve for max height 
 * 
 * Equation: v_f ^2 = v_0 ^2 + 2a * (y_f - y_i)  
 * OR: velocity_final^2 = velocity_initial^2 + 2 * acceleration * (height_final - height_initial) 
 * 
 * @param initialHeight
 * @param initialVelocity
 * @param finalVelocity
 * @param acceleration
 */

public void solveMaxHeight (double initialHeight, double initialVelocity, double acceleration) {	
	
	double finalVelocity = 0; // At max height
	
	// A negative velocity would mean that the projectile was never higher than it started
	if(initialVelocity < 0) {			
		maxHeight = initialHeight;		
	}

	else {
		maxHeight = (Math.pow(finalVelocity, 2) - Math.pow(initialVelocity, 2))/(2 * acceleration) + initialHeight;	
		// Need to make sure user cannot put in a = 0.  (Div by zero)
	}
}

}
