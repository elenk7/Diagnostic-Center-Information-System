import java.util.HashMap;
class SpecializedExamination extends Exam{
    private String examSpecialty;
    private double cost;
    private static final double costIncreaseRate = 0.30;
    private boolean fastResults;


    SpecializedExamination(String examName, String categoryName, String examSpecialty, int maxSlots, double cost, int doctorID){
        super(examName, categoryName, examSpecialty, maxSlots, cost, doctorID);
        this.examSpecialty = examSpecialty;
        this.cost = cost;
    }

    public String getExamSpecialty() {
        return this.examSpecialty;
    }

    public void setExamSpecialty(String examSpecialty) {
        this.examSpecialty = examSpecialty;
    }
    public double getExamCost(){
        return this.cost;
    }

    @Override
    public double getCost(HashMap<Integer, Appointment> appointments){
        for(Appointment appointment : appointments.values()){
            if (this.getCode() == appointment.getExamID()){  //Checks if the current exam's code matches the exam ID in the appointment. If it does, it retrieves the fast results option from the appointment and stores it in the fastResults variable.
                fastResults = appointment.getFastResults();
            }
        }
        if (fastResults){  //If the fast results option is true, it calculates the exam cost by adding a percentage increase to the base cost and returns the updated exam cost.
            cost = cost + (cost * costIncreaseRate);
        }else{
            cost = cost;
        }   
        return cost;
    }

    public String toString(){
        return super.toString() + " | Exam Specialty: " + this.examSpecialty + " | Cost: " + this.cost;
    }
    
}
