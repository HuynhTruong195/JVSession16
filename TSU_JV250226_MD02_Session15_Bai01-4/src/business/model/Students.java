package business.model;

public class Students {
    private int student_Id;
    private String full_name;
    private String date_of_birth;
    private String email;

    public Students() {
    }

    public Students(int student_Id, String full_name, String date_of_birth, String email) {
        this.student_Id = student_Id;
        this.full_name = full_name;
        this.date_of_birth = date_of_birth;
        this.email = email;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public int getStudent_Id() {
        return student_Id;
    }

    public void setStudent_Id(int student_Id) {
        this.student_Id = student_Id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Students{" +
                "student_Id=" + student_Id +
                ", full_name='" + full_name + '\'' +
                ", date_of_birth='" + date_of_birth + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
