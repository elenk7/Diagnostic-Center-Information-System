public class Human{
    private String name;
    private String phone;

    Human(String name, String phone){
=======
class Human {
    private String phone;
    private String name;
    
    Human(String name, String phone) {
>>>>>>> b7406e70ce036357444474a10d95e4d5c42cfaf5
        this.name = name;
        this.phone = phone;
    }

<<<<<<< HEAD
    public String getName(){
        return this.name;
    }

    public String getPhone(){
        return this.phone;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String toString(){
        return "Name:" + this.name + "/nPhone" + this.phone;
    }
}}
=======
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Name: " + name + ", Phone: " + phone;
    }
}
>>>>>>> b7406e70ce036357444474a10d95e4d5c42cfaf5
