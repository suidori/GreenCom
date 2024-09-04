import java.io.*;

class MyObject implements Serializable {
    private String test = "aaa";

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}

public class Ex02 {
    public static void main(String[] args) {
        try {
            ObjectOutputStream oos
                    = new ObjectOutputStream(new FileOutputStream("d:/a/obj"));
            oos.writeObject(new MyObject());
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectInputStream ois =
                null;
        try {
            ois = new ObjectInputStream(new FileInputStream("d:/a/obj"));
            Object aaa = ois.readObject();
            MyObject mo = (MyObject) aaa;
            System.out.println(mo.getTest());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
