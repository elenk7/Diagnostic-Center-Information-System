import java.util.HashMap;
import java.util.HashSet;
public class Statistics{
        public void revenuePatient(HashMap<Integer, Appointment> appointments, HashMap<Integer, Exam> exams, HashMap<Integer, Patient> patients){
                double totalRevenue = 0;
                for ( Patient patient : patients.values()){  //we loop through all the patients
                        double sum = 0;
                        
                        for(Appointment appointment : appointments.values()){  //we loop through all the appointments to check if the patient has any appointments
                                if (appointment.getPatientID() == patient.getCode() && !appointment.getDeleted()){  
                                /*if the patientID of the appointment matches the code of the patient and the appointment 
                                is not deleted we get the cost of the exam and add it to the sum of the patient*/
                                        for (Exam exam:exams.values()){  
                                                if(appointment.getExamID() == exam.getCode()){  
                                                /*we check if the examID of the appointment matches the code of the exam, 
                                                if it does we get the cost of the exam to print it later and add it to the sum of the patient*/
                                                        System.out.println(appointment);  
                                                        System.out.println(exam.getCost(appointments)); //we print the appointment and the cost of the exam for the patient
                                                        sum = sum + exam.getExamCost();
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
                for (Exam exam:exams.values()){  //we loop through all the exams
                        double sumExam = 0;
                        for (Appointment appointment:appointments.values()){ 
                                if(appointment.getExamID() == exam.getCode() && !appointment.getDeleted()){  
                                        System.out.println(appointment);
                                        System.out.println(exam.getCost(appointments)); //we print the appointment and the cost of the exam
                                        sumExam = sumExam + exam.getExamCost(); //we add the cost of the exam to the sum of the exam
                                }
                        }
                        sum = sum + sumExam;
                }
                System.out.println("Total Revenue: " + sum);
        }

        public void revenueExamCategory(HashMap<Integer, Appointment> appointments, HashMap<Integer, Exam> exams) {
                double totalRevenue = 0;
                HashMap<String, Double> categoryRevenue = new HashMap<>(); //we create a HashMap to store the revenue of each category
                for (Exam exam : exams.values()) {
                    double sumCategory = 0;
                    for (Appointment appointment : appointments.values()) {
                        if (appointment.getExamID() == exam.getCode() && !appointment.getDeleted()) {
                            System.out.println(appointment);
                            System.out.println(exam.getCost(appointments));
                            sumCategory = sumCategory + exam.getExamCost();
                        }
                    }
                    categoryRevenue.put(exam.getCategoryName(), categoryRevenue.getOrDefault(exam.getCategoryName(), 0.0) + sumCategory);  //we add the revenue of the exam to the category, if the category does not exist we put 0 as default value
                }
                for (String category : categoryRevenue.keySet()) {  //we loop through the categories and print the revenue of each category and the total revenue
                    System.out.println("Category: " + category + " Revenue: " + categoryRevenue.get(category));
                        totalRevenue = totalRevenue + categoryRevenue.get(category);
                }
                System.out.println("Total Revenue: " + totalRevenue);
            }
}

        
        

