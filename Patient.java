class Patient extends Human {
    private String email;
    private static int idCounter = 1;
    private int code;

    Patient(String name, String phone, String email) {
        super(name, phone);
        this.email = email;
        this.code = idCounter++;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String toString() {
        return "PatientID: " + this.code + "\n" + super.toString() + "\nEmail: " + this.email;
    }

}
