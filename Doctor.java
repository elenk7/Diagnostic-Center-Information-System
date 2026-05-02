public class Doctor extends Human{
    private static int idCounter = 1;
    private int code;
    private String specialty;
    private int experience;

    Doctor(String name, String phone, String specialty, int experience){
        Human(name, phone);
        this.code = idCounter++;
        this.specialty = specialty;
        this.experience = experience;
    }

    public String getSpecialty(){
        return this.specialty;
    }

    public int getExperience(){
        this.experience = experience;
    }

    public void setSpecialty(String specialty){
        this.specialty = specialty;
    }

    public void setExperience(int experience){
        this.experience = experience;
    }
}