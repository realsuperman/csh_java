package Java;

import java.util.*;

public class Chapter22 {
    public static void main(String args[]){
        List<Integer> list=new ArrayList<>();
        list.add(new Integer(11));
        list.add(new Integer(22));
        list.add(new Integer(33));
        System.out.println("1차 참조");
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        list.remove(0);
        System.out.println("2차 참조");
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        ArrayList<Integer> list2=new ArrayList<>();
        list2.ensureCapacity(500);
        list2.ensureCapacity(list2.size()*2);

        List<Integer> list3=new LinkedList<>();
        list3.add(new Integer(11));
        list3.add(new Integer(22));
        list3.add(new Integer(33));
        System.out.println("1차 참조");
        for(int i=0;i<list3.size();i++){
            System.out.println(list3.get(i));
        }
        list3.remove(0);
        System.out.println("2차 참조");
        for(int i=0;i<list3.size();i++){
            System.out.println(list3.get(i));
        }

        Csh<String> boxHead=new Csh<>();
        boxHead.store("First String");
        boxHead.next=new Csh<>();
        boxHead.next.store("Second String");
        boxHead.next.next=new Csh<>();
        boxHead.next.next.store("Third String");
        Csh<String> tempRef;
        tempRef=boxHead.next;
        System.out.println(tempRef.pullOut());
        tempRef=boxHead.next;
        tempRef=tempRef.next;
        System.out.println(tempRef.pullOut());

        Set<String> csh = new HashSet<>();
        csh.add("Frist");
        csh.add("Second");
        csh.add("Third");
        csh.add("Fourth");
        Iterator<String> itr=csh.iterator();
        System.out.println("반복자를 이용한 1차 출력과 \"Third\" 삭제");
        while(itr.hasNext()){
            String curStr=itr.next();
            System.out.println(curStr);
            if(curStr.compareTo("Third")==0) itr.remove();
        }
        System.out.println("\n\"Third\" 삭제 후 반복자를 이용한 2차 출력 ");
        itr=csh.iterator();
        while(itr.hasNext()) System.out.println(itr.next());

        LinkedList<Integer> test = new LinkedList<>();
        test.add(10); // Auto Boxing
        test.add(20); // Auto Boxing
        test.add(30); // Auto Boxing
        Iterator<Integer> test2 = test.iterator();
        while(itr.hasNext()){
            int num = test2.next(); // Auto Unboxing
            System.out.println(num);
        }

        Set<String> hSet=new HashSet<>();
        hSet.add("First");
        hSet.add("Second");
        hSet.add("Third");
        hSet.add("First");
        System.out.println("저장된 데이터 수 : "+hSet.size());
        Iterator<String> itr2=hSet.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        Set<ClassNumber> hSet2=new HashSet<>();
        hSet2.add(new ClassNumber(10));
        hSet2.add(new ClassNumber(20));
        hSet2.add(new ClassNumber(20));
        System.out.println("저장된 데이터 수 : "+hSet2.size());
        Iterator<ClassNumber> itr3=hSet2.iterator();
        while(itr3.hasNext()){
            System.out.println(itr3.next());
        }

        Set<Person_csh> hSet4=new HashSet<>();
        hSet4.add(new Person_csh("이진호",10));
        hSet4.add(new Person_csh("이진호",20));
        hSet4.add(new Person_csh("김명호",20));
        hSet4.add(new Person_csh("김명호",15));
        hSet4.add(new Person_csh("이진호",20));
        hSet4.add(new Person_csh("김명호",20));
        System.out.println("저장된 데이터 수 : "+hSet4.size());
        Iterator<Person_csh> itr4=hSet4.iterator();
        while(itr4.hasNext()) System.out.println(itr4.next());

        Set<Integer> sTree = new TreeSet<>();
        sTree.add(1);
        sTree.add(2);
        sTree.add(4);
        sTree.add(3);
        sTree.add(2);
        System.out.println("저장된 데이터 수 : "+sTree.size());
        Iterator<Integer> itr5=sTree.iterator();
        while(itr5.hasNext()) System.out.println(itr5.next());

        TreeSet<Person_csh> sTree2=new TreeSet<>();
        sTree2.add(new Person_csh("Lee",24));
        sTree2.add(new Person_csh("Hone",29));
        sTree2.add(new Person_csh("Choi",21));
        Iterator<Person_csh> itr6=sTree2.iterator();
        while(itr6.hasNext()) itr6.next().showData();

        TreeSet<MyString> tSet=new TreeSet<>();
        tSet.add(new MyString("Orange"));
        tSet.add(new MyString("Apple"));
        tSet.add(new MyString("Dog"));
        tSet.add(new MyString("Individual"));
        Iterator<MyString> itr7=tSet.iterator();
        while(itr7.hasNext()) System.out.println(itr7.next());

        TreeSet<String> tSet2=new TreeSet<String>(new StrLenComparator());
        tSet2.add("Orange");
        tSet2.add("Apple");
        tSet2.add("Dog");
        tSet2.add("Individual");
        Iterator<String> itr8=tSet2.descendingIterator();
        while(itr8.hasNext()) System.out.println(itr8.next());

        Map<Integer,String> hMap=new HashMap<>();
        hMap.put(3,"나침반");
        hMap.put(5,"윤오번");
        hMap.put(8,"박팔번");
        System.out.println("6학년 3반 8번 학생 : "+hMap.get(8));
        System.out.println("6학년 3반 5번 학생 : "+hMap.get(5));
        System.out.println("6학년 3반 3번 학생 : "+hMap.get(3));
        hMap.remove(5);
        System.out.println("6학년 3반 5번 학생 : "+hMap.get(5));

        TreeMap<Integer,String> tMap=new TreeMap<>();
        tMap.put(1,"data1");
        tMap.put(3,"data3");
        tMap.put(5,"data5");
        tMap.put(2,"data2");
        tMap.put(4,"data4");
        NavigableSet<Integer> navi=tMap.navigableKeySet();
        System.out.println("오름차순 출력");
        Iterator<Integer> itr9=navi.iterator();
        while(itr9.hasNext()) System.out.println(tMap.get(itr9.next()));
        System.out.println("내림차순 출력");
        itr9=navi.descendingIterator();
        while(itr9.hasNext()) System.out.println(tMap.get(itr9.next()));
    }
}

