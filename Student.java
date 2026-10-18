public class Student {
    // call the identify
    private String id;
    private String fullName;
    private String email;
    private String phone;
    private double gpa;

    // Constructor without parameters
    public Student() {
    }

    // Constructor with all parameters
    public Student(String id, String fullName, String email,
                   String phone, double gpa) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.gpa = gpa;
    }

    // Getters and setters for
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    // Display student information
    public void displayData() {
        System.out.printf("%-12s %-25s %-25s %-15s %.2f%n",
                id, fullName, email, phone, gpa);
    }
}