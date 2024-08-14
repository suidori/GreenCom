public class BoxFactory {

    public static <T> void peekBox(Box<T> box){
        System.out.println(box.getT());
    }

    public static void peekBox2(Box<?> box){
        System.out.println(box.getT());
    }

    public static void peekBox3(Box<Object> box){
        System.out.println(box.getT());
    }

    //상한제한
    public static void peekBox4(Box<? extends AA> box){
        AA getBox = box.getT();
        System.out.println(getBox);
//        box.setT(new AA()); <-불가능
    }

    //하한제한
    public static void peekBox5(Box<? super AA> box){
//        AA getbox = box.getT(); <-불가능
//        System.out.println(getbox);
        box.setT(new AA());
    }

    public static <T> T getMyBox(Box<? extends T> box){
        return box.getT();
    }



}
