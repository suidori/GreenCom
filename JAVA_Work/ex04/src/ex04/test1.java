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

//(조건) ? (조건 맞을때) : (조건 틀릴때)

//if(조건){(조건 맞을때)}
//else {(조건 틀릴때)}

/*
 * 사과 123개
 * 한 바구니에 10개
 * 총 필요한 바구니 수
 * 13
 * 123/10 = 12 + 3
 * 
 * 주어진 사과 갯수/10
 * 10으로 맞아떨어지냐 = 나눈거 몫
 * 남냐 = 나눈거 몫 + 1
 * 나누어떨어진다=나머지=0
 * a%b==0
 * 
 * int result = (조건) ? true : false ;
 * 
 */