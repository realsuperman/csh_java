package Java;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Chapter23 {
    public static void main(String args[]){
        /*ShowThread st1=new ShowThread("멋진 쓰레드");
        ShowThread st2=new ShowThread("예쁜 쓰레드");
        st1.start();
        st2.start();

        AdderThread at1=new AdderThread(1,50);
        AdderThread at2=new AdderThread(51,100);
        Thread tr1=new Thread(at1);
        Thread tr2=new Thread(at2);
        tr1.start();
        tr2.start();
        try{
            tr1.join();
            tr2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("1~100까지의 합 : "+(at1.getNum()+at2.getNum()));
        SumThread sum1 = new SumThread(1,50);
        SumThread sum2 = new SumThread(51,100);
        sum1.start();
        sum2.start();
        try{
            sum1.join();
            sum2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("1~100까지의 합 : "+(sum1.getNum()+sum2.getNum()));

        MessageSendingThread t1= new MessageSendingThread("First",Thread.MAX_PRIORITY);
        MessageSendingThread t2= new MessageSendingThread("Second",Thread.NORM_PRIORITY);
        MessageSendingThread t3= new MessageSendingThread("Third",Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        t3.start();

        Sum s = new Sum();
        AdderThread at1=new AdderThread(s,1,50);
        AdderThread at2=new AdderThread(s,51,100);
        at1.start();
        at2.start();
        try{
            at1.join();
            at2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("1~100까지의 합 : "+(s.getNum()));

        Increment inc=new Increment();
        IncThread it1=new IncThread(inc);
        IncThread it2=new IncThread(inc);
        IncThread it3=new IncThread(inc);
        it1.start();
        it2.start();
        it3.start();
        try{
            it1.join();
            it2.join();
            it3.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(inc.getNum());

        Calculator cal=new Calculator();
        AddThreadClass at=new AddThreadClass(cal);
        MinThread mt=new MinThread(cal);
        at.start();
        mt.start();
        try{
            at.join();
            mt.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        cal.showOpCnt();

        IHaveTwoNum numInst=new IHaveTwoNum();
        AccessThread at1=new AccessThread(numInst);
        AccessThread at2=new AccessThread(numInst);
        at1.start();
        at2.start();
        try{
            at1.join();
            at2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        numInst.showAllNums();

        NewsPaper paper=new NewsPaper();
        NewsReader reader1=new NewsReader(paper);
        NewsReader reader2=new NewsReader(paper);
        NewsWriter writer=new NewsWriter(paper);
        try{
            reader1.start();
            reader2.start();
            Thread.sleep(1000);
            writer.start();
            reader1.join();
            reader2.join();
            writer.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        int num1,num2,num3,num4,num5;
        Scanner sc = new Scanner(System.in);
        num1=sc.nextInt();
        num2=sc.nextInt();
        num3=sc.nextInt();
        num4=sc.nextInt();
        num5=sc.nextInt();
        ProblemThread p1=new ProblemThread();
        p1.start();
        p1.sum(num1,num2,num3,num4,num5);


        IHaveTwoNum numInst=new IHaveTwoNum();
        AccessThread at1=new AccessThread(numInst);
        AccessThread at2=new AccessThread(numInst);
        at1.start();
        at2.start();
        try{
            at1.join();
            at2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        numInst.showAllNums();
         */
        StringComm strComm=new StringComm();
        StringReader sr = new StringReader(strComm);
        StringWriter sw=new StringWriter(strComm);
        System.out.println("입출력 쓰레드의 실행...");
        sr.start();
        sw.start();
    }
}

