package Enum;

public class NonSafeInterfaceConst {
    public static void main(String args[]){
        whoAreYou(Person.MAN);
        Person myFriend = Person.WOMAN;
    }
    public static void whoAreYou(Person man){
        switch (man){
            case MAN: System.out.println("남자 손님입니다."); break;
            case WOMAN : System.out.println("여자 손님입니다."); break;
            case BABY : System.out.println("아기 손님입니다."); break;
        }
    }
}

enum Animal{
    DOG,CAT,BEAR;
}

enum Person{
    MAN,WOMAN,BABY;
}