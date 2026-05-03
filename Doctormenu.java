import java.util.HashMap;
public class Doctormenu{
    private HashMap<Integer, Doctor> doctors = new HashMap<>();

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

    public void searchDoctorExam(int doctorID, ExamMenu exams){
        for(Exam exam : exams.values()){
            if (exam.getDoctorID() == doctorID){
                System.out.println(exam);
            }
        }
    }
    

    public void searchDoctorAppointment(int doctorID, AppointmentMenu appointments, ExamMenu exams){
        Doctor doctor = doctors.get(doctorID);
        if (doctor != null) {
            System.out.println("Appointments for Doctor ID: " + doctorID);
            for (Exam exam : exams.values()) {
                for (Appointment appointment : appointments.values()){
                    if (exam.getCode() == appointment.getExamID()) {
                        System.out.println(appointment);
                    }
                }
                
            }
        }else{
            System.out.println("No doctors with this ID: " + doctorID);
        }
    }
}