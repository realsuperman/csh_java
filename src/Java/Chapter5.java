package Java;

public class Chapter5 {
    public static void main(String args[]){
        int num=100;

        if(num>=100){
            System.out.println("100이상");
        }else if(num==101){
            System.out.println("101이다.");
        }else{
            System.out.println("100미만");
        }

        if(num>=100)
            System.out.println("100이상");
        else if(num==101)
            System.out.println("101이다.");
        else
            System.out.println("100미만");

        int a=100;
        int sum=(a>100)?1:(a==100)?100:0;

        switch(a){
            case 1 :
                System.out.println("1이다.");
                break;
            case 2 :
                System.out.println("2이다.");
                break;
            default :
                break;
        }

        //while문
        int number=0;
        while(number<5){
            number++; //선증가
            System.out.println(number);
        }
        number=0;
        while(number<5){
            System.out.println(number);
            number++; //후증가
        }

        do{
            System.out.println("!!");
        }while(false);

        for(int i=0;i<10;i++){
            System.out.println("Hello World");
        }

        int hap=0;
        for(int i=1;i<101;i++){ //1부터 100까지의 합
            hap+=i;
        }
        for(int i=1;i<10;i++){ //구구단 9단
            System.out.println(i*9);
        }
        hap=0;
        for(int i=1;i<1000;i++){ //7의 배수
            if(i%7==0) hap+=i;
        }
        hap=0;
        for(int i=1;i<1000;i++){ //7의 배수 이면서 5의배수
            if(i%7==0 && i%5==0) hap+=i;
        }
        for(int i=1;i<10;i++){ // 짝수단 자기자신 까지 출력
            if (i % 2 == 1) continue;
            for(int j=1;j<10;j++) {
                System.out.println(i+"*"+j+"= "+(i*j));
                if(i==j) break;
            }
        }
        for(int i=1;i<10;i++){ //AB + BA == 99 인걸 만족하는것.
            for(int j=1;j<10;j++){
                if( ((i*10)+(j*1))+ ((i*1)+(j*10)) == 99 ){
                    System.out.println("i는 "+i+" j는"+j);
                }
            }
        }
    }
}
