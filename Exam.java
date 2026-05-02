abstract class Exam{
<<<<<<< Updated upstream
    private String examID;
    private String examName;
    private String categoryName;
    private String examSpecialty;
    private String maxSlots;
    private double cost;
    private int doctorID;

    abstract double getCost();

    Exam(String examID, String examName, String categoryName, String examSpecialty, String maxSlots, double cost, int doctorID){
        this.examID = examID;
        this.examName = examName;
        this.categoryName = categoryName;
        this.examSpecialty = examSpecialty;
        this.maxSlots = maxSlots;
        this.cost = cost;
        this.doctorID = doctorID;
    }

    public void setExamID(String examID) {
        this.examID = examID;
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
    public void setMaxSlots(String maxSlots) {
        this.maxSlots = maxSlots;
    }
   
    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public String getExamID() {
        return this.examID;
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

    public String getMaxSlots() {
        return this.maxSlots;
    }

    public int getDoctorID() {
        return this.doctorID;
    }

=======
    private static int idCounter;
    private int code;
    private String examName;
    private String categoryName;
    private int maxSlots;
    private int doctorID;

    Exam(String examName, String categoryName, int maxSlots, int doctorID){
        this.code = code;
        this.examName = examName;
        this.categoryName = categoryName;
        this.maxSlots = maxSlots;
        this.doctorID = doctorID;
    }

    public String getExamName(){
        return this.examName;
    }

    public String getCategoryName(){
        return this.categoryName;
    }
    
    public int getCode(){
        this.code = code;
    }

    public int getMaxSlots(){
        this.maxSlots = maxSlots;
    }

    public abstract double getCost();

    @Override
    public String toString(){
        return "AppointmentID: " + this.code + "/nExam Name: " + this.examName + "/nCategory Name: " + this.categoryName + "/nMax Slots per Day: " + this.maxSlots + "/nDoctorID: " + this.doctorID;
    }
>>>>>>> Stashed changes
}