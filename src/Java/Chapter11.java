package Java;

public class Chapter11 {
    public static void main(String args[]){
        Person man=new Person(950123,880102);
        Person woman=new Person(941125);
        man.showInfo();
        woman.showInfo();

        Human man1=new Human(950123,880102,1995,12,3);
        Human woman1=new Human(981029,1998,10,29);
        man1.showInfo();
        woman1.showInfo();

        java.lang.String str= "My name is shchoi";
        int len=str.length();
        System.out.println("길이 1 :"+len);
        int len2="한글의 길이는 어떻게?".length();
        System.out.println("길이 2 :"+len2);

        String str1="My String";
        String str2="My String";
        String str3="Your String";
        if(str1==str2) System.out.println("\n동일 인스턴스 참조");
        else System.out.println("다른 인스턴스 참조");
        if(str2==str3) System.out.println("동일 인스턴스 참조");
        else System.out.println("다른 인스턴스 참조");

        String cStr="Smart";
        String cStr2=" and ";
        String cStr3="Simple";
        String cStr4=cStr.concat(cStr2).concat(cStr3);
        System.out.println(cStr4);
        System.out.println("문자열 길이 : "+cStr4.length());

        String sStr1="Lemon";
        String sStr2="Lemon";
        String sStr3=new String(sStr2);
        if(sStr1==sStr2) System.out.println("sStr1과 sStr2는 동일 인스턴스 참조");
        else System.out.println("sStr1과 sStr2는 다른 인스턴스 참조");
        if(sStr2==sStr3) System.out.println("sStr2와 sStr3는 동일 인스턴스 참조");
        else System.out.println("sStr2와 sStr3는 다른 인스턴스 참조");

        String hStr1="Lemon"+"ade";
        String hStr2="Lemon"+'A';
        String hStr3="Lemon"+3;
        String hStr4=1+"Lemon"+2;
        hStr4+='!';
        System.out.println(hStr1);
        System.out.println(hStr2);
        System.out.println(hStr3);
        System.out.println(hStr4);

        StringBuilder strBuf=new StringBuilder("AB");
        strBuf.append(25);
        strBuf.append('Y').append(true);
        System.out.println(strBuf);
        strBuf.insert(2,false);
        strBuf.insert(strBuf.length(),'Z');
        System.out.println(strBuf);

        String csh="ABCDEFGHIJKLMN";
        csh=new StringBuilder(csh).reverse().toString();
        System.out.println(csh);

        String csh2="990208-1012752";
        csh2=new StringBuilder(csh2).replace(6,7,"").toString();
        System.out.println(csh2);
    }
    void isYourFunc(int n){}
    void isYourFunc(int n,int n2){}
    void isYourFunc(int n,double n2){}
}
class Person{
    private int perID;
    private int milID;
    public Person(int pID,int mID){
        perID=pID;
        milID=mID;
    }
    public Person(int pID){
        perID=pID;
        milID=0;
    }
    public void showInfo(){
        System.out.println("민번 : "+perID);
        if(milID!=0) System.out.println("군번 : "+milID+'\n');
        else System.out.println("군과 관계 없음 \n");

    }
}

class Human{
    private int perID;
    private int milID;
    private int birthYear;
    private int birthMonth;
    private int birthDay;
    public Human(int perID,int milID,int bYear,int bMonth,int bDay){
        this.perID=perID;
        this.milID=milID;
        birthYear=bYear;
        birthMonth=bMonth;
        birthDay=bDay;
    }
    public Human(int pID,int bYear,int bMonth,int bDay){
        this(pID,0,bYear,bMonth,bDay);
    }
    public void showInfo(){
        System.out.println("민번 : "+perID);
        System.out.println("생년월일 : "+birthYear+"/"+birthMonth+"/"+birthDay);
        if(milID !=0 ) System.out.println("군번 : "+milID+"\n");
        else System.out.println("군과 관계 없음 \n");
    }
}
