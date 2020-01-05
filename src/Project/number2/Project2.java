package Project.number2;

import java.util.Scanner;

public class Project2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String name = "";
        String telNum = "";
        String birth = "";
        int num;
        while(true){
            System.out.println("선택하세요...");
            System.out.println("1.데이터 입력");
            System.out.println("2.프로그램 종료");
            System.out.print("선택 ");
            num = sc.nextInt();
            if(num==2) break;
            sc.nextLine();
            System.out.print("이름 ");
            name = sc.nextLine();
            System.out.print("전화번호 ");
            telNum = sc.nextLine();
            System.out.print("생년월일 ");
            birth = sc.nextLine();
            PhoneInfo phoneInfo = new PhoneInfo(name,telNum,birth);
            phoneInfo.showPhoneInfo();
        }
    }
}

class PhoneInfo{
    String name;
    String phoneNumber;
    String birthday;
    public PhoneInfo(String name,String phoneNumber,String birthday){
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.birthday=birthday;
    }
    public PhoneInfo(String name,String phoneNumber){
        this(name,phoneNumber,null);
    }
    public void showPhoneInfo(){
        System.out.println("이름은 : "+name);
        System.out.println("폰번호는 : "+phoneNumber);
        if(birthday!=null) System.out.println("생년월일은 "+birthday);
    }
}
