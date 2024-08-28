import java.util.function.ToIntBiFunction;

class IBox{
    private int n;
    public IBox(int n) {
        this.n=n;
    }

    public int larger(IBox b){
        if(n>b.n)
            return n;
        else
            return b.n;
    }

}

public class Ex03 {
    public static void main(String[] args) {
        ToIntBiFunction<IBox, IBox> toIntBiFunction = (iBox, iBox2) -> iBox.larger(iBox2);
        int result = toIntBiFunction.applyAsInt(new IBox(5), new IBox(7));

        System.out.println(result);
    }
}
