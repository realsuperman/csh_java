package Java;

public class Chapter4 {
    public static void main(String args[]){
        System.out.println(3/2); // int 형으로 결과 반환 즉 .5에 해당하는 소숫점 절삭됨
        System.out.println(3.0F/2.0F); // float형으로 결과 반환하므로 1.5 반환
        System.out.println(7%2);
        System.out.println(7.2%1.2); //연산은 수행되지만 결과가 올바르지 못하다.
        int a=4,b=0;
        b+=a; //같은 표현으로는 b=b+a가 있다.
        System.out.println(b);
        int num1=10,num2=20,num3=30;
        boolean result1 = (num1==10&&num2==20);
        boolean result2 = (num1==10 || num2==20);
        System.out.println("result1는 "+result1+" result2는 "+result2);
        num1=num2=num3=30; // num3에 30저장후 그값을 num2에 저장후 그값을 num1에 저장하므로 세변수의 값은 같다.
        //a = +3의 정의에서 생각해볼때 아래는 무엇이겠는가?
        int a1=3;
        int a2 = +a1;  // 위에 썻던 정의와 같이 생각하면 된다
        a2 = -a1; // -3이 저장된다
        int a3=4;
        int a4=++a3 + 2;
        int a5=a3++ + 2;
        System.out.println(a4); //선증가
        System.out.println(a5); //후증가

        int csh=1;
        int csh2=10;
        System.out.println(csh&csh2);
        System.out.println(csh|csh2);
        System.out.println(~csh);
        System.out.println(csh^csh2);
    }
}
