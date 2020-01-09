package Java;

public class Chapter15 {
    public static void main(String args[]){
        NoteBookComp nc = new NoteBookComp("이수종",5);
        TabletNoteBook tn = new TabletNoteBook("정수영",5,"ISE-241-242");
        nc.movingCal();
        tn.write("ISE-241-242");

        Police pman=new Police(5,3);
        pman.shot();
        pman.putHandcuff();

        cPolice haveGun = new cPolice(5,3);
        haveGun.shot();
        haveGun.putHandcuff();

        cPolice dontHaveGun= new cPolice(0,3);
        dontHaveGun.shot();

        BaseEnSpeaker bs=new BaseEnSpeaker();
        bs.setVolume(10);
        bs.setBaseRate(20);
        bs.showCurrentState();

        /*Speaker bs2=new BaseEnSpeaker();
        bs.setVolume(10);
        bs.setBaseRate(20);
        bs.showCurrentState();
        */

        A ref1=new C();
        B ref2=new C();
        C ref3=new C();
        ref1.rideMethod();
        ref2.rideMethod();
        ref3.rideMethod();
        ref3.loadMethod();
        ref3.loadMethod(1);
        ref3.loadMethod(1.2);

        CC cRef=new CC();
        BB cRef2=cRef;
        AA cRef3=cRef;
        System.out.println(cRef.num);
        System.out.println(cRef2.num);
        System.out.println(cRef3.num);

        CCCC ref= new CCCC();
        ref.showAllNums();

        Box box1 = new Box();
        PaperBox box2 = new PaperBox();
        GoldPaperBox box3 = new GoldPaperBox();
        InstanceOf.wrapBox(box1);
        InstanceOf.wrapBox(box2);
        InstanceOf.wrapBox(box3);
    }
}

class Computer{
    String owner;
    public Computer(String name){owner=name;}
    public void calculate(){System.out.println("요청 내용을 계산합니다.");}
}

class NoteBookComp extends Computer{
    int battery;
    public NoteBookComp(String name,int initChag){
        super(name);
        battery=initChag;
    }
    public void charging() {battery+=5;}
    public void movingCal(){
        if(battery<1){
            System.out.println("충전이 필요합니다.");
            return;
        }
        System.out.print("이동하면서 ");
        calculate();
        battery-=1;
    }
}

class TabletNoteBook extends NoteBookComp{
    String regstPenModel;
    public TabletNoteBook(String name,int initChag,String pen){
        super(name,initChag);
        regstPenModel=pen;
    }
    public void write(String penInfo){
        if(battery<1){
            System.out.println("충전이 필요합니다.");
            return ;
        }
        if(regstPenModel.compareTo(penInfo)!=0){
            System.out.println("등록된 펜이 아닙니다.");
            return;
        }
        System.out.println("필기 내용을 처리합니다.");
        battery-=1;
    }
}

class Gun{
    int bullet;
    public Gun(int bnum){bullet=bnum;}
    public void shot(){
        System.out.println("BBANG!");
        bullet--;
    }
}

class Police extends Gun {
    int handcuffs;

    public Police(int bnum, int bcuff) {
        super(bnum);
        handcuffs = bcuff;
    }

    public void putHandcuff() {
        System.out.println("SNAP!");
        handcuffs--;
    }
}

class Cgun{
    int bullet;
    public Cgun(int bnum){bullet=bnum;}
    public void shot(){
        System.out.println("BBANG!");
        bullet--;
    }
}

class cPolice{
    int handcuffs;
    Cgun pistol;
    public cPolice(int bnum,int bcuff){
        handcuffs=bcuff;
        if(bnum!=0) pistol=new Cgun(bnum);
        else pistol = null;
    }
    public void putHandcuff(){
        System.out.println("SNAP!");
        handcuffs--;
    }
    public void shot(){
        if(pistol==null) System.out.println("Hut BBANG!");
        else pistol.shot();
    }
}

class Speaker{
    private int volumeRate;
    public void showCurrentState(){
        System.out.println("볼륨 크기 : "+volumeRate);
    }
    public void setVolume(int vol){
        volumeRate=vol;
    }
}

class BaseEnSpeaker extends Speaker{
    private int baseRate;
    public void showCurrentState(){
        super.showCurrentState();
        System.out.println("베이스 크기 : "+baseRate);
    }
    public void setBaseRate(int base){
        baseRate=base;
    }
}

class A{
    public void rideMethod(){System.out.println("AAA's Method");}
    public void loadMethod(){System.out.println("void Method");}
}

class B extends A{
    public void rideMethod(){System.out.println("BBB's Method");}
    public void loadMethod(int num){System.out.println("int Method");}
}

class C extends B{
    public void rideMethod(){System.out.println("CCC's Method");}
    public void loadMethod(double num){System.out.println("double Method");}
}

class AA{
    public int num=2;
}

class BB extends AA{
    public int num=5;
}

class CC extends BB{
    public int num=7;
}

class AAAA{
    public int num=2;
}

class BBBB extends AAAA{
    public int num=5;
    public void showSuperNum(){
        System.out.println(super.num);
    }
}

class CCCC extends BBBB{
    public int num=7;
    public void showAllNums(){
        super.showSuperNum();
        System.out.println(super.num);
        System.out.println(num);
    }
}

class Box{
    public void simpleWrap(){System.out.println("simple wrap");}
    public void wrap(){simpleWrap();}
}

class PaperBox extends Box{
    public void paperWrap() {System.out.println("paper wrap");}
    public void wrap(){paperWrap();}
}

class GoldPaperBox extends PaperBox{
    public void goldWrap(){System.out.println("gold wrap");}
    public void wrap(){goldWrap();}
}

class InstanceOf{
    public static void wrapBox(Box box){
        /*if(box instanceof GoldPaperBox) ((GoldPaperBox)box).goldWrap();
        else if(box instanceof PaperBox) ((PaperBox)box).paperWrap();
        else box.simpleWrap();
         */
        box.wrap();
    }
}