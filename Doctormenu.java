import java.util.HashMap;
public class DoctorMenu{
    private HashMap<Integer, Doctor> doctors = new HashMap<>();

    DoctorMenu(HashMap<Integer, Doctor> doctors){
        this.doctors = doctors;
    }

    public void addDoctor(Doctor doctor){
        doctors.put(doctor.getCode(), doctor);
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

    public void searchDoctorExam(int doctorID, HashMap<Integer, Exam> exams){
        for(Exam exam : exams.values()){
            if (exam.getDoctorID() == doctorID){
                System.out.println(exam);
            }
        }
    }
    

    public void searchDoctorAppointment(int doctorID, HashMap<Integer, Appointment> appointments, HashMap<Integer, Exam> exams){
        Doctor doctor = doctors.get(doctorID);
        if (doctor != null) {
            System.out.println("Appointments for Doctor ID: " + doctorID);
            for (Exam exam : exams.values()) {
                for (Appointment appointment : appointments.values()){
                    if (!appointment.getDeleted()) {
                        if (exam.getCode() == appointment.getExamID()) {
                            System.out.println(appointment);
                        }
                    }
                }   
                
            }
        }else{
            System.out.println("No doctors with this ID: " + doctorID);
        }
    }
}
