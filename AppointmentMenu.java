import java.util.HashMap;
public class AppointmentMenu{
    private HashMap<Integer, Appointment> appointments = new HashMap();

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

    public void showAppointmentDay(String date){
        boolean found = false;
        for(Appointment appointment : appointments.values()){
            if (appointment.getExamDate() == date){
                System.out.println(appointment);
                found = true;
            }
        }
        if (!found){
            System.out.println("No appointments for this date: " + date);
        }
    }
}