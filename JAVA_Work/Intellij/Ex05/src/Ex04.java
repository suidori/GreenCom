class Box{
    String conts;

    public Box(String cont){
        this.conts = cont;
    }

    public String toString() {
        return "Box{" +
                "conts='" + conts + '\'' +
                '}';
    }
}

public class Ex04 {
    public static void main(String[] args) {
        Box[] boxes = new Box[5];

        System.out.println(boxes[0]);
        System.out.println(boxes[1]);
        System.out.println(boxes[2]);

        boxes[0] = new Box("사과");
        boxes[1] = new Box("감귤");
        boxes[2] = new Box("피망");
        for (int i = 0; i < boxes.length; i++) {
            System.out.println(boxes[i]);
        }

    }
}
