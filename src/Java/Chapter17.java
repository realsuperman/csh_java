package Java;

import java.util.Scanner;

public class Chapter17 {
    public static void main(String args[]) {
        PersonalNumberStorage storage = new PersonalNumberStorageImpl(100);
        storage.addPersonalInfo("김기동", "950000-1122333");
        storage.addPersonalInfo("장산길", "970000-1122334");
        System.out.println(storage.searchName("950000-1122333"));
        System.out.println(storage.searchName("970000-1122334"));

        System.out.println("오늘의 요일을 선택하세요.");
        System.out.println("1.월요일, 2.화요일, 3.수요일, 4.목요일");
        System.out.println("5.금요일, 6.토요일, 7.일요일");
        System.out.print("선택 : ");
        Scanner sc = new Scanner(System.in);
        int sel=sc.nextInt();
        switch(sel){
            case Week.MON : System.out.println("주간회의가 있습니다."); break;
            case Week.TUE : System.out.println("프로젝트 기획 회의가 있습니다."); break;
            case Week.WED : System.out.println("진행사항 보고하는 날입니다."); break;
            case Week.THU : System.out.println("사내 축구시합이 있는 날입니다."); break;
            case Week.FRI : System.out.println("프로젝트 마감일입니다."); break;
            case Week.SAT : System.out.println("가족과 함께 즐거운 시간을 보내세요"); break;
            case Week.SUN : System.out.println("오늘은 휴일입니다."); break;
        }
        Cpoint pos1=new Cpoint(1,2);
        Cpoint pos2=new Cpoint(5,9);
        ClassPrinter.print(pos1);
        ClassPrinter.print(pos2);

        PointOne cPos1=new PointOne(1,1);
        PointTwo cPos2=new PointTwo(2,2);
        PointOne cPos3=new PointOne(3,3);
        PointTwo cPos4=new PointTwo(4,4);
        ClassPrinter.print(cPos1);
        ClassPrinter.print(cPos2);
        ClassPrinter.print(cPos3);
        ClassPrinter.print(cPos4);

        IPTV iptv=new IPTV();
        iptv.powerOn();
        TV tv=iptv;
        Com com=iptv;

        OuterClassOne one = new OuterClassOne();
        OuterClassTwo two = new OuterClassTwo();
        OuterClassOne.NestedClass nst1 = new OuterClassOne.NestedClass();
        nst1.simpleMethod();

        OuterClass out1=new OuterClass("First");
        OuterClass out2=new OuterClass("Secode");
        out1.whoAreYou();
        out2.whoAreYou();
        OuterClass.InnerClass inn1=out1.new InnerClass();
        OuterClass.InnerClass inn2=out2.new InnerClass();
        OuterClass.InnerClass inn3=out1.new InnerClass();
        OuterClass.InnerClass inn4=out1.new InnerClass();
        OuterClass.InnerClass inn5=out2.new InnerClass();

        /*OuterClass_csh csh=new OuterClass_csh("First");
        Readable localInst1=csh.createLocalClassInst();
        localInst1.read();
        OuterClass_csh csh2 = new OuterClass_csh("Second");
        Readable localInst2 = csh2.createLocalClassInst();
        localInst2.read();
        */

        OuterClass_csh csh3 = new OuterClass_csh("My Outer Class");
        Readable localInst1 = csh3.createLocalClassInst(111);
        localInst1.read();

        Readable localInst2 = csh3.createLocalClassInst(222);
        localInst2.read();

        OuterClass_sh sh = new OuterClass_sh("My Outer Class");
        Readable localInst3=sh.createLocalClassInst(111);
        localInst3.read();
        Readable localInst4=sh.createLocalClassInst(222);
        localInst4.read();
    }
}

interface PersonalNumberStorage{
    void addPersonalInfo(String name,String perNum);
    String searchName(String perNum);
}

class PersonalNumInfo{
    String name;
    String number;
    PersonalNumInfo(String name,String number){
        this.name=name;
        this.number=number;
    }
    String getName(){return name;}
    String getNumber(){return number;}
}

