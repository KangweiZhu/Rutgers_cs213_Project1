package projectone;

public class MemberDatabase {
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
        if (find(member) != -1) {
            System.out.println("This member already exist in database");
            return false;
        }
        if (size == mlist.length - 1) {
            grow();
        }
        mlist[size] = member;
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
        size--;
        return true;
    }

    public boolean contains(Member member) {
        return find(member) != -1;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(mlist[i].toString());
        }
    }

    public void printByCounty() {
        int step = 1;
        while (step < size) {
            step = 2 * step + 1;
        }
        while (step >= 1) {
            for (int i = step; i < size; i++) {
                for (int j = i; j >= step; j -= step) {
                    if (mlist[j].getLocation().reformat().compareTo(mlist[j - step].getLocation().reformat()) < 0) {
                        Member temp = mlist[j];
                        mlist[j] = mlist[j - step];
                        mlist[j - step] = temp;
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
        while (step < size) {
            step = 2 * step + 1;
        }
        while (step >= 1) {
            for (int i = step; i < size; i++) {
                for (int j = i; j >= step; j -= step) {
                    if (mlist[j].getExpire().compareTo(mlist[j - step].getExpire()) < 0) {
                        Member temp = mlist[j];
                        mlist[j] = mlist[j - step];
                        mlist[j - step] = temp;
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
        while (step < size) {
            step = 2 * step + 1;
        }
        while (step >= 1) {
            for (int i = step; i < size; i++) {
                for (int j = i; j >= step; j -= step) {
                    if (mlist[j].compareTo(mlist[j - step]) < 0) {
                        Member temp = mlist[j];
                        mlist[j] = mlist[j - step];
                        mlist[j - step] = temp;
                    } else {
                        break;
                    }
                }
            }
            step /= 2;
        }
        print();
    }

    public int getSize() {
        return size;
    }


    public static void main(String[] args) {
        String d = "9/22/2022";
        Date dd = new Date(d);
        String a = "9/22/2022";
        Date ddd = new Date(a);
        System.out.println(ddd.compareTo(dd));
    }
}
