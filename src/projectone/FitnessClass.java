package projectone;

public class FitnessClass{
    private String instructor;
    private String fitnessClassName;
    private String time;

    public FitnessClass(){

    }

    public FitnessClass(String fitnessClassName, String instructor, String time){
        this.fitnessClassName = fitnessClassName;
        this.instructor = instructor;
        this.time = time;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getFitnessClassName() {
        return fitnessClassName;
    }

    public void setFitnessClassName(String fitnessClassName) {
        this.fitnessClassName = fitnessClassName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}