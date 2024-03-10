package lab2;

/**
 * Student
 */
public class Student {
    String name;
    String qualification;
    String hobby;
    String address;
    String sex;

    public void setName(String name) {
        this.name = name;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getQualification() {
        return qualification;
    }

    public String getHobby() {
        return hobby;
    }

    public String getAddress() {
        return address;
    }

    public String getSex() {
        return sex;
    }

    public Student() {

    }

    public Student(String name, String qualification, String hobby, String address, String sex) {
        this.name = name;
        this.qualification = qualification;
        this.hobby = hobby;
        this.address = address;
        this.sex = sex;
    }

}