class PersonalNumberStorageImpl implements PersonalNumberStorage{
    PersonalNumInfo[] perArr;
    int numOfPerInfo;
    public PersonalNumberStorageImpl(int sz){
        perArr=new PersonalNumInfo[sz];
        numOfPerInfo=0;
    }
    public void addPersonalInfo(String name,String perNum){
        perArr[numOfPerInfo]=new PersonalNumInfo(name,perNum);
        numOfPerInfo++;
    }
    public String searchName(String perNum){
        for(int i=0;i<numOfPerInfo;i++){
            if(perNum.compareTo(perArr[i].getNumber())==0) return perArr[i].getName();
        }
        return null;
    }

}

interface Week{
    int MON=1,TUE=2,WED=3,THU=4,FRI=5,SAT=6,SUN=7;
}

interface UpperCasePrintable{

}

class ClassPrinter{
    public static void print(Object obj){
        String org=obj.toString();
        if(obj instanceof UpperCasePrintable){
            org=org.toUpperCase();
        }
        System.out.println(org);
    }
}

class PointOne implements UpperCasePrintable{
    private int xPos,yPos;
    PointOne(int x,int y){
        xPos=x;
        yPos=y;
    }
    public String toString(){
        String posInfo="[x pos : "+xPos+", y pos : "+yPos+"]";
        return posInfo;
    }
}

class PointTwo{
    private int xPos,yPos;
    PointTwo(int x,int y){
        xPos=x;
        yPos=y;
    }
    public String toString(){
        String posInfo="[x pos : "+xPos+", y pos : "+yPos+"]";
        return posInfo;
    }
}

class Cpoint{
    private int xPos,yPos;
    Cpoint(int x,int y){
        xPos=x;
        yPos=y;
    }
    public String toString(){
        String posInfo="[x:"+xPos+ ", y : "+yPos+"]";
        return posInfo;
    }
}

interface TV{
    public void onTV();
}

interface Com{
    public void dataReceive();
}

class TVImpl{
    public void onTV(){System.out.println("영상 출력 중");}
}

class ComImpl{
    public void dataReceive(){
        System.out.println("영상 데이터 수신 중");
    }
}

class IPTV implements TV,Com{
    ComImpl comp = new ComImpl();
    TVImpl tv = new TVImpl();
    public void dataReceive(){
        comp.dataReceive();
    }
    public void onTV(){
        tv.onTV();
    }
    public void powerOn(){
        dataReceive();
        onTV();
    }
}

class OuterClassOne{
    OuterClassOne(){
        NestedClass nst=new NestedClass();
        nst.simpleMethod();
    }
    static class NestedClass{
        public void simpleMethod(){
            System.out.println("Nested Instace Method One");
        }
    }
}

class OuterClassTwo{
    OuterClassTwo(){
        NestedClass nst = new NestedClass();
        nst.simpleMethod();
    }
    private static class NestedClass{
        public void simpleMethod(){
            System.out.println("Nested Instance Method Two");
        }
    }
}

class OuterClass{
    private String myName;
    private int num;
    OuterClass(String name){
        myName=name;
        num=0;
    }
    public void whoAreYou(){
        num++;
        System.out.println(myName+" OuterClass "+num);
    }
    class InnerClass{
        InnerClass(){
            whoAreYou();
        }
    }
}

interface Readable{
    public void read();
}

class OuterClass_csh{
    private String myName;
    OuterClass_csh(String name){
        myName=name;
    }
    public Readable createLocalClassInst(final int instID){
        class LocalClass implements Readable{
            public void read(){
                System.out.println("Outer inst name : "+myName);
                System.out.println("Local inst ID : "+instID);
            }
        }
        return new LocalClass();
    }
}

class OuterClass_sh{
    private String myName;
    OuterClass_sh(String name){
        myName=name;
    }
    public Readable createLocalClassInst(final int instID){
        return new Readable() {
            public void read() {
                System.out.println("Outer inst name : " + myName);
                System.out.println("Local inst ID " + instID);
            }
        };
    }
}