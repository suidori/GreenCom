class Circle {
    private int rad;

    public Circle(int rad) {
        this.rad = rad;
    }

    public int getRad() {
        return rad;
    }

    public void setRad(int rad) {
        this.rad = rad;
    }

    public double getArea(){
        return rad*rad*3.14;
    }

}
