public class Appointment{
    private static int idCounter = 1;
    private int code;
    private int patientID;
    private int examID;
    private boolean fastResults;
    private String examDate;
    private boolean deleted;

    Appointment(int patientID, int examID, boolean fastResults, String examDate, boolean deleted){
        this.code = idCounter++;
        this.patientID = patientID;
        this.examID = examID;
        this.fastResults = fastResults;
        this.examDate = examDate;
        this.deleted = deleted;
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

    public boolean getDeleted(){
        return this.deleted;
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

    public void setDeleted(boolean deleted){
        this.deleted = deleted;
    }

    @Override
    public String toString(){
        return "| Appointment Code: " + this.code + " | Patient ID: " + this.patientID + " | Exam ID: " + this.examID + " | Fast Results: " + this.fastResults + " | Exam Date: " + this.examDate;
    }

}