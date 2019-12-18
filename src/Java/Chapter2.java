package Java;

public class Chapter2 {
    public static void main(String args[]){
        int num1;
        num1=10;
        int num2=20;
        int num3=30;
        System.out.println(num1+"+"+num2+"="+(num1+num2));


        //더블형 오차(소숫점 6자리 까지는 어느정도 연산의 신뢰성을 제공해준다)
        double number1,number2,result;
        number1=1.0000001;
        number2=2.0000001;
        result=number1+number2;
        System.out.println(result);

        //char형 c와는 다르게 2바이트 이므로 한글 표현이 가능하다.
        char a=65;
        char a1='A';
        char b='한';
        System.out.println(b);

        //boolean 자료형
        boolean True=true;
        boolean False=false;
        System.out.println(True); //True 출력
        System.out.println(False); //False 출력
        System.out.println(3<5); // 3<5는 참이므로 True
        System.out.println(3>5); // 3>5는 거짓이므로 False
    }
}
