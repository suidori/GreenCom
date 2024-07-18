package aa;

public class BusinessMan extends Man{

    private String company;
    private String position;

    public BusinessMan(String company, String position, String name) {
        super(name);
        this.company = company;
        this.position = position;

    }

    public void showInfo(){
        System.out.println("company = " + company);
        System.out.println("position = " + position);

        tellInfo();
    }

}
