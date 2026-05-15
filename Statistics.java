import java.util.HashMap;
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
        
        public void revenueAppointments(HashMap<Integer, Appointment> appointments, HashMap<Integer, Exam> exams){
                double total=0;
                for(Appointment appointment : appointments.values()){
                        double sum=0;
                        for (Exam exam:exams.values()){
                                if(appointment.getExamID() == exam.getCode() && !appointment.getDeleted()){
                                        for (Exam exam1:exams.values()){
                                                if(appointment.getExamID() == exam1.getCode()){
                                                        sum = sum + exam1.getCost(appointments);
                                                }
                                        }
                                }
                        } 
                        System.out.println(appointment + " Revenue: " + sum);
                        total = total + sum;
                             
                }
                
                System.out.println("Total Revenue: " + total);
        }

        public void revenueExam(HashMap<Integer, Appointment> appointments, HashMap<Integer, Exam> exams){

                double totalRevenue = 0;

                for(Exam examCategory : exams.values()){

                        double sum = 0;

                        System.out.println("\nCategory: " + examCategory.getCategoryName());

                        for(Appointment appointment : appointments.values()){

                                if(!appointment.getDeleted()){

                                        for(Exam exam : exams.values()){

                                                if(appointment.getExamID() == exam.getCode()){

                                                        if(exam.getCategoryName().equals(examCategory.getCategoryName())){

                                                                 System.out.println(appointment);
                                                                System.out.println(exam.getCost(appointments));

                                                                sum = sum + exam.getCost(appointments);
                                                        }
                                                }
                                        }
                                }
                        }

                        System.out.println("Category Revenue: " + sum);

                        totalRevenue = totalRevenue + sum;
                }

                System.out.println("Total Revenue: " + totalRevenue);
        }
        
}
