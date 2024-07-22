package Friend;

public class UniFriend {
    Friend friend;
    private String department;

    public UniFriend(String name, String phone, String department) {
        friend = new Friend(name, phone);
        this.department = department;
    }

    public void showInfo() {
        friend.showInfo();
        System.out.println("전공 = " + department);
    }

}
