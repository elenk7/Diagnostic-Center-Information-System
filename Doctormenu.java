import java.util.HashMap;
public class Doctormenu{
    private HashMap<Integer, Doctor> doctors = new HashMap<>();

    public void addDoctor(Doctor doctor){
        doctors.put(doctor.getCode(), doctor);
    }

    public Doctor getDoctor(int doctorID){
        return doctors.get(doctorID);
    }

    public void removeDoctor(int doctorID){
        doctors.remove(doctorID);
    }

    public void listAll(){
        if (doctors.isEmpty()){
            System.out.println("No doctors available.");
        } else {
            for (Doctor doctor : doctors.values()) {
                System.out.println(doctor);
            }
        }
    }

    public Doctor searchDoctorCode(int doctorID){
        return doctors.get(doctorID);
    }

    public void searchDoctorappointment(int doctorID, AppointmentMenu appointmentMenu, ExamMenu examMenu){
        Doctor doctor = doctors.get(doctorID);
        if (doctor != null) {
            System.out.println("Appointments for Doctor ID: " + doctorID);
            for (Exam exam : examMenu.getAllExams()) {
                if (exam.getDoctorID() == doctorID) {
                    
                }
            }
        }
    }
}