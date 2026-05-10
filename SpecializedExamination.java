import java.util.HashMap;
class SpecializedExamination extends Exam{
    private String examSpecialty;
    private double cost;
    private double examCost;
    private static final double costIncreaseRate = 0.30;
    private boolean fastResults;


    SpecializedExamination(String examName, String categoryName, String examSpecialty, int maxSlots, double cost, int doctorID){
        super(examName, categoryName, examSpecialty, maxSlots, cost, doctorID);
        this.cost = cost;
    }

    public String getExamSpecialty() {
        return this.examSpecialty;
    }

    public void setExamSpecialty(String examSpecialty) {
        this.examSpecialty = examSpecialty;
    }

    @Override
    public double getCost(HashMap<Integer, Appointment> appointments){
        for(Appointment appointment : appointments.values()){
            if (this.getCode() == appointment.getExamID()){
                fastResults = appointment.getFastResults();
            }
        }
        if (fastResults){
            examCost = cost + (cost * costIncreaseRate);
        }else{
            examCost = cost;
        }   
        return examCost;
    }

    public String toString(){
        return super.toString() + "\nExam Specialty: " + this.examSpecialty + "\nCost: " + this.examCost;
    }
    
}
