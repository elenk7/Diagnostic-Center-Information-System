import java.util.HashMap;
public class MicrobiologicalExamination extends Exam{
    private double cost;
    private String sampleType;
    private static final double costIncreaseRate = 0.2;
    private boolean fastResults;

    MicrobiologicalExamination(String examName, String categoryName, String sampleType,  int maxSlots, double cost, int doctorID){
        /*Constructor for Microbiological Examination class that initializes the exam name, category name, maximum slots, doctor ID, cost, and sample type.
         It also calls the constructor of the superclass Exam to initialize the common attributes of all exams.*/
        super(examName, categoryName, sampleType, maxSlots, cost, doctorID);
        this.cost = cost;
        this.sampleType = sampleType;
    }

    @Override
    public double getCost(HashMap<Integer, Appointment> appointments){
        for(Appointment appointment : appointments.values()){
            if (this.getCode() == appointment.getExamID()){  //Checks if the current exam's code matches the exam ID in the appointment. If it does, it retrieves the fast results option from the appointment and stores it in the fastResults variable.
                fastResults = appointment.getFastResults();
            }
        }
        if(fastResults){  //If the fast results option is true, it calculates the exam cost by adding a percentage increase to the base cost and returns the updated exam cost.
            this.cost = this.cost + this.cost * costIncreaseRate;
            return this.cost;
        }
        return this.cost;  //If the fast results option is false, it simply returns the base exam cost without any modifications.
    }

    public String getSampleType(){
        return this.sampleType;
    }

    public void setSampleType(String sampleType){
        this.sampleType = sampleType;
    }

    @Override
    public String toString(){
        return super.toString() + " | Sample Type: " + this.sampleType + " | Cost: " + this.cost;
    }
}