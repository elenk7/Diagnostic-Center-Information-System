class Human {

    private String phone;
    private String name;
    
    Human(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

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
        return "| Name:" + this.name + " | Phone:" + this.phone;
    }
}
