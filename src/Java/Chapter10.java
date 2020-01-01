package Java;

public class Chapter10 {
    public static void main(String args[]){
        InstCnt cnt1 = new InstCnt();
        InstCnt cnt2 = new InstCnt();
        InstCnt cnt3 = new InstCnt();
        System.out.println(InstCnt.instNum);
        CircleClass circle = new CircleClass(1.2);
        circle.showPerimeter();
        circle.showArea();
        NumberPrinter.showInt(3);
        NumberPrinter number = new NumberPrinter();
        number.showInt(3);
        Employer emr = new Employer(3000);
        Employee eme = new Employee(0);
        emr.payForWork(eme,1000);
        emr.showMyMoney();
        eme.showMyMoney();
        SimpleNumber num1=SimpleNumber.getSimpleNumberInst();
        num1.addNum(20);
        SimpleNumber num2=SimpleNumber.getSimpleNumberInst();
        num2.addNum(30);
        //if(num1==num2){System.out.println("test");} -> 같은 객체를 가리키는지 체크
        num1.showNum();
        num2.showNum();
    }
}
class InstCnt{
    static int instNum=0;
    public InstCnt(){
        instNum++;
        System.out.println("인스턴스 생성 : "+instNum);
    }
}

class CircleClass{
    static final double PI=3.1415;
    private double radius;
    public CircleClass(double rad){radius=rad;}
    public void showPerimeter(){
        double peri=(radius*2)*PI;
        System.out.println("둘레 : "+peri);
    }
    public void showArea(){
        double area=(radius*radius)*PI;
        System.out.println("넓이 : "+area);
    }
}

class NumberPrinter{
    public static void showInt(int n){System.out.println(n);}
    public static void showDouble(double n){System.out.println(n);}
}

class SimpleMath{
    public static final double PI=3.1415;
    public double add(double n1,double n2){return n1+n2;}
    public double min(double n1,double n2){return n1-n2;}
    public double mul(double n1,double n2){return n1*n2;}
}
class AAA{
    int num1;
    static int num2;
    static void changeNum(){
        //num1++;
        num2++;
    }
}

class Employer{
    private int myMoney;
    public Employer(int money){
        myMoney=money;
    }
    public void payForWork(Employee emp,int money){
        if(myMoney<money) return;
        emp.earnMoney(money);
        myMoney-=money;
    }
    public void showMyMoney(){
        System.out.println(myMoney);
    }
}

class Employee{
    private int myMoney;
    public Employee(int money){
        myMoney=money;
    }
    public void earnMoney(int money){
        myMoney+=money;
    }
    public void showMyMoney(){
        System.out.println(myMoney);
    }
}

class SimpleNumber{
    static SimpleNumber simple=null;
    int num=0;
    private SimpleNumber(){} // 생성자 private
    public void addNum(int n){num+=n;}
    public void showNum(){System.out.println(num);}
    public static SimpleNumber getSimpleNumberInst(){
        if(simple==null) simple = new SimpleNumber();
        return simple;
    }
}