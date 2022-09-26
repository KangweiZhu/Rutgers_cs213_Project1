package projectone;

import java.util.Scanner;

public class GymManager {
    private final MemberDatabase memberDb = new MemberDatabase();
    public void run() {
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
            if(doAddMember(cmdLine)){
                System.out.println("succussfully added");
            }
        } else if("P".equals(cmd)){
            doPrint();
        } else if("R".equals(cmd)){
            if(doRemove(cmdLine)){
                System.out.println("successfully removed");
            }
        } else if("Q".equals(cmd)){
            System.out.println("Gym Manager terminated");
            System.exit(0);
        }
    }

    public boolean doRemove(String[] cmdLine){
        Date date = new Date(cmdLine[3]);
        Member member = new Member(cmdLine[1],cmdLine[2],date);
        return memberDb.remove(member);
    }

    public boolean doAddMember(String[] cmdLine) {
        String newLocation = cmdLine[5];
        Date dob = new Date(cmdLine[3]);
        Date expireDate = new Date(cmdLine[4]);
        if (dob.isValidDob() && expireDate.isValid() && isValidLocation(newLocation)) {
            Member member = new Member(cmdLine[1], cmdLine[2], dob, expireDate, Location.valueOf(newLocation));
            return memberDb.add(member);
        } else {
            if (!dob.isValid()){
                System.out.println();
            }else if(!expireDate.isValid()){
                System.out.println();
            }else if(!isValidLocation(newLocation)){
                System.out.println();
            }
        }
        return false;
    }

    private void doPrint(){
        memberDb.print();
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
