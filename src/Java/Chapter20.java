package Java;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Chapter20 {
    public static void main(String args[]){
        IntWrapper intInst = new IntWrapper(3);
        showData(intInst);
        showData(new IntWrapper(7));

        Integer intInst2 = new Integer(3);
        showData(intInst2);
        showData(new Integer(7));

        Integer iValue = new Integer(10);
        Double dValue = new Double(3.14);
        System.out.println(iValue);
        System.out.println(dValue);
        iValue=new Integer(iValue.intValue()+10);
        dValue=new Double(dValue.doubleValue()+1.2);
        System.out.println(iValue);
        System.out.println(dValue);

        Integer iValue2=10;
        Double dValue2=3.14;
        System.out.println(iValue2);
        System.out.println(dValue2);
        int num1=iValue2;
        double num2=dValue2;
        System.out.println(num1);
        System.out.println(num2);

        Integer number=10;
        Integer number2=20;
        number++;
        System.out.println(number);
        number2+=3;
        System.out.println(number2);
        int addResult=number+number2;
        System.out.println(addResult);
        int minResult=number-number2;
        System.out.println(minResult);

        Integer iValue0 = creativeValue(10);
        Integer iValue1 = creativeValue(10);
        if(iValue0==iValue1) System.out.println("동일 인스턴스 참조");
        else System.out.println("다른 인스턴스 참조");

        System.out.println("최대 정수 : "+Long.MAX_VALUE);
        System.out.println("최소 정수 : "+Long.MIN_VALUE);
        BigInteger bigValue1 = new BigInteger("1000000000000000000");
        BigInteger bigValue2 = new BigInteger("-999999999999999999");
        BigInteger addValue = bigValue1.add(bigValue2);
        BigInteger mulValue = bigValue1.multiply(bigValue2);
        System.out.println("큰 수의 덧셈결과"+addValue);
        System.out.println("큰 수의 곱셈결과"+mulValue);

        BigDecimal e1=new BigDecimal("1.6");
        BigDecimal e2=new BigDecimal("0.1");
        System.out.println("두 실수의 덧셈결과 : "+e1.add(e2));
        System.out.println("두 실수의 곱셈결과 : "+e1.multiply(e2));

        /*Scanner sc = new Scanner(System.in);
        String d1=sc.nextLine();
        String d2=sc.nextLine();

        BigDecimal e3=new BigDecimal(d1);
        BigDecimal e4=new BigDecimal(d2);
        System.out.println((e3.subtract(e4)).abs());
         */

        System.out.println("원주율 : "+Math.PI);
        System.out.println("2의 제곱근 "+Math.sqrt(2));
        System.out.println("파이에 대한 Degree : "+Math.toDegrees(Math.PI));
        System.out.println("2파이에 대한 Degree : "+Math.toDegrees(2.0*Math.PI));
        double radian45=Math.toRadians(45);
        System.out.println("싸인 45 : "+Math.sin(radian45));
        System.out.println("코싸인 45 : "+Math.cos(radian45));
        System.out.println("탄젠트 45 : "+Math.tan(radian45));
        System.out.println("로그 25 : "+Math.log(25));
        System.out.println("2의 4승 : "+Math.pow(2,4));

        Random rand = new Random(12);
        for(int i=0;i<100;i++) System.out.println(rand.nextInt(1000));

        Random rand2 = new Random(12);
        rand2.setSeed(System.currentTimeMillis());
        for(int i=0;i<100;i++) System.out.println(rand2.nextInt(1000));

        /*int maxInt=sc.nextInt();
        int minInt=sc.nextInt();
        Random rand3 = new Random();
        rand3.setSeed(System.currentTimeMillis());
        for(int i=0;i<10;i++){
            System.out.println(rand3.nextInt(maxInt-minInt+1)+minInt);
        }
         */

        for(int i=0;i<5;i++){
            Double a=Math.random()*10;
            System.out.println(a.intValue());
        }

        String strData="11:22:33:44:55";
        StringTokenizer st = new StringTokenizer(strData,":");
        while(st.hasMoreTokens()) System.out.println(st.nextToken());

        String phoneNumber="TEL 82-02-997-2059";
        String javaCode="num+=1";
        System.out.println("First Result...........");
        StringTokenizer st1=new StringTokenizer(phoneNumber);
        while(st1.hasMoreTokens()) System.out.println(st1.nextToken());
        System.out.println("\nSecond Result..........");
        StringTokenizer st2=new StringTokenizer(phoneNumber," -");
        while(st2.hasMoreTokens()) System.out.println(st2.nextToken());
        System.out.println("\nThird Result............");
        StringTokenizer st3=new StringTokenizer(javaCode,"+=",true);
        while(st3.hasMoreTokens()) System.out.println(st3.nextToken());
    }
    public static void showData(Object obj){
        System.out.println(obj);
    }
    public static Integer creativeValue(Integer num){
        return Integer.valueOf(num);
    }
}

class IntWrapper{
    private int num;
    public IntWrapper(int data){
        num=data;
    }
    public String toString(){
        return ""+num;
    }
}