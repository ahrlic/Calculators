package activity2;

import simpleIO.Console;

/**
 * This application will calculate the value of a compound investment
 */

public class CompoundInvestment {

  public static void main(String[] args) {

    // Constants for the array column indices
    final int INITIAL = 0;
    final int INTEREST = 1;
    final int BALANCE = 2;

    // Variables - 2D array, user inputs
    double[][] investment;
    double rate, regularPayment, totalInterest = 0;
    int totalYears;

    // Get user input for needed values
    rate = Console.readDouble("What is the interest rate (%) ?");
    regularPayment = Console.readDouble("What is the regular payment?");
    totalYears = Console.readInt("How many years are you investing?");

    // Initialize 2D array - adding an extra year so the output will match the
    // sample table
    // The first row will contain all zeros - this is intentional!
    // Our 'year' will now match the array index
    investment = new double[totalYears + 1][3];

    // Populate the array with the calculations
    for (int year = 1; year <= totalYears; year++) {

 
      // TODO: Calculate the value of first column (initial)
    	investment[year][INITIAL] = regularPayment + investment[year-1][BALANCE];
    	
      // TODO: Calculate the value of second column (interest)
    	investment[year][INTEREST] = (rate / 100) * investment[year][INITIAL];
    	
      // TODO: Calculate the value of the third column (balance)
    	investment[year][BALANCE] = investment[year-1][BALANCE] + investment[year][INITIAL] ;
    	
    }

    // TODO: Calculate the overall interest
    	
    
    // Output the result
    Console.print("\nYear\tInitial\t\tInterest\tBalance");

    for (int year = 1; year <= totalYears; year++) {

      Console.print(year + "\t"
          + Console.roundDouble(investment[year][INITIAL], 2) + "\t\t"
          + Console.roundDouble(investment[year][INTEREST], 2) + "\t\t"
          + Console.roundDouble(investment[year][BALANCE], 2));

    }

    Console.print("\nTotal interest earned: $" + Console.roundDouble(totalInterest, 2));

  }
}