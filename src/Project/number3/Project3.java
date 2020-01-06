package Project.number3;

import java.util.Scanner;

public class Project3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        PhoneInfo[] phoneInfo = new PhoneInfo[100];
        int num;
        while(true){
            System.out.println("선택하세요...");
            System.out.println("1.데이터 입력");
            System.out.println("2.데이터 검색");
            System.out.println("3.데이터 삭제");
            System.out.println("4.프로그램 종료");
            System.out.print("선택 ");
            num=sc.nextInt();
            sc.nextLine();
            if(num==4) break;
            PhoneBookManager.controlData(phoneInfo,num);
            /*for(int i=0;i<100;i++){
                if(phoneInfo[i]!=null){
                    System.out.print(phoneInfo[i].name);
                    System.out.println();
                }
            }*/

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

class PhoneBookManager{
    static int idx=0;
    static String name = "";
    static String telNum = "";
    static String birth = "";
    static Scanner sc = new Scanner(System.in);
    public static void controlData(PhoneInfo[] phoneInfo, int num) {
        if (num == 1) {
            clearVariable();
            System.out.println("데이터 입력을 시작합니다...");
            System.out.print("이름 ");
            name = sc.nextLine();
            System.out.print("전화번호 ");
            telNum = sc.nextLine();
            System.out.print("생년월일 ");
            birth = sc.nextLine();
            System.out.println("데이터 입력이 완료되었습니다....");
            phoneInfo[idx++] = new PhoneInfo(name,telNum,birth);
        }else if(num==2){
            clearVariable();
            System.out.println("데이터 검색을 시작합니다...");
            System.out.print("이름 ");
            name = sc.nextLine();
            for(PhoneInfo p : phoneInfo){
                if(p==null) break;
                if(p.name.equalsIgnoreCase(name)){
                    p.showPhoneInfo();
                }
            }
            System.out.println("데이터 검색이 완료되었습니다...");
        }else if(num==3){
            clearVariable();
            System.out.println("데이터 삭제를 시작합니다...");
            System.out.print("이름 ");
            name = sc.nextLine();
            for(int i=0;i<idx;i++){
                if(phoneInfo[i].name.equalsIgnoreCase(name)){
                    int index=i;
                    for(int k=index;k<idx;k++){
                        if(k==idx-1) {
                            phoneInfo[k]=null;
                        }else{
                            phoneInfo[k]=null;
                            phoneInfo[k]=phoneInfo[k+1];
                        }
                    }
                    idx--;
                }
            }
            System.out.println("데이터 삭제가 완료되었습니다...");
        }
    }
    public static void clearVariable(){
        name = "";
        telNum = "";
        birth = "";
    }
}
