import java.util.HashMap;

class PatientMenu {
    private HashMap<Integer, Patient> patients= new HashMap<>();

    PatientMenu(HashMap<Integer, Patient> patients){
        this.patients = patients;
    }
   
    public void addPatient(Patient patient){
        patients.put(patient.getCode(), patient);
    }
               
    public void viewPatients(){
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            for (Patient patient : patients.values()) {
                System.out.println(patient);
            }
        }
    }
                
    public void findByCode(int code, HashMap<Integer, Appointment> appointments ){ 
        Patient patient = patients.get(code);
        if (patient != null) {
            System.out.println(patient);
            for (Appointment appointment : appointments.values()){
                if (appointment.getPatientID() == code && !appointment.getDeleted()) {
                    System.out.println(appointment);
                }
            }
        } else {
             System.out.println("Patient not found.");
        }
    }                
} 
