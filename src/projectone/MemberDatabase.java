package projectone;

public class MemberDatabase{
    private Member[] mlist;
    private int size;
    private static final int INCREMENT = 4;

    public MemberDatabase() {
        mlist = new Member[INCREMENT];
        size = 0;
    }

    private int find(Member member) {
        for (int i = 0; i < size; i++) {
            if (mlist[i].equals(member)) {
                return i;
            }
        }
        return -1;
    }

    private void grow() {
        Member[] newMlist = new Member[mlist.length + INCREMENT];
        for (int i = 0; i < newMlist.length; i++) {
            if (i >= mlist.length) {
                newMlist[i] = null;
                continue;
            } else {
                newMlist[i] = mlist[i];
            }
        }
        this.mlist = newMlist;
    }

    public boolean add(Member member) {
        if (find(member) != -1){
            System.out.println("This member already exist in database");
            return false;
        }
        if (size == mlist.length - 1) {
            grow();
        }
        mlist[size + 1] = member;
        size++;
        return true;
    }

    public boolean remove(Member member) {
        int index = find(member);
        if (index == -1) {
            System.out.println("This member is not exists in database");
            return false;
        } else {
            for (int i = index; i < size - 1; i++) {
                mlist[i] = mlist[i + 1];
            }
        }
        return true;
    }

    public void print() {
        for (int i = 0; i < mlist.length; i++) {
            System.out.println(mlist[i].toString());
        }
    }

    public void printByCounty() {
        int step = 1;
        while (step < mlist.length) {
            step = 2 * step + 1;
        }
        while (step >= 1) {
            for (int i = step; i < mlist.length; i++) {
                for (int j = i; j >= step; j -= step) {
                    if (less(mlist[j].getLocation(), mlist[j - step].getLocation())) {
                        exch(mlist, j, j - step);
                    } else {
                        break;
                    }
                }
            }
            step /= 2;
        }
        print();
    }

    public void printByExpirationDate() {
        int step = 1;
        while (step < mlist.length) {
            step = 2 * step + 1;
        }
        while (step >= 1) {
            for (int i = step; i < mlist.length; i++) {
                for (int j = i; j >= step; j -= step) {
                    if (less(mlist[j].getExpire(), mlist[j - step].getExpire())) {
                        exch(mlist, j, j - step);
                    } else {
                        break;
                    }
                }
            }
            step /= 2;
        }
        print();
    }

    public void printByName() {
        int step = 1;
        while (step < mlist.length) {
            step = 2 * step + 1;
        }
        while (step >= 1) {
            for (int i = step; i < mlist.length; i++) {
                for (int j = i; j >= step; j -= step) {
                    if (less(mlist[j].getLname(), mlist[j - step].getLname())) {
                        exch(mlist, j, j - step);
                    } else {
                        break;
                    }
                }
            }
            step /= 2;
        }
        print();
    }

    public void exch(Comparable[] compArr, int index1, int index2) {
        Comparable temp = compArr[index1];
        compArr[index1] = compArr[index2];
        compArr[index2] = temp;
    }

    public boolean less(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) <= 0;
    }

    public static void main(String[] args) {
        String d = "9/22/2022";
        Date dd = new Date(d);
        String a = "9/22/2022";
        Date ddd = new Date(a);
        System.out.println(ddd.compareTo(dd));
    }
}
