import java.util.HashMap;
public class Statistics{
        public double revenuePatient(int patientID, HashMap<Integer, Appointment> appointments, HashMap<Integer, Exam> exams){
                double sum = 0;
                for(Appointment appointment : appointments.values()){
                        if (appointment.getPatientID() == patientID){
                                for (Exam exam:exams.values()){
                                        if(appointment.getExamID() == exam.getCode()){
                                                sum = sum + exam.getCost(appointments);
                                        }
                                }
                        }
                }

                return sum;
                

        }
        public double revenueAllPatients(HashMap<Integer, Appointment> appointments, HashMap<Integer, Exam> exams, HashMap<Integer, Patient> patients){
                double sum = 0;
                for (Patient patient : patients.values()){
                        sum = sum + revenuePatient(patient.getCode(), appointments, exams);
                }
                return sum;

        }
        public double revenueAppointments(int examID, HashMap<Integer, Appointment> appointments, HashMap<Integer, Exam> exams){
                double sum = 0;
                Exam exam = exams.get(examID);
                for(Appointment appointment : appointments.values()){              
                        if (appointment.getExamID() == examID){
                                sum = sum + exam.getCost(appointments);
                        }
                }
                return sum;
        }

        public double revenueAllAppointments(HashMap<Integer, Appointment> appointments, HashMap<Integer, Exam> exams){
                double sum = 0;
                for (Exam exam : exams.values()){
                        sum = sum + revenueAppointments(exam.getCode(), appointments, exams);
                }
                return sum;
        }

        public double revenueExam(String category, HashMap<Integer, Appointment> appointments, HashMap<Integer, Exam> exams){
                double sum = 0;
                if(category.equals("Imaging")){
                        for (Exam exam:exams.values()){
                                if (exam.getCategoryName().equals(category)){
                                        sum = sum + exam.getCost(appointments);
                                }
                        }
                        return sum;
                }else if(category.equals("Microbiological")){
                        for (Exam exam:exams.values()){
                                if (exam.getCategoryName().equals(category)){
                                        sum = sum + exam.getCost(appointments);
                                }
                        }
                        return sum;
                }else if(category.equals("Specialized")){
                        for (Exam exam:exams.values()){
                                if (exam.getCategoryName().equals(category)){
                                        sum = sum + exam.getCost(appointments);
                                }
                        }
                        return sum;
                }
                return 0;
        }

        public double revenueAllExams( HashMap<Integer, Appointment> appointments, HashMap<Integer, Exam> exams){
                double sum=0;
                for (Exam exam:exams.values()){
                        sum = sum + exam.getCost(appointments);
                }
                return sum;
        }

        
}
