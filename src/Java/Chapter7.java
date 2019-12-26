package Java;

public class Chapter7 {
    public static void main(String args[]){
        /*FruitSeller seller1 = new FruitSeller(0,30,1500);
        FruitSeller seller2 = new FruitSeller(0,20,1000);
        FruitBuyer buyer = new FruitBuyer(10000);
        buyer.buyApple(seller1,4500);
        buyer.buyApple(seller2,2000);
        System.out.println("과일 판매자1의 현재 상황");
        seller1.showSaleResult();
        System.out.println("과일 판매자2의 현재 상황");
        seller2.showSaleResult();
        System.out.println("과일 구매자의 현재 상황");
        buyer.showBuyResult();
        Triangle t = new Triangle(3,5);
        t.printArea();
        BeadGame child1 = new BeadGame(15); // 1번째 아이의 구슬 갯수 세팅
        BeadGame child2 = new BeadGame(9);  // 2번째 아이의 구슬 갯수 세팅
        child1.beadPlay(child2,2);
        child2.beadPlay(child1,7);
        child1.printBead();
        child2.printBead();
         */
    }
}

class FruitSeller{
    int numOfApple;
    int myMoney;
    final int APPLE_PRICE;
    public FruitSeller(int money,int appleNum,int price){
        myMoney=money;
        numOfApple=appleNum;
        APPLE_PRICE=price;
    }
    public int saleApple(int money){
        int num=money/APPLE_PRICE;
        numOfApple-=num;
        myMoney+=money;
        return num;
    }
    public void showSaleResult(){
        System.out.println("남은 사과 :"+numOfApple);
        System.out.println("판매 수익 : "+myMoney);
    }
}

class FruitBuyer{
    int myMoney;
    int numOfApple;
    public FruitBuyer(int money){
        myMoney=money;
        numOfApple=0;
    }
    public void buyApple(FruitSeller seller,int money){
        numOfApple+=seller.saleApple(money);
        myMoney-=money;
    }
    public void showBuyResult(){
        System.out.println("현재 잔액 : "+myMoney);
        System.out.println("사과 개수 : "+numOfApple);
    }
}

class Triangle{
    int height;
    int bottom;
    public Triangle(int height,int bottom){
        this.height = height;
        this.bottom = bottom;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public void setBottom(int bottom){
        this.bottom = bottom;
    }
    public void printArea(){
        System.out.println(0.5*height*bottom);
    }
}

class BeadGame{
    int bead;
    public BeadGame(int bead){ // 구슬 갯수 설정
        this.bead=bead;
    }
    public void addBead(BeadGame bg,int cnt){
        bg.bead+=cnt;
    }
    public void minusBead(BeadGame bg,int cnt){
        bg.bead-=cnt;
    }
    public void beadPlay(BeadGame bg,int cnt){ //처음 인자의 객체를 얻는 객체 두번째 인자의 객체를 뺏기는 객체
        addBead(this,cnt);
        bg.minusBead(bg,cnt);
    }
    public void printBead(){
        System.out.println("해당 어린이의 구슬 갯수는 : "+bead+"개 입니다.");
    }
}