class ShowThread extends Thread{
    String threadName;
    public ShowThread(String name){ threadName=name; }
    public void run(){
        for(int i=0;i<100;i++){
            System.out.println("안녕하세요. "+threadName+"입니다.");
            try{
                sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class Sum{
    int num;
    public Sum(){num=0;}
    public void addNum(int n){num+=n;}
    public int getNum(){return num;}
}

class AdderThread extends Thread{
    Sum sumInst;
    int start,end;
    public AdderThread(Sum sum,int s,int e){
        sumInst=sum;
        start=s;
        end=e;
    }
    public void run(){
        for(int i=start;i<=end;i++) sumInst.addNum(i);
    }
}

class SumThread extends Thread{
    int num,start,end;
    public SumThread(int s,int e){
        start=s;
        end=e;
        num=0;
    }
    public void addNum(int n){num+=n;}
    public int getNum(){return num;}
    public void run(){
        for(int i=start;i<=end;i++) addNum(i);
    }
}

class MessageSendingThread extends Thread{
    String message;
    public MessageSendingThread(String str,int prio){
        message=str;
        setPriority(prio);
    }
    public void run(){
        for(int i=0;i<1000000;i++) System.out.println(message+"("+getPriority()+")");
        try{
            sleep(1);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Increment{
    int num=0;
    public synchronized void increment(){num++;}
    public int getNum(){return num;}
}

class IncThread extends Thread{
    Increment inc;
    public IncThread(Increment inc){ this.inc=inc;}
    public void run(){
        for(int i=0;i<10000;i++)
            for(int j=0;j<10000;j++)
                inc.increment();
    }
}

class Calculator{
    int opCnt=0;
    public int add(int n1,int n2){
        opCnt++;
        return n1+n2;
    }
    public int min(int n1,int n2){
        opCnt++;
        return n1-n2;
    }
    public void showOpCnt(){
        System.out.println("총 연산 횟수 : "+opCnt);
    }
}

class AddThreadClass extends Thread{
    Calculator cal;
    public AddThreadClass(Calculator cal){this.cal=cal;}
    public void run(){
        System.out.println("1+2="+cal.add(1,2));
        System.out.println("2+4="+cal.add(2,4));
    }
}

class MinThread extends Thread{
    Calculator cal;
    public MinThread(Calculator cal){this.cal=cal;}
    public void run(){
        System.out.println("2-1="+cal.min(2,1));
        System.out.println("4-2="+cal.min(4,2));
    }
}

class IHaveTwoNum{
    int num1=0; // 동기화가 필요한 변수 1
    int num2=0; // 동기화가 필요한 변수 2
    public void addOneNum1(){
        key1.lock();
        try{
            num1+=1;
        }finally {
            key1.unlock();
        }
    }
    public void addTwoNum1(){
        key1.lock();
        try{
            num1+=2;
        }finally {
            key1.unlock();
        }
    }
    public void addOneNum2(){
        key2.lock();
        try{
            num2+=1;
        }finally {
            key2.unlock();
        }
    }
    public void addTwoNum2(){
        key2.lock();
        try{
            num2+=2;
        }finally {
            key2.unlock();
        }
    }
    public void showAllNums(){
        System.out.println("num1 : "+num1);
        System.out.println("num2 : "+num2);
    }
    private final ReentrantLock key1=new ReentrantLock();
    private final ReentrantLock key2=new ReentrantLock();
}

class AccessThread extends Thread{
    IHaveTwoNum twoNumInst;
    public AccessThread(IHaveTwoNum inst){
        twoNumInst=inst;
    }
    public void run(){
        twoNumInst.addOneNum1();
        twoNumInst.addTwoNum1();
        twoNumInst.addOneNum2();
        twoNumInst.addTwoNum2();
    }
}

class NewsPaper{
    String todayNews;
    boolean isTodayNews=false;
    public void setTodayNew(String news){
        todayNews=news;
        isTodayNews=true;
        synchronized (this){
            notifyAll();
        }
    }
    public String getTodayNews(){
        if(isTodayNews==false){
            try{
                synchronized(this){
                    wait();
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        return todayNews;
    }
}

class NewsWriter extends Thread{
    NewsPaper paper;
    public NewsWriter(NewsPaper paper){
        this.paper=paper;
    }
    public void run(){
        paper.setTodayNew("자바의 열기가 뜨겁습니다.");
    }
}

class NewsReader extends Thread{
    NewsPaper paper;
    public NewsReader(NewsPaper paper){
        this.paper=paper;
    }
    public void run(){
        System.out.println("오늘의 뉴스 : "+paper.getTodayNews());
    }
}

class ProblemThread extends Thread{
    int num1,num2,num3,num4,num5;
    boolean isTrue=false;
    public void sum(int n1,int n2,int n3,int n4,int n5){
        synchronized(this){
            notifyAll();
        }
        num1=n1;
        num2=n2;
        num3=n3;
        num4=n4;
        num5=n5;
        isTrue=true;
    }
    public void run(){
        if(isTrue==false){
            synchronized(this){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("정수 다섯개의 합은 : "+(num1+num2+num3+num4+num5));
    }
}

class StringComm{
    String newString;
    boolean isNewString=false;
    private final ReentrantLock entLock=new ReentrantLock();
    private final Condition readCond=entLock.newCondition();
    private final Condition writeCond=entLock.newCondition();
    public void setNewString(String news){
        entLock.lock();
        try{
            if(isNewString==true) writeCond.await();
            newString=news;
            isNewString=true;
            readCond.signal();
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            entLock.unlock();
        }
    }
    public String getNewString(){
        String retStr=null;
        entLock.lock();
        try{
            if(isNewString==false) readCond.await();
            retStr=newString;
            isNewString=false;
            writeCond.signal();
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            entLock.unlock();
        }
        return retStr;
    }
}

class StringReader extends Thread{
    StringComm comm;
    public StringReader(StringComm comm){
        this.comm=comm;
    }
    public void run(){
        Scanner sc=new Scanner(System.in);
        String readStr;
        for(int i=0;i<5;i++){
            readStr=sc.nextLine();
            comm.setNewString(readStr);
        }
    }
}

class StringWriter extends Thread{
    StringComm comm;
    public StringWriter(StringComm comm){
        this.comm=comm;
    }
    public void run(){
        for(int i=0;i<5;i++) System.out.println("read String : "+comm.getNewString());
    }
}