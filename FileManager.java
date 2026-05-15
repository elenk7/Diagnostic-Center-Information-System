import java.io.*;
import java.util.*;

class FileManager {

    HashMap<Integer, Doctor> doctors = new HashMap<>();
    HashMap<Integer, Patient> patients = new HashMap<>();
    HashMap<Integer, Exam> exams = new HashMap<>();
    HashMap<Integer, Appointment> appointments = new HashMap<>();

    void loadFile(String filePath) {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] tokens = line.split(" ");

                for (int i = 0; i < tokens.length; i++) {
                    tokens[i] = tokens[i].trim();
                }

                String type = tokens[0];

                if (type.equals("DOCTOR")) {

                    Doctor doctor = new Doctor(
							tokens[1],
                            tokens[2],
                            tokens[3],
                            Integer.parseInt(tokens[4])
                    );
                    //String name, String phone, String specialty, int experience

                    doctors.put(doctor.getCode(), doctor);
                }

                else if (type.equals("PATIENT")) {

                    Patient patient = new Patient(
							tokens[1],	
                            tokens[2],
                            tokens[3]
                    );

                    patients.put(patient.getCode(), patient);
                }

                else if(type.equals("EXAM")){

                    Exam exam = null;

                    if (tokens[2].equals("Imaging")){
                        exam = new ImagingExamination(tokens[1],
                                                    tokens[2],
                                                    tokens[3],
                                                    Integer.parseInt(tokens[4]),
                                                    Double.parseDouble(tokens[5]),
                                                    Integer.parseInt(tokens[6]));
                    }else if (tokens[2].equals("Microbiological")){
                        exam = new MicrobiologicalExamination(tokens[1],
                                                        tokens[2],
                                                        tokens[3],
                                                        Integer.parseInt(tokens[4]),
                                                        Double.parseDouble(tokens[5]),
                                                        Integer.parseInt(tokens[6]));
    
                    }else if(tokens[2].equals("Specialized")){
                        exam = new SpecializedExamination(tokens[1],
                                                        tokens[2],
                                                        tokens[3],
                                                        Integer.parseInt(tokens[4]),
                                                        Double.parseDouble(tokens[5]),
                                                        Integer.parseInt(tokens[6]));
                    }

                    exams.put(exam.getCode(), exam);
                } 
                else if (type.equals("APPOINTMENT")){
                    Appointment appointment = new Appointment(
                        Integer.parseInt(tokens[1]),
                        Integer.parseInt(tokens[2]),
                        Boolean.parseBoolean(tokens[3]),
                        tokens[4],
                        Boolean.parseBoolean(tokens[5])
                    );
                    appointments.put(appointment.getCode(), appointment);
                }
            }
			
			reader.close(); // κλείσιμο αρχείου

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
		
    }// loadFile

    void storeFile(String filePath) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            if  (filePath.equals("Doctors.txt")){
                for (Doctor doctor : doctors.values()) {
                    writer.write("DOCTOR " + doctor.getName() + " " + doctor.getPhone() + " " + doctor.getSpecialty() + " " + doctor.getExperience() + "\n");
                }
            }
            if (filePath.equals("Patients.txt")){
                for (Patient patient : patients.values()) {
                    writer.write("PATIENT " + patient.getName() + " " + patient.getPhone() + " " + patient.getEmail() + "\n");
                }
            }
            if (filePath.equals("Exams.txt")){
                 for (Exam exam : exams.values()) {
                    writer.write("EXAM " + exam.getExamName() + " " + exam.getCategoryName() + " " + exam.getExamSpecialty() + " " + exam.getMaxSlots() + " " + exam.getCost(appointments) + " " + exam.getDoctorID() + "\n");
                }
            }
            if (filePath.equals("Appointments.txt")){
                 for (Appointment appointment : appointments.values()) {
                    writer.write("APPOINTMENT " + appointment.getPatientID() + " " + appointment.getExamID() + " " + appointment.getFastResults() + " " + appointment.getExamDate() +" "+ appointment.getDeleted() + "\n");
                }
            }
            
        }catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
       
    }// storeFile
        	
	
}

