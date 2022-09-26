package projectone;

import java.util.Calendar;
import java.util.StringTokenizer;

public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;
    private static final int QUADRENNIAL = 4;
    private static final int CENTENNIAL = 100;
    private static final int QUATERCENTENNIAL = 400;
    private static final int January = 1;
    private static final int February = 2;
    private static final int March = 3;
    private static final int April = 4;
    private static final int May = 5;
    private static final int June = 6;
    private static final int July = 7;
    private static final int August = 8;
    private static final int September = 9;
    private static final int October = 10;
    private static final int November = 11;
    private static final int December = 12;

    public Date() {
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DATE);
    }

    public Date(String date) {
        StringTokenizer st = new StringTokenizer(date, "/");
        month = Integer.parseInt(st.nextToken());
        day = Integer.parseInt(st.nextToken());
        year = Integer.parseInt(st.nextToken());
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public boolean isLeapYear() {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    public boolean isValidDob(){
        return year <= Calendar.getInstance().get(Calendar.YEAR);
    }

    public boolean isValid() {
        boolean flag = false;
        Date date = new Date();
        if (year >= 0) {
            if (month == January || month == March || month == May || month == July || month == August || month == December || month == October) {
                if (day > 0 && day <= 31) {
                    return true;
                } else {
                    return false;
                }
            } else if (month == April || month == June || month == September || month == November) {
                if (day > 0 && day <= 30) {
                    return true;
                } else {
                    return false;
                }
            } else if (month == February) {
                if (isLeapYear()) {
                    if (day > 0 && day <= 29) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    if (day > 0 && day <= 28) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    @Override
    public int compareTo(Date date) {
        if ((date.year > this.year)) {
            return 1;
        } else if (date.year < this.year) {
            return -1;
        } else {
            if (date.month > this.month) {
                return -1;
            } else if (date.month < this.month) {
                return 1;
            } else {
                if (date.day > this.day) {
                    return -1;
                } else if (date.day < this.day) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Date d = new Date();
        String date = d.toString();
        Date newD = new Date(date);
        System.out.println(date);
        System.out.println(newD.isValid());
        System.out.println(d.month + " " + d.day + " " + d.year);
        Date dob = new Date("7/3/2002");
        System.out.println(dob.isValidDob());
    }
}
