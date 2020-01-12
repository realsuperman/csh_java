package Project.number4;

import java.util.Scanner;

public class Project4 {
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
        }
    }
}

class PhoneInfo{
    String name;
    String phoneNumber;
    public PhoneInfo(String name,String phoneNumber){
        this.name=name;
        this.phoneNumber=phoneNumber;
    }
    public void showPhoneInfo(){
        System.out.println("이름은 : "+name);
        System.out.println("폰번호는 : "+phoneNumber);
    }
}

class PhoneUnivInfo extends PhoneInfo{
    String major;
    int year;
    public PhoneUnivInfo(String name,String PhoneNumber,String major,int year){
       super(name,PhoneNumber);
       this.major=major;
       this.year=year;
    }
    public void showPhoneInfo(){
        super.showPhoneInfo();
        System.out.println("전공은 : "+major);
        System.out.println("학년은 : "+year);
    }
}

class PhoneCompanyInfo extends PhoneInfo{
    String company;
    public PhoneCompanyInfo(String name,String PhoneNumber,String company){
        super(name,PhoneNumber);
        this.company=company;
    }
    public void showPhoneInfo(){
        super.showPhoneInfo();
        System.out.println("회사는 : "+company);
    }
}

class PhoneBookManager{
    static int idx=0;
    static String name = "";
    static String telNum = "";
    static int choice=0;
    static String major="";
    static int year=0;
    static String company="";
    static Scanner sc = new Scanner(System.in);
    public static void addPhoneInfo(PhoneInfo[] phoneInfo, PhoneInfo phone){
        phoneInfo[idx++] = phone;
    }
    public static void controlData(PhoneInfo[] phoneInfo, int num) {
        if (num == 1) {
            clearVariable();
            System.out.println("데이터 입력을 시작합니다...");
            System.out.print("1.일반 2.대학 3.회사 ");
            choice=sc.nextInt();
            sc.nextLine();
            System.out.print("이름 ");
            name = sc.nextLine();
            System.out.print("전화번호 ");
            telNum = sc.nextLine();

            if(choice==2){
                System.out.print("전공 ");
                major=sc.nextLine();
                System.out.print("학년 ");
                year=sc.nextInt();
                sc.nextLine();
                addPhoneInfo(phoneInfo,new PhoneUnivInfo(name,telNum,major,year));
            }else if(choice==3){
                System.out.print("회사 ");
                company=sc.nextLine();
                addPhoneInfo(phoneInfo,new PhoneCompanyInfo(name,telNum,company));
            }else{
                phoneInfo[idx++] = new PhoneInfo(name,telNum);
            }
            System.out.println("데이터 입력이 완료되었습니다....");
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
        choice=0;
        major="";
        year=0;
        company="";
    }
}


