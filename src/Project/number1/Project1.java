package Project.number1;

public class Project1 {
    public static void main(String args[]) {
        PhoneInfo phoneInfo1 = new PhoneInfo("최성훈", "01024677304", "981029");
        PhoneInfo phoneInfo2 = new PhoneInfo("최성훈", "01024677304");
        phoneInfo1.showPhoneInfo();
        phoneInfo2.showPhoneInfo();
    }
}

class PhoneInfo{
    String name;
    String phoneNumber;
    String birthday;
    public PhoneInfo(String name,String phoneNumber,String birthday){
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.birthday=birthday;
    }
    public PhoneInfo(String name,String phoneNumber){
        this(name,phoneNumber,null);
    }
    public void showPhoneInfo(){
        System.out.println("이름은 : "+name);
        System.out.println("폰번호는 : "+phoneNumber);
        if(birthday!=null) System.out.println("생년월일은 "+birthday);
    }
}
