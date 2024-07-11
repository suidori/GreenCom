public class Ex05 {

    public static void main(String[] args) {

        String str = "a|b|c+";
        String[] tempstr = str.split("|");
        for (int i = 0; i < tempstr.length; i++) {
            System.out.println(tempstr[i]);
        }

//        String a = "abcdefgh";
//        String b = "123456789";
//        char[] test = a.toCharArray();
//        for (int i = 0; i < test.length; i++) {
//            System.out.println(test[i]);
//        }
//
//        test[2] = 'A';
//        String testStr = new String(test);
//        System.out.println(testStr);
//
//        char[] num = b.toCharArray();
//        for (int i = 0; i < num.length; i++) {
//            System.out.println(num[i]);
//        }

    }
}
