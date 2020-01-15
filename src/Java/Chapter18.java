package Java;

import java.util.Scanner;

public class Chapter18 {
    public static Scanner keyboard = new Scanner(System.in);
    public static void main(String args[]) throws AgeInputException {
        /*int[] arr=new int[100];
        for(int i=0;i<3;i++){
            System.out.print("피제수 입력 : ");
            int num1=keyboard.nextInt();
            System.out.print("제수 입력 : ");
            int num2=keyboard.nextInt();
            if(num2==0){
                System.out.println("제수는 0이 될 수 없습니다.");
                i-=1;
                continue;
            }
            System.out.print("연산결과를 저장할 배열의 인덱스 입력 : ");
            int idx=keyboard.nextInt();
            if(idx<0 || idx>99){
                System.out.println("유효하지 않은 인덱스 값입니다.");
                i-=1;
                continue;
            }
            arr[idx]=num1/num2;
            System.out.println("나눗셈 결과는"+arr[idx]);
            System.out.println("저장된 위치의 인덱스는"+idx);
        }
        System.out.print("두 개의 정수 입력 : ");
        int num1=keyboard.nextInt();
        int num2=keyboard.nextInt();
        try{
            System.out.println("나눗셈 결과의 몫 : "+(num1/num2));
            System.out.println("나눗셈 결과의 나머지 : "+(num1%num2));
        }catch(ArithmeticException e){
            System.out.println("나눗셈 불가능");
            System.out.println(e.getMessage());
        }
        System.out.println("프로그램을 종료합니다.");
    }
        try{
            int[] arr=new int[3];
            arr[-1]=20;
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        try{
            Object obj=new int[10];
            String str=(String)obj;
        }catch(ClassCastException e){
            System.out.println(e.getMessage());
        }
        try{
            int[] arr=new int[-10];
        }catch(NegativeArraySizeException e){
            System.out.println(e.getMessage());
        }
        try{
            String str=null;
            int len=str.length();
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
        int[] arr=new int[100];
        for(int i=0;i<3;i++){
            try{
                System.out.print("피제수 입력 : ");
                int num1=keyboard.nextInt();
                System.out.print("제수 입력 : ");
                int num2=keyboard.nextInt();
                System.out.print("연산결과를 저장할 배열의 인덱스 입력 : ");
                int idx=keyboard.nextInt();
                arr[idx]=num1/num2;
                System.out.println("나눗셈 결과는 "+arr[idx]);
                System.out.println("저장된 위치의 인덱스는 "+idx);
            }catch(ArithmeticException e){
                System.out.println("제수는 0이 될 수 없습니다.");
                i=i-1;
                continue;
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("유효하지 않은 인덱스 값입니다.");
                i-=1;
                continue;
            }
        }
        boolean divOK=divider(4,2);
        if(divOK) System.out.println("연산 성공");
        else System.out.println("연산 실패");
        divOK=divider(4,0);
        if(divOK) System.out.println("연산 성공");
        else System.out.println("연산 실패");
    }
    public static boolean divider(int num1,int num2){
        try{
            int result=num1/num2;
            System.out.println("나눗셈 결과는 "+result);
            return true;
        }catch(ArithmeticException e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            System.out.println("finally 영역 실행");
        }
    }
        System.out.print("나이를 입력하세요 : ");
        int age=readAge();
        System.out.println("당신은 "+age+"세 입니다.");
         */
        try{
            PersonalInfo readInfo = readPersonalInfo();
            readInfo.showPersonalnfo();
        }catch(AgeInputException e){
            e.printStackTrace();
        }catch(NameLengthException e){
            e.showWrongName();
            e.printStackTrace();
        }
    }
    public static PersonalInfo readPersonalInfo() throws AgeInputException,NameLengthException{
        String name=readName();
        int age=readAge();
        PersonalInfo pInfo=new PersonalInfo(name,age);
        return pInfo;
    }
    public static String readName() throws NameLengthException{
        System.out.print("이름 입력 : ");
        String name=keyboard.nextLine();
        if(name.length()<2) throw new NameLengthException(name);
        return name;
    }
    public static int readAge() throws AgeInputException{
        int age=keyboard.nextInt();
        if(age<0){
            AgeInputException excpt=new AgeInputException();
            throw excpt;
        }
        return age;
    }
}

class AgeInputException extends Exception{
    public AgeInputException(){
        super("유효하지 않은 나이가 입력되었습니다.");
    }
}

class NameLengthException extends Exception{
    String wrongName;
    public NameLengthException(String name){
        super("잘못된 이름이 삽입되었습니다.");
        wrongName=name;
    }
    public void showWrongName(){
        System.out.println("잘못 입력된 이름 : "+wrongName);
    }
}

class PersonalInfo{
    String name;
    int age;
    public PersonalInfo(String name,int age){
        this.name=name;
        this.age=age;
    }
    public void showPersonalnfo(){
        System.out.println("이름 : "+name);
        System.out.println("나이 : "+age);
    }
}
