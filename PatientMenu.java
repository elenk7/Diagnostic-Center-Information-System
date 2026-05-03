import java.util.HashMap;
import java.util.Scanner;

class PatientMenu {
    private HashMap<Integer, Patient> patients= new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void displayPatientMenu() {

         private boolean back=true;

         while (back) {
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. View details of a specific patient");
            System.out.println("4. Back to Main Menu");
       
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    public void addPatient(){
                        Patient patient = new Patient();
                        patients.put(patient.getCode(), patient);
                        System.out.println("Patient added successfully. Patient ID: " + patient.getCode());
                    }
                case 2:
                    public void viewPatients(){
                        if (patients.isEmpty()) {
                            System.out.println("No patients found.");
                        } else {
                            for (Patient patient : patients.values()) {
                                System.out.println(patient);
                            }
                        }
                    }
                case 3:
                    public void findByCode(int code){ 
                        Patient patient = patients.get(code);
                        if (patient != null) {
                            System.out.println(patient);
                        } else {
                            System.out.println("Patient not found.");
                        }
                    }
                case 4:
                    back = false;    
            } 
        }
    }                
    
}
