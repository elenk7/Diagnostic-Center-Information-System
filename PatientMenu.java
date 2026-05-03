import java.util.HashMap;

class PatientMenu {
    private HashMap<Integer, Patient> patients= new HashMap<>();
   
    public void addPatient(){
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
                
    public void findByCode(int code){ 
        Patient patient = patients.get(code);
        if (patient != null) {
            for (Appointment appointment : appointments.values()){
                if (appointment.getPatientID() == code) {
                    System.out.println(appointment);
                }
            }
        } else {
             System.out.println("Patient not found.");
        }
    }                
} 
