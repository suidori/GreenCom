public class Ex06 {
    public static void main(String[] args) {

        String str = "우리는 할 수 있다.";
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }

        chars[4] = 'A';
        String newstr = new String(chars);
        System.out.println(newstr);

    }
}
