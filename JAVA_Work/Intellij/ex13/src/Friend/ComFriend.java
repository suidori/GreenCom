package Friend;

public class ComFriend extends Friend{

    private String major;

    public ComFriend(String name, String phone, String major) {
        super(name, phone);
        this.major = major;
    }

    public void showInfo(){
        super.showInfo();
        System.out.println("부서 = " + major);
    }

}
