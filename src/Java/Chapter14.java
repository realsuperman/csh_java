package Java;

public class Chapter14 {
    public static void main(String args[]){
        BusinessMan man1 = new BusinessMan("Mr.Hong","Hybrid 3D ELD","Staff Eng.");
        BusinessMan man2 = new BusinessMan("Mr. Lee","Hybrid 3D ELF","Assist Eng.");
        System.out.println("First man info..........");
        man1.tellYourName();
        man1.tellYourIfo();
        System.out.println("Second man info..........");
        man2.tellYourIfo();
        SavingAccount sa = new SavingAccount(1000);
        sa.saveMoney(1000);
        sa.saveMoney(1000);
        sa.showSavedMoney();
        Adder ad = new Adder();
        AdderFriend af = new AdderFriend();
        ad.add(1);
        af.friendAdd(3);
        AdderFriend.val+=5;
        af.showVal();
    }
}

class Man{
    private String name;
    public Man(String name){this.name=name;}
    public void tellYourName(){System.out.println("My name is "+name);}
}

class BusinessMan extends Man{
    private String company;
    private String position;
    public BusinessMan(String name,String company,String position){
        super(name);
        this.company=company;
        this.position=position;
    }
    public void tellYourIfo(){
        System.out.println("My company is "+company);
        System.out.println("My position is "+position);
        tellYourName();
    }
}

class Car {
    int gasolineGauge;
    public Car(int gasolineGauge){
        this.gasolineGauge = gasolineGauge;
    }
}

class HybridCar extends Car{
    int electricGauge;
    public HybridCar(int electricGauge,int gasolineGauge){
        super(gasolineGauge);
        this.electricGauge=electricGauge;
    }
}

class HybridWaterCar extends HybridCar {
    int waterGauge;
    public HybridWaterCar(int gasolineGauge,int electricGauge,int waterGauge){
        super(electricGauge,gasolineGauge);
        this.waterGauge=waterGauge;
    }
    public void showCurrentGauge(){
        System.out.println("잔여 가솔린 : "+gasolineGauge);
        System.out.println("잔여 전기량 : "+electricGauge);
        System.out.println("잔여 워터량 : "+waterGauge);
    }
}

class Accumulator{
    private int val;
    Accumulator(int init){val=init;}
    protected void accumulate(int num){
        if(num<0) return;
        val+=num;
    }
    protected int getAccVal(){return val;}
}

class SavingAccount extends Accumulator{
    public SavingAccount(int initDep){
        super(initDep);
    }
    public void saveMoney(int money){
        accumulate(money);
    }
    public void showSavedMoney(){
        System.out.println("지금까지의 누적 금액 : ");
        System.out.println(getAccVal());
    }
}

class Adder{
    public static int val=0;
    public void add(int num){val+=num;}
}

class AdderFriend extends Adder{
    public void friendAdd(int num) {val+=num;}
    public void showVal() {System.out.println(val);}
}
