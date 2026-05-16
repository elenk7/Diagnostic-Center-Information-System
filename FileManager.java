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

            while ((line = reader.readLine()) != null) {  // we read the file line by line

                String[] tokens = line.split(" ");

                for (int i = 0; i < tokens.length; i++) {
                    tokens[i] = tokens[i].trim(); // we trim the tokens to remove any leading or trailing whitespace
                }

                String type = tokens[0];  // the first token of each line indicates the type of the object we want to create (Doctor, Patient, Exam, Appointment)

                if (type.equals("DOCTOR")) {

                    Doctor doctor = new Doctor(  // we create a new doctor object with the information from the file
							tokens[1],
                            tokens[2],
                            tokens[3],
                            Integer.parseInt(tokens[4])
                    );
                    //String name, String phone, String specialty, int experience

                    doctors.put(doctor.getCode(), doctor);  // we put the doctor in the doctors HashMap with the code as key and the doctor object as value
                }

                else if (type.equals("PATIENT")) {

                    Patient patient = new Patient(  // we create a new patient object with the information from the file
							tokens[1],	
                            tokens[2],
                            tokens[3]
                    );

                    patients.put(patient.getCode(), patient);  // we put the patient in the patients HashMap with the code as key and the patient object as value
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

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {  // we use try-with-resources to ensure the writer is closed properly
            if  (filePath.equals("Doctors.txt")){
                for (Doctor doctor : doctors.values()) {
                    writer.write("DOCTOR " + doctor.getName() + " " + doctor.getPhone() + " " + doctor.getSpecialty() + " " + doctor.getExperience() + "\n");  //we write the doctor information in the file in the same format as we read it
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

