public class Test {
    char a = 'a';
    int cycle = 0;
    int alphabet = 0;
    int range = 0;

    public static void main(String[] args) {
        Test test = new Test();
        test.output(3);//a~zzz

    }

    public void output(int n) {
        if(cycle==n){
            cycle=0;
            return;
        }
        System.out.print((char)(a+alphabet));
        cycle++;
        output(n);



    }


}
/*cycle=0
a출력 \n출력
a+1출력 \n출력
~
a+25출력 \n출력
cycle++;

cycle = 1
a출력 a출력 \n출력
a출력 a+1출력 \n출력
*/