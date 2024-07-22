package Friend;

public class Friend {
    private String name;
    private String phone;

    public Friend(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public void showInfo() {
        System.out.println("이름 = " + name);
        System.out.println("연락처 = " + phone);
    }

}
