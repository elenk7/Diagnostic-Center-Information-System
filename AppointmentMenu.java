import java.util.HashMap;
public class AppointmentMenu{
    private HashMap<Integer, Appointment> appointments = new HashMap();

    AppointmentMenu(HashMap<Integer, Appointment> appointments){
        this.appointments = appointments;    
    }
    

    public void addAppointment(Appointment appointment){
        appointments.put(appointment.getCode(), appointment);
    }

    public void showAppointments(){
        if (appointments.isEmpty()){
            System.out.println("No appointments");
        }else {
            for (Appointment appointment: appointments.values()){
                System.out.println(appointment);               
            }     
        }
    }

    public void patientAppointments(int patientID){
        boolean found = false;
        for (Appointment appointment: appointments.values()){
            if (appointment.getPatientID() == patientID){
                System.out.println(appointment);
                found = true;
            }
        }
        if (!found){
            System.out.println("No appointments for patient ID: " + patientID);
        }
    }

    public void removeAppointment(int appointmentCode){
        appointments.remove(appointmentCode);
    }

    public void showAppointmentDay(String date,HashMap<Integer, Exam> exams, HashMap<Integer, Patient> patients){
        boolean found = false;
        String patientName = "";
        String examName = "";
        for(Appointment appointment : appointments.values()){
            if (appointment.getExamDate().equals(date)){
                for (Exam exam : exams.values()){
                    if (exam.getCode() == appointment.getExamID()){  //we check if the examID of the appointment matches the code of the exam, if it does we get the name of the exam to print it later
                        examName = exam.getExamName();
                    }
                }
                for (Patient patient : patients.values()){
                    if (appointment.getPatientID() == patient.getCode()){
                        patientName = patient.getName();
                    }
                }
                System.out.println(appointment + " | Patient Name: " + patientName + " | Exam Name: " + examName);
                found = true;
            }
        }
        if (found==false){
            System.out.println("No appointments for this date: " + date);
        }
    }
}