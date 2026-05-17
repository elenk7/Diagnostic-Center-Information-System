import java.util.HashMap;
abstract class Exam{
    private static int idCounter = 1;
    private String examName;
    private String categoryName;
    private String examSpecialty;
    private int maxSlots;
    private double cost;
    private int doctorID;
    private boolean fastResults;
    private int code;

    abstract double getCost(HashMap<Integer, Appointment> appointments);

    Exam(String examName, String categoryName, String examSpecialty, int maxSlots, double cost, int doctorID){
        this.code = idCounter++;
        this.examName = examName;
        this.categoryName = categoryName;
        this.examSpecialty = examSpecialty;
        this.maxSlots = maxSlots;
        this.cost = cost;
        this.doctorID = doctorID;
    }

    public void setCode(int code) {
        this.code = code;
    }
    public void setExamName(String examName) {
        this.examName = examName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public void setExamSpecialty(String examSpecialty) {
        this.examSpecialty = examSpecialty;
    }
    public void setMaxSlots(int maxSlots) {
        this.maxSlots = maxSlots;
    }
    public double getExamCost(){
        return this.cost;
    }
   
    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public int getCode() {
        return this.code;
    }

    public String getExamName() {
        return this.examName;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public String getExamSpecialty() {
        return this.examSpecialty;
    }

    public int getMaxSlots() {
        return this.maxSlots;
    }

    public int getDoctorID() {
        return this.doctorID;
    }

    @Override
    public String toString(){
        return "| ExamID: " + this.code + " | Exam Name: " + this.examName + " | Category Name: " + this.categoryName + " | Max Slots per Day: " + this.maxSlots + " | DoctorID: " + this.doctorID;
    }

    public boolean findFastResults(int examID, HashMap<Integer, Appointment> appointments){
        for(Appointment appointment : appointments.values()){
            if(appointment.getExamID() == examID){
                return appointment.getFastResults();
            }
        }
        return false;
    }
}