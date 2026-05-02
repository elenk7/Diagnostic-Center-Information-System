class ImagingExamination extends Exam {
    private String machineType;
    private double cost;
    private double examCost;
    private static final double costIncreaseRate = 0.10;

    ImagingExamination(String code, String examName, String categoryName, String examSpecialty, String maxSlots, double cost, int doctorID, String machineType) {
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

    public double getCost(){
        if (fastResults){
            examCost = cost + (cost * costIncreaseRate);
        }else{
            examCost = cost;
        }   
        return examCost;
    } 
    
    public String toString(){
        return super.toString() + "/nMachine Type: " + this.machineType + "/nCost: " + this.examCost;
    }
}
