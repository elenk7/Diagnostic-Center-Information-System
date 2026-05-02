public class human {
    private String phone;
    private String name;
    
    public human(String name, String phone) {
        this.name = name;
        this.phone = phone;
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
