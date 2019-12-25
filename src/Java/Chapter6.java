package Java;

public class Chapter6 {
    static String s1="";
    public static void main(String args[]){
        System.out.println("Start");
        hello(11);
        abs(3,12);
        checkPrime();
        hateAddNumber(10);
        System.out.println(selfCall(10));
        printBinaryNumber(16);
        System.out.println();
        System.out.println("End");
    }
    public static void hello(int age){ // 받은 파라미터를 그대로 출력하는 함수
        System.out.println(age);
    }

    public static void abs(int a,int b){ //절대값을 구해주는 함수
        System.out.println( (Math.abs(a-b)) );
    }

    public static void checkPrime(){ //소수를 체크해주는 함수
        for(int i=2;i<101;i++){
            int sw=0;
            for(int j=2;j<=i;j++){
                if(i%j==0 && i!=j) {
                    sw=1;
                    break;
                }
            }
            if(sw==0){
                System.out.println(i+"는"+"소수다");
            }
        }
    }

    public static void hateAddNumber(int a){ // 짝수면 함수를 종료하는 함수
        if(a%2==0) return ;
        else System.out.println("홀수"+a);
    }

    public static int selfCall(int n){ //2의 n승을 구해주는 재귀함수
        if(n==0) return 1;
        return 2*selfCall(n-1);
    }

    public static void printBinaryNumber(int num){ //10진수 2진수 변환 재귀함수 (일반적인 방법)
        if(num==1) System.out.printf("%d",1);
        else {
            printBinaryNumber(num/2);
            System.out.printf("%d",num%2);
        }
    }

    public static void printBinaryNumber2(int num){ //10진수 2진수 변환 재귀함수 (전역변수에 저장후 출력하는 case)
        if(num==1) s1+=1;
        else {
            printBinaryNumber(num/2);
            s1+=num%2;
        }
    }


}
