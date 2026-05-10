import java.util.HashMap;
class ImagingExamination extends Exam {
    private String machineType;
    private double cost;
    private double examCost;
    private static final double costIncreaseRate = 0.10;
    private boolean fastResults;
    

    ImagingExamination(int code, String examName, String categoryName, String examSpecialty, int maxSlots, double cost, int doctorID, String machineType) {
        super(code, examName, categoryName, examSpecialty, maxSlots, cost, doctorID);
        this.machineType = machineType;
        this.cost = cost;
    }

    

    public String getMachineType() {
        return this.machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }


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
        return super.toString() + "\nMachine Type: " + this.machineType + "\nCost: " + this.examCost;
    }
}
