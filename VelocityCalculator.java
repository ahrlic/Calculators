/**
 * 
 */
package activity2;

import simpleIO.Console;

/**
 * 
 * @author Ariana Hrlic 
 * Date: March 16 2023 
 * Course: ISC3U 
 * VelocityCalculator.java
 * VelocityCalculator
 */

public class VelocityCalculator {

	
	public static void main(String[] args) {
		
		int distance = Console.readInt("Enter the distance");
		int time = Console.readInt("Enter the time");
		
		calculateVelocity(distance, time);
	}

	public static void calculateVelocity(int distance, int time) {
		
		double velocity;
		velocity =  (double) distance / time; 
		
		Console.print("The velocity is: " + velocity);
	
	}
}