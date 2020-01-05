package Java;

import java.util.Scanner;

public class Chapter12 {
    public static void main(String args[]){
        Friend fnd1 = new Friend("이종수");
        Friend fnd2 = new Friend("현주은");
        System.out.println(fnd1);
        System.out.println(fnd2);
        System.out.print("출력이 ");
        System.out.print("종료되었습니다.");
        System.out.println("");

        int age=20;
        double tall=175.7;
        String name="홍자바";
        System.out.printf("제 이름은 %s 입니다.\n",name);
        System.out.printf("나이는 %d이고, 키는 %e입니다. \n",age,tall);
        System.out.printf("%d %o %x \n",77,77,77);
        System.out.printf("%g %g \n",0.00014,0.000014);

        String source = "1 5 7";
        Scanner sc = new Scanner(source);
        int num1=sc.nextInt();
        int num2=sc.nextInt();
        int num3=sc.nextInt();
        int sum=num1+num2+num3;
        System.out.printf("문자열에 저장된 %d %d %d의 합은 %d\n",num1,num2,num3,sum);

        Scanner sc2 = new Scanner(System.in);
        num1=sc2.nextInt();
        num2=sc2.nextInt();
        num3=sc2.nextInt();
        sum=num1+num2+num3;
        System.out.printf("문자열에 저장된 %d %d %d의 합은 %d\n",num1,num2,num3,sum);

        Scanner keyboard = new Scanner(System.in);
        System.out.print("당신의 이름은?");
        String str = keyboard.nextLine();
        System.out.println("안녕하세요 "+str+"님");
        System.out.print("당신은 스파게티를 좋아한다는데, 진실입니까?");
        boolean isTrue=keyboard.nextBoolean();
        if(isTrue==true) System.out.println("오~ 좋아하는군요,");
        else System.out.println("이런 아니었군요.");
        System.out.println("당신과 동생의 키는 어떻게 되나요?");
        double cNum1=keyboard.nextDouble();
        double cNum2=keyboard.nextDouble();
        double diff=cNum1-cNum2;
        if(diff>0) System.out.println("당신이 "+diff+"만큼 크군요.");
        else System.out.println("당신이 "+(-diff)+"만큼 작군요.");
    }
}
class Friend{
    String myName;
    public Friend(String name){
        myName = name;
    }
    public String toString(){
        return "제 이름은 "+myName+"입니다.";
    }
}
