import java.util.HashMap;
public class MicrobiologicalExamination extends Exam{
    private double examCost;
    private String sampleType;
    private static final double costIncreaseRate = 0.2;
    private boolean fastResults;

    MicrobiologicalExamination(String examName, String categoryName, String sampleType,  int maxSlots, double cost, int doctorID){
        /*Constructor for Microbiological Examination class that initializes the exam name, category name, maximum slots, doctor ID, cost, and sample type.
         It also calls the constructor of the superclass Exam to initialize the common attributes of all exams.*/
        super(examName, categoryName, sampleType, maxSlots, cost, doctorID);
        this.examCost = cost;
        this.sampleType = sampleType;
    }

    @Override
    public double getCost(HashMap<Integer, Appointment> appointments){
        for(Appointment appointment : appointments.values()){
            if (this.getCode() == appointment.getExamID()){
                fastResults = appointment.getFastResults();
            }
        }
        if(fastResults){
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