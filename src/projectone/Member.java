package projectone;

public class Member implements Comparable<Member> {
    private String fname;
    private String lname;
    private Date dob;
    private Date expire;
    private Location location;

    public Member() {
    }

    public Member(String fname, String lname, Date dob, Date expire, Location location) {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.expire = expire;
        this.location = location;
    }

    public Member(String fname, String lname, Date dob) {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return fname + " " + lname + ", " + "DOB: " + dob + ", " + "Membership expires " + expire + " projectone.Location: "
                + location;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Member) {
            Member member = (Member) obj;
            boolean isFNameSame = this.fname.equals(member.fname);
            boolean isLNameSame = this.lname.equals(member.lname);
            boolean isDobSame = this.dob.compareTo(member.dob) == 0;
            return isFNameSame == isLNameSame == isDobSame;
        }
        return false;
    }

    public String reformat(Member member) {
        return member.getLname() + member.getFname();
    }

    @Override
    public int compareTo(Member member) {
        return reformat(this).compareTo(reformat(member));
    }
}