class Csh<T>{
    public Csh<T> next; // 다른 Csh<T>의 인스턴스 참조를 위한 변수
    T item;
    public void store(T item){this.item=item;}
    public T pullOut(){return item;}
}

class ClassNumber{
    int num;
    public ClassNumber(int n){
        num=n;
    }
    public String toString(){
        return String.valueOf(num);
    }
    public int hashCode(){
        return num%3;
    }
    public boolean equals(Object obj){
        ClassNumber comp=(ClassNumber)obj;
        if(comp.num==num) return true;
        else return false;
    }
}

class Person_csh implements Comparable<Person_csh>{
    String name;
    int age;
    public Person_csh(String name,int age){
        this.name=name;
        this.age=age;
    }
    public int compareTo(Person_csh p){
        if(age>p.age) return 1;
        else if(age<p.age) return -1;
        else return 0;
    }
    public void showData(){
        System.out.printf("%s %d\n",name,age);
    }
    public String toString(){
        return name+"("+age+"세)";
    }
    public boolean equals(Object obj){
        Person_csh csh = (Person_csh)obj;
        String name=csh.name;
        if(name.equals(this.name) && this.age==csh.age){
            return true;
        }
        return false;
    }
    public int hashCode(){
        return age+name.hashCode();
    }
}

class MyString implements Comparable<MyString>{
    String str;
    public MyString(String str){this.str=str;}
    public int getLength(){return str.length();}
    public int compareTo(MyString str){
        if(getLength()>str.getLength()) return 1;
        else if(getLength()<str.getLength()) return -1;
        else return 0;
    }
    public String toString(){return str;}
}

class StrLenComparator implements Comparator<String>{
    public int compare(String str1,String str2){
        if(str1.length()>str2.length()) return 1;
        else if(str2.length()<str2.length()) return -1;
        else return 0;
    }
}