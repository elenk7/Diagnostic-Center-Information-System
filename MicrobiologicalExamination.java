public class MicrobiologicalExamination extends Exam{
    private double examCost;
    private String sampleType;
    private static final double costIncreaseRate = 0.2;

    MicrobiologicalExamination(String examName, String categoryName, int maxSlots, int doctorID, double cost, String sampleType){
        super(examName, categoryName, maxSlots, doctorID);
        this.examCost = cost;
        this.sampleType = sampleType;
    }

    @Override
    public double getCost(){
        if(fastresults){
            this.examCost = this.examCost + this.examCost * costIncreaseRate;
            return this.examCost;
        }
        return this.examCost;
    }

    public String getSampleType(){
        return this.sampleType;
    }

    public void setSampleType(String sampleType){
        this.sampleType = sampleType;
    }

    @Override
    public String toString(){
        return super.toString() + "/nSample Type: " + this.sampleType + "/nCost: " + this.examCost;
    }
}