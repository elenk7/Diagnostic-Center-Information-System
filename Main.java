import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args){
        FileManager fm= new FileManager();
        String patientsFilePath = "Patients.txt"; // Define file paths for patients, doctors, exams, and appointments data files. These file paths are used to create File objects and to load data into the system using the FileManager class. The file paths are specified as strings and can be modified to point to the correct location of the data files on the system.
        String doctorsFilePath = "Doctors.txt";
        String examsFilePath = "Exams.txt";
        String appointmentsFilePath = "Appointments.txt";
        File patientsFile = new File(patientsFilePath);  // Create File objects for each of the data files (patients, doctors, exams, appointments). These File objects are used to check if the files exist and to read/write data from/to them. The file paths are specified as strings and passed to the File constructor to create the corresponding File objects.
        File doctorsFile = new File(doctorsFilePath);
        File examsFile = new File(examsFilePath);
        File appointmentsFile = new File(appointmentsFilePath);
        PatientMenu patientMenu = new PatientMenu(fm.patients); // Create instances of the menu classes (PatientMenu, DoctorMenu, ExamMenu, AppointmentMenu) and the Statistics class. These instances are initialized with the corresponding HashMaps from the FileManager class (patients, doctors, exams, appointments) to allow them to manage and manipulate the data effectively. The menu classes provide methods for adding, viewing, and finding patients, doctors, exams, and appointments, while the Statistics class provides methods for calculating revenue based on patients, exams, and appointments.
        DoctorMenu doctorMenu = new DoctorMenu(fm.doctors);
        ExamMenu examMenu = new ExamMenu(fm.exams);
        AppointmentMenu appointmentMenu = new AppointmentMenu(fm.appointments);
        Statistics statistics = new Statistics();
        boolean exit=true;
        fm.loadFile(patientsFilePath);  // Load data from files into the system using the FileManager class. The loadFile method reads the specified file and populates the corresponding HashMaps (doctors, patients, exams, appointments) with the data. This allows the system to have access to the existing data when managing patients, doctors, exams, appointments, and statistics.
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
                            name = scanner.nextLine();
                            System.out.println("Enter patient phone:");
                            String phone = scanner.nextLine();
                            System.out.println("Enter patient email:");
                            String email = scanner.nextLine();
                            Patient p = new Patient(name, phone, email);
                            patientMenu.addPatient(p);
                            fm.storeFile(patientsFilePath);
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
                    System.out.println("5. Return");
                    int doctorChoice = new java.util.Scanner(System.in).nextInt();
                    switch (doctorChoice) {
                        case 1:
                            // Code to add doctor
                            System.out.println("Adding a new doctor...");
                            System.out.println("Enter doctor name:");
                            String name = scanner.nextLine();
                            name = scanner.nextLine();
                            System.out.println("Enter doctor phone:");
                            String phone = scanner.nextLine();
                            System.out.println("Enter doctor specialty(Cardiology, Microbiology, Radiology, Neurology):");
                            String specialty = scanner.nextLine();
                            System.out.println("Enter doctor experience:");
                            int experience = scanner.nextInt();
                            Doctor d = new Doctor(name, phone, specialty, experience);
                            doctorMenu.addDoctor(d);
                            fm.storeFile(doctorsFilePath);
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
                            examName = scanner.nextLine();
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
                            switch (espec) {  // Switch statement to determine the type of exam being added based on user input. Depending on the category selected, it prompts the user for additional information specific to that category (e.g., machine type for Imaging, sample type for Microbiological, exam specialty for Specialized) and creates an instance of the corresponding exam class (ImagingExamination, MicrobiologicalExamination, or SpecializedExamination). The newly created exam is then added to the exam menu and its cost is calculated based on the appointments.
                                case 1:
                                    categoryName = "Imaging";
                                    System.out.println("Enter machine type:");
                                    String machineType = scanner.nextLine();
                                    machineType = scanner.nextLine();
                                    ImagingExamination e = new ImagingExamination(examName, categoryName, machineType, maxSlots, cost, doctorID);
                                    examMenu.addExam(e);
                                    e.getCost(fm.appointments);
                                    fm.storeFile(examsFilePath);
                                    break;
                                case 2:
                                    categoryName = "Microbiological";
                                    System.out.println("Enter sample type:");
                                    String sampleType = scanner.nextLine();
                                    sampleType = scanner.nextLine();
                                    MicrobiologicalExamination m = new MicrobiologicalExamination(examName, categoryName, sampleType, maxSlots, cost, doctorID);
                                    examMenu.addExam(m);
                                    m.getCost(fm.appointments);
                                    fm.storeFile(examsFilePath);
                                    break;
                                case 3:
                                    categoryName = "Specialized";
                                    System.out.println("Enter exam spexialty:");
                                    String examSpecialty = scanner.nextLine();
                                    examSpecialty = scanner.nextLine();
                                    SpecializedExamination s = new SpecializedExamination(examName, categoryName, examSpecialty, maxSlots, cost, doctorID);
                                    examMenu.addExam(s);
                                    s.getCost(fm.appointments);
                                    fm.storeFile(examsFilePath);
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
                                
                                boolean validDate = false;
                                while (!validDate) {
                                        if (!examDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
                                            System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
                                            examDate = scanner.next();
                                            continue;
                                        }
                                    int sum = 0;
                                    Exam exam = fm.exams.get(eID);
                                    if (exam != null) {
                                        int maxSlots = exam.getMaxSlots();
                                        for (Appointment appointment : fm.appointments.values()) {
                                            if (appointment.getExamID() == eID &&
                                                appointment.getExamDate().equals(examDate) &&
                                                !appointment.getDeleted()) {
                                                sum++;
                                            }
                                        }
                                        if (sum >= maxSlots) {
                                            System.out.println("Reached max slots. Choose another date.");
                                            examDate = scanner.next();
                                            continue;
                                        }
                                    }
                                    validDate = true; 
                                }
                                if (validDate) {    
                                    Appointment a = new Appointment(id, eID, fR, examDate, false);
                                    appointmentMenu.addAppointment(a);
                                    fm.storeFile(appointmentsFilePath);
                                    break;
                                }
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
                                if (fm.appointments.containsKey(code)){  // Check if appointment exists
                                    fm.appointments.get(code).setDeleted(true);
                                    System.out.println("Appointment removed.");
                                }
                                fm.storeFile(appointmentsFilePath);
                                break;
                            case 5:
                                // Find Appointment by date
                                System.out.println("Enter date (YYYY-MM-DD):");
                                String date = scanner.next();
                                while (!date.matches("\\d{4}-\\d{2}-\\d{2}")) {  // Validate date format
                                    System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
                                    date = scanner.next();
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
                    System.out.println("3. Revenue by Exam Category");
                    System.out.println("4. Return");
                    int statisticsChoice = new java.util.Scanner(System.in).nextInt();
                    switch (statisticsChoice) {
                        case 1:
                            // Code to calculate revenue by patient
                            System.out.println("Calculating revenue by patient...");
                            patientMenu.viewPatients(); 
                            statistics.revenuePatient(fm.appointments, fm.exams, fm.patients);
                            break;
                        case 2:
                            // Code to calculate revenue by exam
                            System.out.println("Calculating revenue by exam...");
                            examMenu.showExamsAlphabetically();
                            statistics.revenueExam(fm.appointments, fm.exams);
                            break;
                        case 3:
                            // Code to calculate revenue by category
                            System.out.println("Calculating revenue by category...");
                            examMenu.showExamsAlphabetically();
                            statistics.revenueExamCategory(fm.appointments, fm.exams);
                            
                            break;
                        case 4:
                            System.out.println("Returning to main menu...");
                            break;
                        default:
                            System.out.println("Invalid option. Returning to main menu.");
                            break;
                    }
                    
                    
                    break;
                case 6:
                    exit = false;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
        

        
    }
}
