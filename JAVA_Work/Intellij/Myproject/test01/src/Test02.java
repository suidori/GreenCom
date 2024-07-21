public class Test02 {
    int cycle = 0;
    int alphabet = 0;

    public static void main(String[] args) {
        Test02 test = new Test02();
        test.abc(3);
    }

    public void abc(int n) {

        int end = 0;
        for (int i = 0; i < n; i++) {
            end += 26 * (int) Math.pow(26, i);
        }

        if (cycle == end) {
            return;
        }

        alphabet = cycle;
        String str = "";

        while (alphabet >= 0) {
            str += (char) ('a' + alphabet % 26);
            alphabet = alphabet / 26 - 1;

            if (alphabet < 0) {
                break;
            }
        }

        for (int i = str.length()-1; i >= 0 ; i--) {
            System.out.print(str.charAt(i));
        }
        System.out.println();

        cycle++;
        alphabet = cycle;
        abc(n);
    }
}
