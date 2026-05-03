import java.util.HashMap;
public class ExamMenu{
    private HashMap<Integer, Exam> exams = new HashMap<>();

    public void addExam(Exam exam){
        exams.put(exam.getCode(), exam);
    }

    public void showExams(){
        if (exams.isEmpty()){
            System.out.println("No exams");
        }else {
            for (Exam exam: exams.values()){
                System.out.println(exam);    
            }     
        }
    }

    public void examAppointments(int examID){
        boolean found = false;
        for (Exam exam: exams.values()){
            if (exam.getCode() == examID){
                for(Appointment appointment : appointments.values()){
                   if (appointment.getExamID() = examID){
                    System.out.println(appointment);
                    found = true;
                   }    
                }    
            }
        }
        if (!found){
            System.out.println("No appointments for exam ID: " + examID);
        }
        
    }

    
}