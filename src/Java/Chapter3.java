package Java;

public class Chapter3 {
    public static void main(String args[]){
        double e1=7.125;
        float e2=7.125F;
        long n1=10000000000L;
        long n2=150;  // 150은 int형이고 이걸 long에 넣으려는 작업은 문제 없다.
                      // long이 int보다 더 넓은 범위이기에
        System.out.println(e1);
        System.out.println(n1);

        char ch1='A';
        char ch2='Z';
        int num1=ch1;
        int num2=(int)ch2; // 자동형 변환도 강제 캐스팅 처럼 (int)이런 꼴을 붙여 줄 수 있다.
        System.out.println("문자 A의 유니코드 값"+num1);
        System.out.println("문자 Z의 유니코드 값"+num2);
    }
}
