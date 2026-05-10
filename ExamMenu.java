import java.util.Comparator;
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
                // Παίρνει όλα τα Item από το products,
		    exams.values() 
		
			// μετατρέπει τη συλλογή σε stream,
			.stream()
			
			// τα ταξινομεί αλφαβητικά με βάση τον τίτλο,
			.sorted(Comparator.comparing(Exam::getExamName, String.CASE_INSENSITIVE_ORDER)) 
			
			// και τα εμφανίζει.
			.forEach(System.out::println);        
        }
    }

    public void examAppointments(int examID, HashMap<Integer, Appointment> appointments){
        boolean found = false;
        for (Exam exam: exams.values()){
            if (exam.getCode() == examID){
                for(Appointment appointment : appointments.values()){
                   if (appointment.getExamID() == examID){
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