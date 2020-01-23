package Java;

import java.io.*;

public class Chapter24 {
    public static void main(String args[]) throws IOException,ClassNotFoundException {
        /*InputStream in=new FileInputStream("org.bin");
        OutputStream out=new FileOutputStream("cpy.bin");
        int copyByte=0;
        int readLen;
        byte buf[]=new byte[1024];
        while(true){
            readLen=in.read(buf);
            if(readLen==-1) break;
            out.write(buf,0,readLen);
            copyByte+=readLen;
        }
        in.close();
        out.close();
        System.out.println("복사된 바이트 크기 : "+copyByte);

        OutputStream out=new FileOutputStream("data.bin");
        DataOutputStream filterOut=new DataOutputStream(out);
        filterOut.writeInt(275);
        filterOut.writeDouble(45.79);
        filterOut.close();
        InputStream in =new FileInputStream("data.bin");
        DataInputStream filterIn=new DataInputStream(in);
        int num1=filterIn.readInt();
        double num2=filterIn.readDouble();
        filterIn.close();
        System.out.println(num1);
        System.out.println(num2);

        InputStream in = new FileInputStream("org.bin");
        OutputStream out = new FileOutputStream("org.bin");
        BufferedInputStream bin = new BufferedInputStream(in);
        BufferedOutputStream bout = new BufferedOutputStream(out);
        int copyByte=0;
        int bData;
        while(true){
            bData=bin.read();
            if(bData==-1) break;
            bout.write(bData);
            copyByte++;
        }
        bin.close();
        bout.close();
        System.out.println("복사된 바이트 크기 "+copyByte);
        OutputStream out=new FileOutputStream("data.bin");
        BufferedOutputStream bufFilterOut=new BufferedOutputStream(out);
        DataOutputStream dataFilterOut=new DataOutputStream(bufFilterOut);
        dataFilterOut.writeDouble(275);
        dataFilterOut.writeDouble(45.79);
        dataFilterOut.close();
        InputStream in=new FileInputStream("data.bin");
        BufferedInputStream bufFilterIn=new BufferedInputStream(in);
        DataInputStream dataFilterIn=new DataInputStream(bufFilterIn);
        int num1=dataFilterIn.readInt();
        double num2=dataFilterIn.readDouble();
        dataFilterIn.close();
        System.out.println(num1);
        System.out.println(num2);
        OutputStream out1=new FileOutputStream("data1.bin");
        DataOutputStream dataOut=new DataOutputStream(out1);
        performanceTest(dataOut);
        dataOut.close();

        OutputStream out2=new FileOutputStream("data2.bin");
        BufferedOutputStream bufFilterOut = new BufferedOutputStream(out2,1024*10);
        DataOutputStream dataBufOut=new DataOutputStream(bufFilterOut);
        performanceTest(dataBufOut);
        dataBufOut.close();
        MyInfo mInfo=new MyInfo("저는 자바 프로그래머 입니다.");
        OutputStream out=new FileOutputStream("C:\\Users\\seong\\Desktop\\println.txt");
        PrintStream prt = new PrintStream(out);
        prt.println("제 소개를 하겠습니다.");
        prt.println(mInfo);
        prt.printf("나이 %d, 몸무게 %dkg입니다.",24,72);
        prt.close();
         */
        //char ch1='A';
        //char ch2='B';
        //Writer out=new FileWriter("C:\\\\Users\\\\seong\\\\Desktop\\\\println.txt");
        //out.write(ch1);
        // out.write(ch2);
        /*char[] cbuf=new char[10];
        int readCnt;
        Reader in = new FileReader("C:\\\\Users\\\\seong\\\\Desktop\\\\println.txt");
        readCnt=in.read(cbuf,0,cbuf.length);
        for(int i=0;i<readCnt;i++) System.out.println(cbuf[i]);
        in.close();*/
/*        BufferedWriter out=new BufferedWriter(new FileWriter("String.txt"));
        out.write("박지성 - 메시 멈추게 하는데 집중하겠다.");
        out.newLine();
        out.write("올 시즌은 나에게 있어 최고의 시즌이다.");
        out.newLine();
        out.write("팀이 승리하는 것을 돕기 위해 최선을 다하겠다.");
        out.newLine();
        out.write("환상적인 결승전이 될 것이다.");
        out.newLine();
        out.newLine();
        out.write("기사 제보 및 보도자료");
        out.newLine();
        out.write("press@goodnews.co.kr");
        out.close();
        System.out.println("기사 입력 완료");*/
/*        BufferedReader in=new BufferedReader(new FileReader("String.txt"));
        String str;
        while(true){
            str=in.readLine();
            if(str==null) break;
            System.out.println(str);
        }
        in.close();*/
/*        PrintWriter out=new PrintWriter(new FileWriter("printf.txt"));
        BufferedWriter bOut=new BufferedWriter(out);
        out.printf("제 나이는 %d살 입니다.",24);
        out.println("");
        out.println("저는 자바가 좋습니다.");
        out.print("특히 I/O 부분에서 많은 매력을 느낍니다.");
        out.close();
        BufferedReader in = new BufferedReader(new FileReader("printf.txt"));
        while(true){
            String str=in.readLine();
            if(str==null) break;
            System.out.println(str);
        }
        in.close();*/
/*        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Object.ser"));
        out.writeObject(new CircleClasses(1,1,2.4));
        out.writeObject(new CircleClasses(2,2,4.8));
        out.writeObject("String implements Serializable");
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Object.ser"));
        CircleClasses cl1=(CircleClasses)in.readObject();
        CircleClasses cl2=(CircleClasses)in.readObject();
        String message=(String)in.readObject();
        in.close();
        cl1.showCircleInfo();
        cl2.showCircleInfo();
        System.out.println(message);*/
/*        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("Human.ser"));
        HumanInfo info = new HumanInfo("John","baby",3,42);
        info.showCircleInfo();
        out.writeObject(info);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Human.ser"));
        HumanInfo recovInfo = (HumanInfo)in.readObject();
        in.close();
        recovInfo.showCircleInfo();*/
/*        RandomAccessFile raf=new RandomAccessFile("data.bin","rw");
        System.out.println("Write................");
        System.out.printf("현재 입출력 위치 : %d 바이트 \n",raf.getFilePointer());
        raf.writeInt(200);
        raf.writeInt(500);
        System.out.printf("현재 입출력 위치 : %d 바이트 \n",raf.getFilePointer());
        raf.writeDouble(48.65);
        raf.writeDouble(52.24);
        System.out.printf("현재 입출력 위치 : %d 바이트 \n",raf.getFilePointer());
        System.out.println("Read................");
        raf.seek(raf.length()-8);
        System.out.println(raf.readDouble());*/
/*        System.out.printf("현재 입출력 위치 : %d 바이트 \n",raf.getFilePointer());
        System.out.println(raf.readInt());
        System.out.println(raf.readInt());
        System.out.printf("현재 입출력 위치 : %d 바이트 \n",raf.getFilePointer());
        System.out.println(raf.readDouble());
        System.out.println(raf.readDouble());
        System.out.printf("현재 입출력 위치 : %d 바이트 \n",raf.getFilePointer());*/
        //raf.close();
/*        File myFile=new File("AAA");
        System.out.println(myFile.getAbsolutePath());
        File reDir=new File("AAA"+File.separator+"BBB");
        System.out.println(reDir.getAbsolutePath());
        reDir.mkdir();
        File reFile=new File(reDir,"my.bin");
        myFile.renameTo(reFile);
        if(reFile.exists()==true) System.out.println("파일 이동에 성공하였습니다.");
        else System.out.println("파일 이동에 실패하였습니다.");*/
        String wokringDir=System.getProperty("user.dir");
        System.out.println(wokringDir);
        File myDir=new File(wokringDir);
        File[] list=myDir.listFiles();
        for(int i=0;i<list.length;i++){
            System.out.print(list[i].getName());
            if(list[i].isDirectory()) System.out.println("\t \t DIR");
            else System.out.println("\t \t FILE");
        }
        String wokringDir2=System.getProperty("user.dir");
        File myDir2=new File(wokringDir2);
        myDir2= new File(myDir2.getParent());
        System.out.println(myDir2.getAbsolutePath());
        File[] list2=myDir2.listFiles();
        for(int i=0;i<list2.length;i++){
            System.out.print(list2[i].getName());
            if(list2[i].isDirectory()) System.out.println("\t \t DIR");
            else System.out.println("\t \t FILE");
        }

    }
    public static void performanceTest(DataOutputStream dataOut) throws IOException{
        long startTime=System.currentTimeMillis();
        for(int i=0;i<10000;i++)
            for(int j=0;j<10000;j++)
                dataOut.writeDouble(12.345);
        dataOut.flush();
        long endTime=System.currentTimeMillis();
        System.out.println("경과시간 : "+(endTime-startTime));
    }
}

class MyInfo{
    String info;
    public MyInfo(String info){this.info=info;}
    public String toString(){return info;}
}

class Points implements Serializable{
    int x,y;
    public Points(int x,int y){
        this.x=x;
        this.y=y;
    }
}

class CircleClasses implements Serializable{
    Points p;
    double rad;
    public CircleClasses(int x,int y,double r){
        p=new Points(x,y);
        rad=r;
    }
    public void showCircleInfo(){
        System.out.printf("[%d,%d] \n",p.x,p.y);
        System.out.printf("rad : "+rad);
    }
}

class HumanInfo implements Serializable{
    String name;
    transient String secretInfo;
    int age;
    transient int secretNum;
    public HumanInfo(String name,String sInfo,int age,int sNum){
        this.name=name;
        secretInfo=sInfo;
        this.age=age;
        secretNum=sNum;
    }
    public void showCircleInfo(){
        System.out.println("name : "+name);
        System.out.println("secret info : "+secretInfo);
        System.out.println("age : "+age);
        System.out.println("secret num : "+secretNum);
        System.out.println();
    }
}