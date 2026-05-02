public class Appointment{
    private static int idCounter = 1;
    private int code;
    private int patientID;
    private int examID;
    private boolean fastResults;
    private String examDate;

    Appointment(int patientID, int examID, boolean fastResults, String examDate){
        this.code = idCounter++;
        this.patientID = patientID;
        this.examID = examID;
        this.fastResults = fastResults;
        this.examDate = examDate;
    }

    public int getCode(){
        return this.code;
    }

    public int getPatientID(){
        return this.patientID;
    }

    public int getExamID(){
        return this.examID;
    }

    public boolean getFastResults(){
        return this.fastResults;
    }

    public String getExamDate(){
        return this.examDate;
    }

    public void setPatientID(int patientID){
        this.patientID = patientID;
    }

    public void setExamID(int examID){
        this.examID = examID;
    }

    public void setFastResults(boolean fastResults){
        this.fastResults = fastResults;
    }

    public void setExamDate(String examDate){
        this.examDate = examDate;
    }

    @Override
    public String toString(){
        return "Appointment Code: " + this.code + "/nPatient ID: " + this.patientID + "/nExam ID: " + this.examID + "/nFast Results: " + this.fastResults + "/nExam Date: " + this.examDate;
    }

}