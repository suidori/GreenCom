package ex04;

public class test1 {
	public static void main(String[] args) {
		int numOfApples = 123;
		int sizeOfBucket = 10;
		int numOfBucket = (numOfApples%sizeOfBucket==0) ? numOfApples/sizeOfBucket : numOfApples/sizeOfBucket+1 ;
		
		System.out.println("필요한 바구니의 수 = " + numOfBucket);
	}
}

//사과 바구니 갯수 구하기