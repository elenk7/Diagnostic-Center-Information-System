class SpecializedExamination extends Exam{
    private String examSpecialty;
    private double cost;
    private double examCost;
    private static final double costIncreaseRate = 0.30;


    SpecializedExamination(String examID, String examName, String categoryName, String examSpecialty, String maxSlots, double cost, int doctorID){
        super(examID, examName, categoryName, examSpecialty, maxSlots, cost, doctorID);
        this.examSpecialty = examSpecialty;
        this.cost = cost;
    }

    public String getExamSpecialty() {
        return this.examSpecialty;
    }

    public void setExamSpecialty(String examSpecialty) {
        this.examSpecialty = examSpecialty;
    }

    public double getCost(){
        if (fastResults){
            examCost = cost + (cost * costIncreaseRate);
        }else{
            examCost = cost;
        }   
        return examCost;
    }

    public String toString(){
        return super.toString() + "/nExam Specialty: " + this.examSpecialty + "/nCost: " + this.examCost;
    }
    
}
