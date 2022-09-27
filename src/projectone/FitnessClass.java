package projectone;

public class FitnessClass {
    private String instructorName;
    private String fitnessClassName;
    private Time classTime;
    private final MemberDatabase studentsList = new MemberDatabase();
    private MemberDatabase memberDb;

    public FitnessClass() {

    }

    public FitnessClass(String fitnessClassName, String instructorName, Time classTimem, MemberDatabase memberDb) {
        this.fitnessClassName = fitnessClassName;
        this.instructorName = instructorName;
        this.classTime = classTime;
        this.memberDb = memberDb;
    }

    public MemberDatabase getStudentsList() {
        return studentsList;
    }

    public String getInstructor() {
        return instructorName;
    }

    public void setInstructor(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getFitnessClassName() {
        return fitnessClassName;
    }

    public void setFitnessClassName(String fitnessClassName) {
        this.fitnessClassName = fitnessClassName;
    }

    public Time getTime() {
        return classTime;
    }

    public void setTime(Time classTime) {
        this.classTime = classTime;
    }

    public void printSchedule() {
        System.out.println("className - " + fitnessClassName + "" + instructorName + " " + classTime + "\n" + "    ** participants ** ");
        studentsList.print();
    }

    public boolean isRegis(Member member) {
        return studentsList.contains(member);
    }

    public boolean isExpired(Member member) {
        return member.getExpire().compareTo(new Date()) >= 0;
    }

    public boolean isTimeConflict(String className, FitnessClass[] fitnessClasses, Member member) {
        Time[] times = new Time[fitnessClasses.length];
        int count = 0;
        for (int i = 0; i < fitnessClasses.length; i++) {
            if (fitnessClasses[i].getStudentsList().contains(member)) {
                times[count] = fitnessClasses[i].getTime();
            }
        }
        for (int i = 0; i < times.length; i++) {
            for (int j = 1; j < times.length; j++) {
                if (times[i].getDateTime().equals(times[j].getDateTime())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkIn(Member member, String className, FitnessClass[] fitnessClasses, MemberDatabase memberDb) {
        if (!isExpired(member)) {
            if (!isRegis(member)) {
                if (member.getDob().isValidDob()) {
                    if (!isTimeConflict(className, fitnessClasses, member)) {
                        if (memberDb.contains(member)) {
                            studentsList.add(member);
                            return true;
                        } else {
                            System.out.println("member not exist");
                        }
                    } else {
                        System.out.println("time conflict");
                    }
                } else {
                    System.out.println("this person's birthday is not valid");
                }
            } else {
                System.out.println("this person is already registered this class");
            }
        } else {
            System.out.println("this person's membership has already expired");
        }
        return false;
    }

    public boolean drop(Member member, MemberDatabase memberDb){
        if(memberDb.contains(member)){
            if (member.getDob().isValidDob()){
                if (isRegis(member)){
                    studentsList.remove(member);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return null;
    }
}