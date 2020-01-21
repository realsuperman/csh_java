package Project.number7;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Project7 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num;
        PhoneBookManager pbm= PhoneBookManager.getPhoneBookManager();
        while(true){
            System.out.println("선택하세요...");
            System.out.println("1.데이터 입력");
            System.out.println("2.데이터 검색");
            System.out.println("3.데이터 삭제");
            System.out.println("4.프로그램 종료");
            System.out.print("선택 ");
            num=sc.nextInt();
            sc.nextLine();
            if(num== ChoiceMenu.programEnd) break;
            try{
                pbm.controlData(num);
            }catch(MenuChoiceException e){
                System.out.println(e.getMessage());
                System.out.println("메뉴 선택을 처음부터 다시 진행합니다.");
            }
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
    public int hashCode(){
        return name.hashCode();
    }
    public boolean equals(Object obj){
        PhoneInfo p=(PhoneInfo)obj;
        String name=p.name;
        if(name.equals(this.name)){
            System.out.println("이미 저장된 데이터 입니다.");
            return true;
        }
        return false;
    }
}

class PhoneUnivInfo extends PhoneInfo {
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

class PhoneCompanyInfo extends PhoneInfo {
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
    Scanner sc = new Scanner(System.in);
    private int idx=0;
    private String name = "";
    private String telNum = "";
    private int choice=0;
    private String major="";
    private int year=0;
    private String company="";
    private Set<PhoneInfo> phoneInfo=new HashSet<>();
    static PhoneBookManager simple=null;
    private void addPhoneInfo(PhoneInfo phone){
        if(phoneInfo.add(phone)==true) System.out.println("데이터 입력이 완료되었습니다....");
    }
    private PhoneBookManager(){}
    public static PhoneBookManager getPhoneBookManager(){
        if(simple==null) simple = new PhoneBookManager();
        return simple;
    }
    public void getNameAndPhone(){
        System.out.print("이름 ");
        name = sc.nextLine();
        System.out.print("전화번호 ");
        telNum = sc.nextLine();
    }
    public void controlData(int num) throws MenuChoiceException {
        if (num == ChoiceMenu.dataInput) {
            System.out.println("데이터 입력을 시작합니다...");
            System.out.print("1.일반 2.대학 3.회사 ");
            choice=sc.nextInt();
            sc.nextLine();

            if(choice== PeopleType.univ){
                getNameAndPhone();
                System.out.print("전공 ");
                major=sc.nextLine();
                System.out.print("학년 ");
                year=sc.nextInt();
                sc.nextLine();
                addPhoneInfo(new PhoneUnivInfo(name,telNum,major,year));
            }else if(choice== PeopleType.company){
                getNameAndPhone();
                System.out.print("회사 ");
                company=sc.nextLine();
                addPhoneInfo(new PhoneCompanyInfo(name,telNum,company));
            }else if(choice== PeopleType.normal){
                getNameAndPhone();
                addPhoneInfo(new PhoneInfo(name,telNum));
            }else{
                MenuChoiceException menuChoiceException = new MenuChoiceException(choice);
                throw menuChoiceException;
            }
        }else if(num== ChoiceMenu.dataSearch){
            System.out.println("데이터 검색을 시작합니다...");
            System.out.print("이름 ");
            name = sc.nextLine();
            Iterator<PhoneInfo> itr=phoneInfo.iterator();
            while(itr.hasNext()){
                PhoneInfo phone = itr.next();
                String pName=phone.name;
                if(pName.equalsIgnoreCase(name)){
                    phone.showPhoneInfo();
                }
            }
            System.out.println("데이터 검색이 완료되었습니다...");
        }else if(num== ChoiceMenu.dataDelete){
            System.out.println("데이터 삭제를 시작합니다...");
            System.out.print("이름 ");
            name = sc.nextLine();
            Iterator<PhoneInfo> itr=phoneInfo.iterator();
            while(itr.hasNext()){
                PhoneInfo phone = itr.next();
                String pName=phone.name;
                if(pName.equalsIgnoreCase(name)){
                    phoneInfo.remove(name);
                }
            }
            System.out.println("데이터 삭제가 완료되었습니다...");
        }else{ // 다른 숫자 입력시
            MenuChoiceException menuChoiceException = new MenuChoiceException(num);
            throw menuChoiceException;
        }
    }
}

interface ChoiceMenu{
    int dataInput=1;
    int dataSearch=2;
    int dataDelete=3;
    int programEnd=4;
}

interface PeopleType{
    int normal=1;
    int univ=2;
    int company=3;
}

class MenuChoiceException extends Exception{
    public MenuChoiceException(int num){
        super(num+"에 해당하는 메뉴는 없습니다.");
    }
}