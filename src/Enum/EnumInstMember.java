package Enum;

import java.util.Scanner;

public class EnumInstMember {
    public static void main(String args[]) {
        System.out.print("SEOUL,BUSAN,JEJU >> ");
        Scanner keyboard=new Scanner(System.in);
        String where=keyboard.nextLine();
        where= where.toUpperCase();
        City dest=City.valueOf(City.class,where);
        switch(dest){
            case SEOUL : System.out.println("가시려는 서울의 인구 : "+dest.getPopulation());
            case BUSAN : System.out.println("가시려는 부산의 인구 : "+dest.getPopulation());
            case JEJU : System.out.println("가시려는 제주의 인구 : " + dest.getPopulation());
        }
    }
}

enum City{
    SEOUL(200),BUSAN(100),JEJU(50);
    City(int popu){
        population=popu;
    }
    int population; // 인구
    public int getPopulation(){
        return population;
    }
}