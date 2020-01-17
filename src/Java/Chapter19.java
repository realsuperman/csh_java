package Java;

public class Chapter19 {
    public static void main(String args[]){
        MyName obj1=new MyName("인스턴스1");
        MyName obj2=new MyName("인스턴스2");
        obj1=null;
        obj2=null;
        System.out.println("프로그램을 종료합니다.");
        // System.gc();
        // System.runFinalization();
        IntNumber num1=new IntNumber(10);
        IntNumber num2=new IntNumber(12);
        IntNumber num3=new IntNumber(10);
        if(num1.isEquals(num2)) System.out.println("num1과 num2는 동일한 정수");
        else System.out.println("num1과 num2는 다른 정수");
        if(num1.isEquals(num3)) System.out.println("num1과 num3는 동일한 정수");
        else System.out.println("num1과 num3는 다른 정수");
        if(num1.equals(num2)) System.out.println("num1과 num2는 동일한 정수");
        else System.out.println("num1과 num2는 다른 정수");
        if(num1.equals(num3)) System.out.println("num1과 num3는 동일한 정수");
        else System.out.println("num1과 num3는 다른 정수");

        String str1=new String("Hi my string");
        String str2=new String("Hi my string");
        if(str1==str2) System.out.println("참조 대상이 동일하다.");
        else System.out.println("참조 대상이 동일하지 않다.");
        if(str1.equals(str2)) System.out.println("인스턴스 내용이 동일하다.");
        else System.out.println("인스턴스 내용이 동일하지 않다.");
        Srectangle a=new Srectangle(1,1,2,2);
        Srectangle b=new Srectangle(1,1,2,2);
        Srectangle c=new Srectangle(2,2,2,2);
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));

        hPoint org=new hPoint(3,5);
        hPoint cpy;
        try{
            cpy=(hPoint)org.clone();
            org.showPosition();
            cpy.showPosition();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }

        Hrectangle hre=new Hrectangle(1,1,9,9);
        Hrectangle cHre;
        try{
            cHre=(Hrectangle)hre.clone();
            hre.changePos(2,2,7,7);
            hre.showPosition();
            cHre.showPosition();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }

        try{
            People p1=new People("이승원",22);
            People p2=(People)p1.clone();
            p2.changeName("정혜영");
            People p3=(People)p2.clone();
            p3.changeName("정승주");
            p1.showPersonInfo();
            p2.showPersonInfo();
            p3.showPersonInfo();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }

        try{
            PersonalInfomation pInfo = new PersonalInfomation("James",22,"HiMedia","encoding");
            PersonalInfomation pCopy = (PersonalInfomation)pInfo.clone();
            pCopy.changeWork("decoding");
            pInfo.showPersonalInfomation();
            pCopy.showPersonalInfomation();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
    }
}

class MyName extends Object{
    String objName;
    public MyName(String name){
        objName=name;
    }

    protected void finalize() throws Throwable{
        super.finalize();
        System.out.println(objName+"이 소멸되었습니다.");
    }

}

class IntNumber{
    int num;
    public IntNumber(int num){this.num=num;}
    public boolean isEquals(IntNumber numObj){
        if(this.num==numObj.num) return true;
        else return false;
    }
    public boolean equals(Object obj){
        if(this.num==((IntNumber)obj).num) return true;
        else return false;
    }
}

class Spoint{
    int xPos,yPos;
    public Spoint(int x,int y){
        xPos=x;
        yPos=y;
    }
    public void showPosition(){
        System.out.printf("[%d,%d]",xPos,yPos);
    }
}

class Srectangle{
    Spoint upperLeft,lowerRight;
    public Srectangle(int x1,int y1,int x2,int y2){
        upperLeft=new Spoint(x1,y1);
        lowerRight=new Spoint(x2,y2);
    }
    public void showPosition(){
        System.out.println("직사각형 위치정보...");
        System.out.print("좌 상단 : ");
        upperLeft.showPosition();
        System.out.println();
        System.out.print("우 하단 : ");
        lowerRight.showPosition();
        System.out.println("\n");
    }
    public boolean equals(Object obj){
        if(this.upperLeft.xPos == ((Srectangle)obj).upperLeft.xPos && this.upperLeft.yPos == ((Srectangle)obj).upperLeft.yPos
        && this.lowerRight.xPos == ((Srectangle)obj).lowerRight.xPos && this.lowerRight.yPos == ((Srectangle)obj).lowerRight.yPos){
            return true;
        }
        return false;
    }
}

class hPoint extends Object implements Cloneable{
    private int xPos;
    private int yPos;
    public hPoint(int x,int y){
        xPos=x;
        yPos=y;
    }
    public void showPosition(){
        System.out.printf("[%d,%d]",xPos,yPos);
        System.out.println();
    }

    public void changePos(int x,int y){
        xPos=x;
        yPos=y;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}

class Hrectangle implements Cloneable{
    hPoint upperLeft,lowerRight;
    public Hrectangle(int x1,int y1,int x2,int y2){
        upperLeft=new hPoint(x1,y1);
        lowerRight=new hPoint(x2,y2);
    }
    public void showPosition(){
        System.out.println("직사각형 위치정보...");
        System.out.print("좌 상단 : ");
        upperLeft.showPosition();
        System.out.println();
        System.out.print("우 하단 : ");
        lowerRight.showPosition();
        System.out.println("\n");
    }
    public void changePos(int x1,int y1,int x2,int y2){
        upperLeft.changePos(x1,y1);
        lowerRight.changePos(x2,y2);
    }
    public Object clone() throws CloneNotSupportedException{
        Hrectangle copy=(Hrectangle)super.clone();
        copy.upperLeft=(hPoint)upperLeft.clone();
        copy.lowerRight=(hPoint)lowerRight.clone();
        return copy;
    }
}

class People implements Cloneable{
    private String name;
    private int age;
    public People(String name,int age){
        this.name=name;
        this.age=age;
    }
    public void changeName(String name){
        this.name=name;
    }
    public void showPersonInfo(){
        System.out.println("이름 : "+name);
        System.out.println("나이 : "+age);
        System.out.println();
    }
    public Object clone() throws CloneNotSupportedException{
        People copy = (People)super.clone();
        return copy;
    }
}

class Business implements Cloneable{
    private String company;
    private String work;
    public Business(String company,String work){
        this.company=company;
        this.work=work;
    }
    public void showBusinessInfo(){
        System.out.println("회사 : "+company);
        System.out.println("업무 : "+work);
    }
    public void changeWork(String work){
        this.work=work;
    }
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}

class PersonalInfomation implements Cloneable{
    private String name;
    private int age;
    private Business bness;
    public PersonalInfomation(String name,int age,String company,String work){
        this.name=name;
        this.age=age;
        bness=new Business(company,work);
    }
    public void showPersonalInfomation(){
        System.out.println("이름 : "+name);
        System.out.println("나이 : "+age);
        bness.showBusinessInfo();
        System.out.println();
    }
    public void changeWork(String work){
        bness.changeWork(work);
    }
    public Object clone() throws CloneNotSupportedException{
        PersonalInfomation copy=(PersonalInfomation)super.clone();
        copy.bness = (Business)bness.clone();
        return copy;
    }
}