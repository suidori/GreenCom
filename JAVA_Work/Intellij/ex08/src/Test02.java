public class Test02 {
    public static void main(String[] args) {
        TV myTV = new TV("LG", 2017, 32);
        myTV.show();
    }
}

class TV{
    String brand;
    int year;
    int inch;

    public TV(String brand, int year, int inch) {
        this.brand = brand;
        this.year = year;
        this.inch = inch;
    }

    public void show(){
        System.out.printf("%s에서 만든 %d년 %d인치", brand, year, inch);
    }

}