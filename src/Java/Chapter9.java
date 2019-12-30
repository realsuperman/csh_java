package Java;

public class Chapter9 {
    public static void main(String args[]){
        buyApple apple = new buyApple();
        apple.buyApple(1000);
        Apple ap = new Apple();
        ap.setApple(10);
        ap.getApple();
        Rectangle rec=new Rectangle();
        rec.setValue(22,22,10,10);
        rec.showArea();
        Ring ring=new Ring(1,1,4,2,2,9);
        ring.showPointInfo();
    }
}

class buyApple{
    int apple=10;
    int money=0;
    int count=0;
    public int buyApple(int money){
        this.money=money;
        count++;
        return count;
    }
}

class Apple{
    private int apple=0;
    public void setApple(int apple){ this.apple=apple;}
    public void getApple(){System.out.println(apple);}
}

class Rectangle {
    private int ulx,uly;
    private int lrx,lry;
    public void setValue(int x1,int y1,int x2,int y2){
        if(x1<0 || x1>100){ System.out.println("ulx값의 범위는 0~100사이여야 합니다."); return;}
        if(y1<0 || y1>100){ System.out.println("uly값의 범위는 0~100사이여야 합니다."); return;}
        if(x2<0 || x2>100){ System.out.println("lrx값의 범위는 0~100사이여야 합니다."); return;}
        if(y2<0 || y2>100){ System.out.println("lry값의 범위는 0~100사이여야 합니다."); return;}
        if( x2<x1 && y2<y1) {
            ulx = x1;
            uly = y1;
            lrx = x2;
            lry = y2;
        }
    }
    public void showArea(){
        int xLen=lrx-ulx;
        int yLen=lry-uly;
        System.out.println("넓이 : " +(xLen*yLen));
    }
}

class Point{
    int xPos,yPos;
    public Point(int x,int y){
        xPos=x;
        yPos=y;
    }
    public void showPointInfo(){System.out.println("["+xPos+", "+yPos+"]");}
}

class Circle{
    Point point;
    int r;
    public  Circle(int x,int y,int r){
        point = new Point(x,y);
        this.r=r;
    }
    public void printPoint(){
        System.out.println("radius : " + r);
        point.showPointInfo();
    }

}

class Ring{
    Circle innerCircle;
    Circle outerCircle;
    public Ring(int x,int y,int r,int x2,int y2,int r2){
        innerCircle=new Circle(x,y,r);
        outerCircle=new Circle(x2,y2,r2);
    }
    public void showPointInfo(){
        System.out.println("Inner Circle Info...");
        innerCircle.printPoint();
        System.out.println("Outer Circle Info...");
        outerCircle.printPoint();
    }
}