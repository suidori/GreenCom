import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

/*
1. int형 1차원 배열을 매개변수로 전달 받아서 배열에 저장된 최댓값, 최솟값을 찾아서
반환하는 메소드를 각각 다음의 형태로 정의하자
public static int minValue(int[] arr){}
public static int maxValue(int[] arr){}

단, 반복문을 사용할 때 minValue 의 정의에서는 일반적인 for 문을 사용하고
maxValue 의 정의에서는 새로운 for(enhanced for)문을 사용하기로 하자
*/

class Solution1{

    public static int minValue(int[] arr){
        int answer = arr[0];
        for (int e : arr) {
            if(answer<e) answer = e;
        }
        return answer;
    }

    public static int maxValue(int[] arr){
        int answer = arr[0];
        for(int e : arr){
            if(answer>e) answer = e;
        }
        return answer;
    }

}

/*
2. 다음 메소드는 int형 1차원 배열에 저장된 값을 두 번째 매개변수로 전달된 값의 크기만큼 전부 증가시킨다.
public static void addOneDArr(int[] arr, int add){
    for(int i = 0; i<arr.length; i++){
        arr[i] += add;
       }
   }
}
위 메소드를 호출하는 형태로, int형 2차원 배열에 저장된 값 전부를 두 번째 매개변수로
전달된 값의 크기만큼 증가시키는 메소드를 다음의 형태로 정의하자
public static void addTwoDArr(int[][] arr, int add){
    //이 안에 addOneDArr 메소드를 호출한다.
}
*/

class Solution2{
    public static void addOneDArr(int[] arr, int add){
        for(int i = 0; i<arr.length; i++){
            arr[i] += add;
        }
    }

    public static void addTwoDArr(int[][] arr, int add){

        for(int i = 0; i<arr.length; i++){
            addOneDArr(arr[i], add);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}

/*

3. 다음 형태로 표현된 2차원 배열이 존재한다고 가정해보자
{1, 2, 3},
{4, 5, 6},
{7, 8, 9}
이러한 형태를 갖는 int형 2차원 배열이 인자로 전달되면, 다음의 형태로 배열의 구조를 변경시키는 메소드를 정의하자
{7, 8, 9},
{1, 2, 3},
{4, 5, 6}
물론 배열의 가로와 세로 길이에 상관 없이 위와 같이 동작하도록 메소드를 정의해야 한다.
 */

class Solution3{
    public static int[][] doChange(int[][] arr){
        int[] temp = arr[0];
        arr[0] = arr[1];
        arr[1] = arr[2];
        arr[2] = temp;

        return arr;
    }
}


public class Test01 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 9, 13, 2, 4, 6, 8, 10};
        int[][] arr2 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        int minValue = Solution1.minValue(arr);
        int maxValue = Solution1.maxValue(arr);

        System.out.println(minValue);
        System.out.println(maxValue);

        Solution2.addTwoDArr(arr2, 1);

        for (int[] ints : arr2){
            System.out.println(Arrays.toString(ints));
        }
        
    }

}



