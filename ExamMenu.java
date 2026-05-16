import java.util.Comparator;
import java.util.HashMap;
public class ExamMenu{
    private HashMap<Integer, Exam> exams = new HashMap<>();

    ExamMenu(HashMap<Integer, Exam> exams){
        this.exams = exams;
    }
    

    public void addExam(Exam exam){
        exams.put(exam.getCode(), exam);
    }

    public void showExamsAlphabetically(){
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

    public void examAppointments(int examID, HashMap<Integer, Appointment> appointments){  // we want to find the appointments for a specific exam, so we check if the examID of the appointment matches the code of the exam, if it does we print the appointment
        boolean found = false;
        for (Exam exam: exams.values()){
            if (exam.getCode() == examID){
                for(Appointment appointment : appointments.values()){
                   if (appointment.getExamID() == examID && appointment.getDeleted() == false){
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