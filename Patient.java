class Patient extends Human {
    private String email;

    Patient(String name, String phone, String email) {
        super(name, phone);
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return super.toString() + "\nEmail:" + this.email;
    }
    
}
