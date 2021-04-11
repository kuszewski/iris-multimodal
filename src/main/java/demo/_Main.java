package demo;

import java.io.*;
import java.util.Scanner;

import demo.App;

/* Command-line wrapper around the demo class. */

public class _Main
{
    public static void main( String[] args ) throws Exception
    {
        App app = new App();
        try {
            // Starting interactive prompt
            boolean always = true;
            Scanner scanner = new Scanner(System.in);
            while (always) {
                System.out.print("\033[H\033[2J");  // Clear the console
                System.out.println("1. Create database schema");
                System.out.println("2. Create Cohorts");
                System.out.println("3. Create Participants");
                System.out.println("4. Assign Participants Cohorts");
                System.out.println("5. Simulate testing");
                System.out.println("6. Generate Reports");
                System.out.println("Q. Quit\n");
                System.out.print("What would you like to do (1-6, Q)? ");
                
                String option = scanner.next();
                switch (option) {
                case "1":
                    // Create database schema
                    System.out.print("Creating database schema...");
                    app.Step1_CreateDatabaseSchema();
                    System.out.print("   ...Complete\n");
                    break;
                case "2":
                    // Create Cohorts
                    break;
                case "3":
                    // Create Participants
                    System.out.print("How many participants would you like to generate? ");	
                    int number = scanner.nextInt();

                    System.out.println("Creating Participants...");
                    app.Step3_CreateParticipants(number);
                    System.out.print("   ...Complete\n");
                    break;
                case "4":
                    // Assign Cohorts
                    System.out.println("Assigning Cohorts...");
                    app.Step4_AssignCohorts();
                    System.out.print("   ...Complete\n");
                    break;
                case "5":
                    // Simulate Testing
                    System.out.print("How many test results would you like to generate? ");	
                    int testnum = scanner.nextInt();

                    System.out.println("Simulating Testing...");
                    app.Step5_SimulateTesting(testnum);
                    System.out.print("   ...Complete\n");
                    break;
                case "6":
                    // Report
                    app.Step6_Report();
                    break;
                case "0":
                    app.Step0_DeleteSchema();
                    break;
                case "q":
                case "Q":
                    System.out.println("\nExited.\n");
                    always = false;
                    break;
                default: 
                    System.out.println("Invalid option. Try again!");
                    break;
                }

                if (always) {
                    System.out.print("\nPress return to continue"); 
                    System.in.read();
                }
            }
            scanner.close();	
        } catch (Exception e) { 
            System.out.println("Interactive prompt failed:\n" + e); 
        }
    }
}
