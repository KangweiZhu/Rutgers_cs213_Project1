package projectone;

import java.util.Scanner;

public class GymManager {
    private final MemberDatabase memberDb = new MemberDatabase();
    private final int MAX_CLASS_SIZE = 3;
    private FitnessClass[] fitnessClasses = new FitnessClass[MAX_CLASS_SIZE];

    public void run() {
        doAddClass();
        System.out.println("Gym Manager running" + "\n");
        Scanner sc = new Scanner(System.in);
        String command;
        String[] cmdLine;
        while (sc.hasNext()) {
            command = sc.nextLine();
            cmdLine = command.split("\\s");
            doCmd(cmdLine[0], cmdLine);
        }
    }

    public void doCmd(String cmd, String[] cmdLine) {
        int cmdLen = cmdLine.length;
        if ("A".equals(cmd)) {
            if (doAddMember(cmdLine)) {
                System.out.println("succussfully added");
            }
        } else if ("P".equals(cmd)) {
            doPrint();
        } else if ("R".equals(cmd)) {
            if (doRemove(cmdLine)) {
                System.out.println("successfully removed");
            }
        } else if ("Q".equals(cmd)) {
            System.out.println("Gym Manager terminated.");
            System.exit(0);
        } else if ("PC".equals(cmd)) {
            doPrintByCounty();
        } else if ("PN".equals(cmd)) {
            doPrintByName();
        } else if ("PD".equals(cmd)) {
            doPrintByExpireDate();
        } else if ("C".equals(cmd)) {
            doCheckIn(cmdLine);
        } else if ("D".equals(cmd)) {
            doDropClass(cmdLine);
        } else if ("S".equals(cmd)) {
            doDisplaySchedule();
        }
    }

    private void doAddClass() {
        fitnessClasses[0] = new FitnessClass("Pilates", "Jennifer", Time.valueOf("nineThirty"), memberDb);
        fitnessClasses[1] = new FitnessClass("Spinning", "Denise", Time.valueOf("fourteen"), memberDb);
        fitnessClasses[2] = new FitnessClass("Cardio", "Kim", Time.valueOf("fourteen"), memberDb);
    }

    private void doPrintByCounty() {
        memberDb.printByCounty();
    }

    private void doPrintByName() {
        memberDb.printByName();
    }

    private void doPrintByExpireDate() {
        memberDb.printByExpirationDate();
    }

    private boolean doRemove(String[] cmdLine) {
        Date date = new Date(cmdLine[3]);
        Member member = new Member(cmdLine[1], cmdLine[2], date);
        return memberDb.remove(member);
    }

    private void doCheckIn(String[] cmdLine) {
        String lname = cmdLine[3];
        String fname = cmdLine[2];
        String className = cmdLine[1];
        Date dob = new Date(cmdLine[4]);
        for (int i = 0; i < fitnessClasses.length; i++) {
            if (fitnessClasses[i].getFitnessClassName().equalsIgnoreCase(className)) {
                fitnessClasses[i].checkIn(new Member(fname, lname, dob), className, fitnessClasses, memberDb);
                return;
            }
        }
        System.out.println("person not exist");

    }

    private boolean doAddMember(String[] cmdLine) {
        String newLocation = cmdLine[5];
        Date dob = new Date(cmdLine[3]);
        Date expireDate = new Date(cmdLine[4]);
        if (dob.isValidDob() && expireDate.isValid() && isValidLocation(newLocation)) {
            Member member = new Member(cmdLine[1], cmdLine[2], dob, expireDate, Location.valueOf(newLocation));
            return memberDb.add(member);
        } else {
            if (!dob.isValid()) {
                System.out.println();
            } else if (!expireDate.isValid()) {
                System.out.println();
            } else if (!isValidLocation(newLocation)) {
                System.out.println();
            }
        }
        return false;
    }

    private void doPrint() {
        memberDb.print();
    }

    private void doDisplaySchedule() {
        System.out.println("Fitness classes");
        for (int i = 0; i < fitnessClasses.length; i++) {
            fitnessClasses[i].printSchedule();
        }
    }

    private void doDropClass(String[] cmdLine) {
        String className = cmdLine[1];
        String fname = cmdLine[2];
        String lname = cmdLine[3];
        Date dob = new Date(cmdLine[4]);
        Member member = new Member(fname, lname, dob);
        for (int i = 0; i < fitnessClasses.length; i++) {
            if (fitnessClasses[i].getFitnessClassName().equalsIgnoreCase(className)) {
                fitnessClasses[i].drop(new Member(fname, lname, dob), memberDb);
                return;
            }
        }
        System.out.println("class not exist");
    }

    private boolean isValidLocation(String loc) {
        for (Location location :
                Location.values()) {
            if (location.toString().equalsIgnoreCase(loc)) {
                return true;
            }
        }
        return false;
    }

}
