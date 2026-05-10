import java.util.*;
public class Main {
    public static void main(String[] args){
        boolean exit=true;
        while(exit){
            System.out.println("Welcome to the Medical Clinic Management System");
            System.out.println("Please select an option:");
            System.out.println("1. Manage Patients");
            System.out.println("2. Manage Doctors");
            System.out.println("3. Manage Exams");
            System.out.println("4. Manage Appointments");
            System.out.println("5. Manage Statistics");
            System.out.println("6. Exit");

            int choice = new java.util.Scanner(System.in).nextInt();

            switch (choice) {
                case 1:
                    // Code to manage patients
                    System.out.println("Managing Patients...");
                    System.out.println("1. Add Patient");
                    System.out.println("2. View Patients");
                    System.out.println("3. Find Patient");
                    System.out.println("4. Return");
                    int patientChoice = new java.util.Scanner(System.in).nextInt();
                    switch (patientChoice) {
                        case 1:
                            // Code to add patient
                            System.out.println("Adding a new patient...");
                            
                            break;
                        case 2:
                            // Code to view patients
                            System.out.println("Viewing all patients...");
                            break;
                        case 3:
                            //Find patient by code
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Invalid option. Returning to main menu.");
                            break;
                    }
                    
                    break;
                case 2:
                    // Code to manage doctors
                    System.out.println("Managing Doctors...");
                    System.out.println("1. Add Doctors");
                    System.out.println("2. View Doctors");
                    System.out.println("3. Find Doctor Exams");
                    System.out.println("4. Find Doctor Appointments");
                    System.out.println("4. Return");
                    int doctorChoice = new java.util.Scanner(System.in).nextInt();
                    switch (doctorChoice) {
                        case 1:
                            // Code to add doctor
                            System.out.println("Adding a new doctor...");
                            break;
                        case 2:
                            // Code to view doctors
                            System.out.println("Viewing all doctors...");
                            break;

                        case 3:
                            //Find Doctor Exams
                            break;

                        case 4:
                            break;
                        default:
                            System.out.println("Invalid option. Returning to main menu.");
                    }
                    break;
                case 3:
                    // Code to manage exams
                    System.out.println("Managing Exams...");
                    System.out.println("1. Add Exam");
                    System.out.println("2. View Exams");
                    System.out.println("3. Find Exam Appointments");
                    System.out.println("4. Return");
                    int examChoice = new java.util.Scanner(System.in).nextInt();
                    switch (examChoice) {
                        case 1:
                            // Code to add exam
                            System.out.println("Adding a new exam...");
                            break;
                        case 2:
                            // Code to view exams
                            System.out.println("Viewing all exams...");
                            break;

                        case 3:
                            //Find Exam Appointments
                            break;

                        case 4:
                            break;
                        default:
                            System.out.println("Invalid option. Returning to main menu.");
                    }  
                    break;
                case 4:
                    // Code to manage appointments
                        System.out.println("Managing Appointments...");
                        System.out.println("1. Add Appointment");
                        System.out.println("2. View Appointments");
                        System.out.println("3. Find Appointments by Patient Code");
                        System.out.println("4. Remove Appointment");
                        System.out.println("5. Find Appointment by date");
                        System.out.println("6. Return");
                        int appointmentChoice = new java.util.Scanner(System.in).nextInt();
                        switch (appointmentChoice) {
                            case 1:
                                // Code to add appointment
                                System.out.println("Adding a new appointment...");
                                break;
                            case 2:
                                // Code to view appointments
                                System.out.println("Viewing all appointments...");
                                break;
                            case 3:
                                //Find Appointments by Patient Code
                                break;
                            case 4:
                                //Remove Appointment
                                break;
                            case 5:
                                // Find Appointment by date
                                break;
                            case 6:
                                break;
                            default:
                                System.out.println("Invalid option. Returning to main menu.");
                        }
                    break;
                case 5:
                    // Code to manage statistics
                    System.out.println("Managing Statistics...");
                    System.out.println("1. Revenue by Patient");
                    System.out.println("2. Revenue by Exam");
                    System.out.println("3. Revenue by Appointment");
                    System.out.println("4. Total Revenue");
                    System.out.println("5. Return");
                    int statisticsChoice = new java.util.Scanner(System.in).nextInt();
                    switch (statisticsChoice) {
                        case 1:
                            // Code to calculate revenue by patient
                            System.out.println("Calculating revenue by patient...");
                            break;
                        case 2:
                            // Code to calculate revenue by exam
                            System.out.println("Calculating revenue by exam...");
                            break;
                        case 3:
                            // Code to calculate revenue by appointment
                            System.out.println("Calculating revenue by appointment...");
                            break;
                        case 4:
                            // Code to calculate total revenue
                            System.out.println("Calculating total revenue...");
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Invalid option. Returning to main menu.");
                    }
                    
                    
                    break;
                case 6:
                    exit = false;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        

        
    }
}
