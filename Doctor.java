public class Doctor extends Human{
    private static int idCounter = 1;
    private int code;
    private String specialty;
    private int experience;

    Doctor(String name, String phone, String specialty, int experience){
        super(name, phone);
        this.code = idCounter++;
        this.specialty = specialty;
        this.experience = experience;
    }

    public int getCode(){
        return this.code;
    }

    public void setCode(){
        this.code = code;
    }

    public String getSpecialty(){
        return this.specialty;
    }

    public int getExperience(){
        return this.experience;
    }

    public void setSpecialty(String specialty){
        this.specialty = specialty;
    }

    public void setExperience(int experience){
        this.experience = experience;
    }

    @Override
    public String toString(){
        return super.toString() + "\nDoctorID: " + this.code + "\nSpecialty: " + this.specialty + "\nYears of Experience: " + this.experience;
    }
}