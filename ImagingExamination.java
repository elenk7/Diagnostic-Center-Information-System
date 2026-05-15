import java.util.HashMap;
class ImagingExamination extends Exam {
    private String machineType;
    private double cost;
    private static final double costIncreaseRate = 0.10;
    private boolean fastResults;
    

    ImagingExamination(String examName, String categoryName, String machineType, int maxSlots, double cost, int doctorID) {
        super(examName, categoryName, machineType, maxSlots, cost, doctorID);
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
            if (this.getCode() == appointment.getExamID()){  //Checks if the current exam's code matches the exam ID in the appointment. If it does, it retrieves the fast results option from the appointment and stores it in the fastResults variable.
                fastResults = appointment.getFastResults();
            }
        }
        if (fastResults){  //If the fast results option is true, it calculates the exam cost by adding a percentage increase to the base cost and returns the updated exam cost.
            this.cost = cost + (cost * costIncreaseRate);
        }else{
            this.cost = cost;
        }   
        return this.cost;
    } 
    
    public String toString(){
        return super.toString() + " | Machine Type: " + this.machineType + " | Cost: " + this.cost;
    }
}
