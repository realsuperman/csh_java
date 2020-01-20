package Java;

public class Chapter21 {
    public static void main(String args[]){
        /*FruitBox fBox1=new FruitBox();
        fBox1.store(new Orange(10));
        Orange org1=(Orange)fBox1.pullOut();
        org1.showSugarContent();
        FruitBox fBox2=new FruitBox();
        fBox2.store("오렌지");
        Orange org2=(Orange)fBox2.pullOut();
        org2.showSugarContent();

        OrangeBox box1=new OrangeBox();
        box1.store(new Orange(10));
        Orange oran = box1.pullOut();
        oran.showSugarContent();

        OrangeBox box2=new OrangeBox();
        box2.store("오렌지");
        Orange oran2 = box2.pullOut();
        oran2.showSugarContent();
        */
        /*FruitBox<Orange> orBox=new FruitBox<>();
        orBox.store(new Orange(10));
        Orange org=orBox.pullOut();
        org.showSugarContent();
        FruitBox<Apples> apBox=new FruitBox<>();
        apBox.store(new Apples(20));
        Apples app=apBox.pullOut();
        app.showAppleWeight();
        */

        FruitBox<Orange> orBox=new FruitBox<>(new Orange(10));
        Orange org=orBox.pullOut();
        org.showSugarContent();

        FruitBox<Apples> apBox=new FruitBox<>(new Apples(20));
        Apples app=apBox.pullOut();
        app.showAppleWeight();

        AAAAA aaaaa=new AAAAA();
        BBBBB bbbbb=new BBBBB();
        InstanceTypeShower shower=new InstanceTypeShower();
        shower.showInstType(aaaaa);
        shower.showInstType(bbbbb);
        shower.showPrintCnt();
        InstanceTypeShower2 shower2=new InstanceTypeShower2();
        shower2.showInstType(aaaaa,bbbbb);

        AAAAAA aaaaaa = new AAAAAA();
        BBBBBB bbbbbb = new BBBBBB();
        showInstanceAncestor(aaaaaa);
        showInstanceName(aaaaaa);
        showInstanceAncestor(bbbbbb);
        showInstanceName(bbbbbb);

        showInstanceAncestor2(aaaaaa);
        showInstanceName2(aaaaaa);
        showInstanceAncestor2(bbbbbb);
        showInstanceName2(bbbbbb);

        String[] stArr=new String[]{
            "Hi!",
            "I'm so happy",
            "Java Generic Programming"
        };
        showArrayData(stArr);

        FruitBox_csh<Fruit_csh> box1=new FruitBox_csh<>();
        box1.store(new Fruit_csh());
        FruitBox_csh<Apple_csh> box2=new FruitBox_csh<>();
        box2.store(new Apple_csh());
        openAndShowFruitBox(box1);
        openAndShowFruitBox(box2);
    }
    public static <T> void showInstanceAncestor(T param){
        ((SimpleInterface)param).showYourName();
    }
    public static <T> void showInstanceName(T param){
        ((UpperClass)param).showYourAncestor();
    }
    public static <T extends SimpleInterface> void showInstanceAncestor2(T param){
        param.showYourName();
    }
    public static<T extends UpperClass> void showInstanceName2(T param){
        param.showYourAncestor();
    }
    public static <T> void showArrayData(T[] arr){
        for(int i=0;i<arr.length;i++) System.out.println(arr[i]);
    }
    public static void openAndShowFruitBox(FruitBox_csh<? extends Fruit_csh> box){
        Fruit_csh fruit=box.pullOut();
        fruit.showYou();
    }
}

class Orange{
    int sugarContent;
    public Orange(int sugar){sugarContent=sugar;}
    public void showSugarContent(){System.out.println("당도 "+sugarContent);}
}


class Apples{
    int weight;
    public Apples(int weight){this.weight=weight;}
    public void showAppleWeight(){System.out.println("무게 "+weight);}
}

class FruitBox<T>{
    T item;
    public FruitBox(T item){
        this.item=item;
    }
    public void store(T item){this.item=item;}
    public T pullOut(){return item;}
}

class OrangeBox{
    Orange item;
    public void store(Orange item){this.item=item;}
    public Orange pullOut(){return item;}
}

class AAAAA{
    public String toString(){return "Class AAAAA";}
}

class BBBBB{
    public String toString(){return "Class BBBBB";}
}

class InstanceTypeShower{
    int showCnt=0;
    public <T> void showInstType(T inst){
        System.out.println(inst);
        showCnt++;
    }
    void showPrintCnt(){System.out.println("Show count :"+showCnt);}
}

class InstanceTypeShower2{
    public <T,U> void showInstType(T inst1,U inst2){
        System.out.println(inst1);
        System.out.println(inst2);
    }
}

class MyClass{
    public <T> void simpleMethod(T param){
        //param.showData();
        System.out.println(param);
    }
}

interface SimpleInterface{
    public void showYourName();
}

class UpperClass{
    public void showYourAncestor(){
        System.out.println("UpperClass");

    }
}

class AAAAAA extends UpperClass implements SimpleInterface{
    public void showYourName(){
        System.out.println("Class AAAAAA");
    }
}

class BBBBBB extends UpperClass implements SimpleInterface{
    public void showYourName(){
        System.out.println("Class BBBBBB");
    }
}

class Fruit_csh{
    public void showYou(){
        System.out.println("난 과일입니다.");
    }
}

class Apple_csh extends Fruit_csh{
    public void showYou(){
        super.showYou();
        System.out.println("난 붉은 과일입니다.");
    }
}

class FruitBox_csh<T>{
    T item;
    public void store(T item){this.item=item;}
    public T pullOut(){return item;}
}