abstract class Exam{
    private String code;
    private String examName;
    private String categoryName;
    private String examSpecialty;
    private int maxSlots;
    private double cost;
    private int doctorID;


    abstract double getCost();

    Exam(String code, String examName, String categoryName, String examSpecialty, String maxSlots, double cost, int doctorID){
        this.code = code;
        this.examName = examName;
        this.categoryName = categoryName;
        this.examSpecialty = examSpecialty;
        this.maxSlots = maxSlots;
        this.cost = cost;
        this.doctorID = doctorID;
    }

    public void setCode(String code) {
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
    public void setMaxSlots(String maxSlots) {
        this.maxSlots = maxSlots;
    }
   
    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public String getCode() {
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
        return "AppointmentID: " + this.code + "\nExam Name: " + this.examName + "\nCategory Name: " + this.categoryName + "\nMax Slots per Day: " + this.maxSlots + "\nDoctorID: " + this.doctorID;
    }

}