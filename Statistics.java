import java.util.HashMap;
import java.util.HashSet;
public class Statistics{
        public void revenuePatient(HashMap<Integer, Appointment> appointments, HashMap<Integer, Exam> exams, HashMap<Integer, Patient> patients){
                double totalRevenue = 0;
                for ( Patient patient : patients.values()){
                        double sum = 0;
                        
                        for(Appointment appointment : appointments.values()){
                                if (appointment.getPatientID() == patient.getCode() && !appointment.getDeleted()){
                                        for (Exam exam:exams.values()){
                                                if(appointment.getExamID() == exam.getCode()){
                                                        System.out.println(appointment);
                                                        System.out.println(exam.getCost(appointments));
                                                        sum = sum + exam.getCost(appointments);
                                                }
                                        }
                                }
                        
                        }
                        System.out.println("Patient: " + patient.getName() + " Revenue: " + sum);
                        totalRevenue = totalRevenue + sum;
                }
                System.out.println("Total Revenue: " + totalRevenue + "\n");
        }
        
        public void revenueExam(HashMap<Integer, Appointment> appointments, HashMap<Integer, Exam> exams){
                double sum = 0;
                for (Exam exam:exams.values()){
                        double sumExam = 0;
                        for (Appointment appointment:appointments.values()){
                                if(appointment.getExamID() == exam.getCode() && !appointment.getDeleted()){
                                        System.out.println(appointment);
                                        System.out.println(exam.getCost(appointments));
                                        sumExam = sumExam + exam.getCost(appointments);
                                }
                        }
                        sum = sum + sumExam;
                }
                System.out.println("Total Revenue: " + sum);
        }

        public void revenueExamCategory(HashMap<Integer, Appointment> appointments, HashMap<Integer, Exam> exams) {
                double totalRevenue = 0;
                HashMap<String, Double> categoryRevenue = new HashMap<>();
                for (Exam exam : exams.values()) {
                    double sumCategory = 0;
                    for (Appointment appointment : appointments.values()) {
                        if (appointment.getExamID() == exam.getCode() && !appointment.getDeleted()) {
                            System.out.println(appointment);
                            System.out.println(exam.getCost(appointments));
                            sumCategory = sumCategory + exam.getCost(appointments);
                        }
                    }
                    categoryRevenue.put(exam.getCategoryName(), categoryRevenue.getOrDefault(exam.getCategoryName(), 0.0) + sumCategory);
                }
                for (String category : categoryRevenue.keySet()) {
                    System.out.println("Category: " + category + " Revenue: " + categoryRevenue.get(category));
                        totalRevenue = totalRevenue + categoryRevenue.get(category);
                }
                System.out.println("Total Revenue: " + totalRevenue);
            }
}

        
        

