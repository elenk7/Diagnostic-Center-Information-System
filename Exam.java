abstract class Exam{
    private static int idCounter = 1;
    private int code;
    private String examName;
    private String categoryName;
    private int maxSlots;
    private int doctorID;

    Exam(String examName, String categoryName, int maxSlots, int doctorID){
        this.code = idCounter++;
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

    public int getMaxSlots(){
        return this.maxSlots;
    }

    public int getCode(){
        return this.code;
    }

    public int getDoctorID(){
        return this.doctorID;
    }
    
    public void setCode(int code){
        this.code = code;
    }

    public void setExamName(String examName){
        this.examName = examName;
    }

    public void setCategoryName(String categoryName){
        this.categoryName = categoryName;
    }

    public void setDoctorID(int doctorID){
        this.doctorID = doctorID;
    }

    public void setMaxSlots(int maxSlots){
        this.maxSlots = maxSlots;
    }

    public abstract double getCost();

    @Override
    public String toString(){
        return "AppointmentID: " + this.code + "/nExam Name: " + this.examName + "/nCategory Name: " + this.categoryName + "/nMax Slots per Day: " + this.maxSlots + "/nDoctorID: " + this.doctorID;
    }
}