import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args){
        FileManager fm= new FileManager();
        String patientsFilePath = "Patients.txt";
        String doctorsFilePath = "Doctors.txt";
        String examsFilePath = "Exams.txt";
        String appointmentsFilePath = "Appointments.txt";
        File patientsFile = new File(patientsFilePath);
        File doctorsFile = new File(doctorsFilePath);
        File examsFile = new File(examsFilePath);
        File appointmentsFile = new File(appointmentsFilePath);
        PatientMenu patientMenu = new PatientMenu(fm.patients);
        DoctorMenu doctorMenu = new DoctorMenu(fm.doctors);
        ExamMenu examMenu = new ExamMenu(fm.exams);
        AppointmentMenu appointmentMenu = new AppointmentMenu(fm.appointments);
        Statistics statistics = new Statistics();
        boolean exit=true;
        fm.loadFile(patientsFilePath);
        fm.loadFile(doctorsFilePath);
        fm.loadFile(examsFilePath);
        fm.loadFile(appointmentsFilePath);
        Scanner scanner= new Scanner(System.in);
        for (Exam exam : fm.exams.values()) {
            exam.getCost(fm.appointments);
        }
        while(exit){
            System.out.println("Welcome to the Medical Clinic Management System");
            System.out.println("Please select an option:");
            System.out.println("1. Manage Patients");
            System.out.println("2. Manage Doctors");
            System.out.println("3. Manage Exams");
            System.out.println("4. Manage Appointments");
            System.out.println("5. Manage Statistics");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Code to manage patients
                    System.out.println("Managing Patients...");
                    System.out.println("1. Add Patient");
                    System.out.println("2. View Patients");
                    System.out.println("3. Find Patient");
                    System.out.println("4. Return");
                    int patientChoice = scanner.nextInt();
                    switch (patientChoice) {
                        case 1:
                            // Code to add patient
                            System.out.println("Adding a new patient...");
                            System.out.println("Enter patient name:");
                            String name = scanner.nextLine();
                            System.out.println("Enter patient phone:");
                            String phone = scanner.nextLine();
                            System.out.println("Enter patient email:");
                            String email = scanner.nextLine();
                            Patient p = new Patient(name, phone, email);
                            patientMenu.addPatient(p);
                            break;
                        case 2:
                            // Code to view patients
                            System.out.println("Viewing all patients...");
                            patientMenu.viewPatients();
                            break;
                        case 3:
                            //Find patient by code
                            patientMenu.viewPatients();
                            System.out.println("Enter patient code:");
                            int code = scanner.nextInt();
                            patientMenu.findByCode(code, fm.appointments);
                            break;
                        case 4:
                            // Return to main menu
                            System.out.println("Returning to main menu...");
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
                            System.out.println("Enter doctor name:");
                            String name = scanner.nextLine();
                            System.out.println("Enter doctor phone:");
                            String phone = scanner.nextLine();
                            System.out.println("Enter doctor specialty(Cardiology, Microbiology, Radiology, Neurology):");
                            String specialty = scanner.nextLine();
                            System.out.println("Enter doctor experience:");
                            int experience = scanner.nextInt();
                            Doctor d = new Doctor(name, phone, specialty, experience);
                            doctorMenu.addDoctor(d);
                            //String name, String phone, String specialty, int experience
                            break;
                        case 2:
                            // Code to view doctors
                            System.out.println("Viewing all doctors...");
                            doctorMenu.listAll();
                            break;

                        case 3:
                            //Find Doctor Exams
                            doctorMenu.listAll();
                            System.out.println("Enter doctor code:");
                            int code = scanner.nextInt();
                            doctorMenu.searchDoctorExam(code, fm.exams);
                            break;

                        case 4:
                            //Find Doctor Appointments
                            doctorMenu.listAll();
                            System.out.println("Enter doctor code:");
                            int id = scanner.nextInt();
                            doctorMenu.searchDoctorAppointment(id, fm.appointments, fm.exams);
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
                            //String examName, String categoryName, String examSpecialty, int maxSlots, double cost, int doctorID
                            
                            System.out.println("Adding a new exam...");
                            System.out.println("Enter exam name:");
                            String examName = scanner.nextLine();
                            System.out.println("Enter exam max slots:");
                            int maxSlots = scanner.nextInt();
                            System.out.println("Enter exam cost:");
                            double cost = scanner.nextDouble();
                            doctorMenu.listAll();
                            System.out.println("Enter doctor ID:");
                            int doctorID = scanner.nextInt();
                            System.out.println("Enter exam category:");
                            String categoryName = scanner.nextLine();
                            System.out.println("1. Imaging");
                            System.out.println("2. Microbiological");
                            System.out.println("3. Specialized");
                            int espec = scanner.nextInt();
                            switch (espec) {
                                case 1:
                                    categoryName = "Imaging";
                                    System.out.println("Enter machine type:");
                                    String machineType = scanner.nextLine();
                                    ImagingExamination e = new ImagingExamination(examName, categoryName, machineType, maxSlots, cost, doctorID);
                                    examMenu.addExam(e);
                                    e.getCost(fm.appointments);
                                    break;
                                case 2:
                                    categoryName = "Microbiological";
                                    System.out.println("Enter sample type:");
                                    String sampleType = scanner.nextLine();
                                    MicrobiologicalExamination m = new MicrobiologicalExamination(examName, categoryName, sampleType, maxSlots, cost, doctorID);
                                    examMenu.addExam(m);
                                    m.getCost(fm.appointments);
                                    break;
                                case 3:
                                    categoryName = "Specialized";
                                    System.out.println("Enter exam spexialty:");
                                    String examSpecialty = scanner.nextLine();
                                    SpecializedExamination s = new SpecializedExamination(examName, categoryName, examSpecialty, maxSlots, cost, doctorID);
                                    examMenu.addExam(s);
                                    s.getCost(fm.appointments);
                                    break;
                                default:
                                    System.out.println("Invalid category. Exam not added.");
                            }
                            break;
                        case 2:
                            // Code to view exams
                            System.out.println("Viewing all exams...");
                            examMenu.showExamsAlphabetically();
                            break;

                        case 3:
                            //Find Exam Appointments
                            examMenu.showExamsAlphabetically();
                            System.out.println("Enter exam code:");
                            int code = scanner.nextInt();
                            examMenu.examAppointments(code, fm.appointments);
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
                                patientMenu.viewPatients();
                                System.out.println("Enter patient ID:");
                                int id = scanner.nextInt();
                                examMenu.showExamsAlphabetically();
                                System.out.println("Choose exam ID");
                                int eID = scanner.nextInt();
                                System.out.println("Enter fast results (true/false):");
                                boolean fR = scanner.nextBoolean();
                                System.out.println("Enter exam date (YYYY-MM-DD):");
                                String examDate = scanner.next();
                                while (!examDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
                                    System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
                                    examDate = scanner.next();
                                    if (examDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
                                        int sum = 0;
                                        int maxSlots = 0;
                                        for (Exam exam : fm.exams.values()) {
                                            for (Appointment appointment : fm.appointments.values()) {
                                                if (appointment.getExamID() == exam.getCode() && appointment.getExamDate().equals(examDate) && !appointment.getDeleted()) {
                                                    maxSlots = exam.getMaxSlots();
                                                    sum = sum + 1;
                                                }
                                            }
                                        }
                                        if (sum>=maxSlots){
                                            System.out.println("Reached max slots. Choose another date");
                                            examDate = scanner.next();
                                        }   
                                    }
                                }
                                if (examDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
                                        int sum = 0;
                                        int maxSlots = 0;
                                        for (Exam exam : fm.exams.values()) {
                                            for (Appointment appointment : fm.appointments.values()) {
                                                if (appointment.getExamID() == exam.getCode() && appointment.getExamDate().equals(examDate) && !appointment.getDeleted()) {
                                                    maxSlots = exam.getMaxSlots();
                                                    sum = sum + 1;
                                                }
                                            }
                                        }
                                        if (sum>=maxSlots){
                                            System.out.println("Reached max slots. Choose another date");
                                            examDate = scanner.next();
                                        }   
                                    }
                                
                                
                                System.out.println("Enter deleted (true/false):");
                                boolean deleted = scanner.nextBoolean();
                                Appointment a = new Appointment(id, eID, fR, examDate, deleted);
                                appointmentMenu.addAppointment(a);
                                break;
                            case 2:
                                // Code to view appointments
                                System.out.println("Viewing all appointments...");
                                appointmentMenu.showAppointments();
                                break;
                            case 3:
                                //Find Appointments by Patient Code
                                patientMenu.viewPatients();         
                                System.out.println("Enter patient ID:");        
                                int ID = scanner.nextInt();
                                appointmentMenu.patientAppointments(ID);
                                break;
                            case 4:
                                //Remove Appointment
                                appointmentMenu.showAppointments();
                                System.out.println("Enter appointment code to remove:");
                                int code = scanner.nextInt();
                                appointmentMenu.removeAppointment(code);
                                if (fm.appointments.containsKey(code)){
                                    fm.appointments.get(code).setDeleted(true);
                                    System.out.println("Appointment removed.");
                                }   
                                break;
                            case 5:
                                // Find Appointment by date
                                System.out.println("Enter date (YYYY-MM-DD):");
                                String date = scanner.next();
                                while (!date.matches("\\d{4}-\\d{2}-\\d{2}")) {
                                    System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
                                    examDate = scanner.next();
                                }
                                appointmentMenu.showAppointmentDay(date, fm.exams, fm.patients);
                                break;
                            case 6:
                                System.out.println("Returning to main menu...");
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
                    System.out.println("4. Return");
                    int statisticsChoice = new java.util.Scanner(System.in).nextInt();
                    switch (statisticsChoice) {
                        case 1:
                            // Code to calculate revenue by patient
                            System.out.println("Calculating revenue by patient...");
                            patientMenu.viewPatients(); 
                            statistics.revenuePatient(fm.appointments, fm.exams, fm.patients);
                            
                        case 2:
                            // Code to calculate revenue by exam
                            System.out.println("Calculating revenue by exam...");
                            examMenu.showExamsAlphabetically();
                            statistics.revenueExam(fm.appointments, fm.exams);
                            break;
                        case 3:
                            // Code to calculate revenue by appointment
                            System.out.println("Calculating revenue by appointment...");
                            examMenu.showExamsAlphabetically();
                            statistics.revenueAppointments(fm.appointments, fm.exams);
                            
                            break;
                        case 4:
                            System.out.println("Returning to main menu...");
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
