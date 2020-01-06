package Java;

import java.util.Scanner;

public class Chapter13 {
    public static void main(String args[]){
        /*int fstHighScore = 0; // 1등 점수
        int sndHighScore = 0; // 2등 점수
        Scanner sc = new Scanner(System.in);
        System.out.print("점수 입력 : ");
        int score1=sc.nextInt();
        if(score1>=fstHighScore){
            sndHighScore = fstHighScore;
            fstHighScore = score1;
        }else if(score1<fstHighScore && score1>sndHighScore) sndHighScore=score1;
        System.out.print("점수 입력 : ");
        int score2=sc.nextInt();
        if(score2>=fstHighScore){
            sndHighScore = fstHighScore;
            fstHighScore = score2;
        }else if(score2<fstHighScore && score2>sndHighScore) sndHighScore=score2;
        System.out.print("점수 입력 : ");
        int score3=sc.nextInt();
        if(score3>=fstHighScore){
            sndHighScore = fstHighScore;
            fstHighScore = score3;
        }else if(score3<fstHighScore && score3>sndHighScore) sndHighScore=score3;
        System.out.printf("A 학점은 %d점 이상입니다. \n",sndHighScore);
         */
        int[] arr = new int[3];
        arr[0]=1;
        arr[1]=2;
        arr[2]=3;
        int sum=arr[0]+arr[1]+arr[2];
        System.out.println(sum);

        String[] arr2 = new String[3];
        arr2[0]=new String("Java");
        arr2[1]=new String("Flex");
        arr2[2]=new String("Ruby");
        for(int i=0;i<arr2.length;i++) System.out.println(arr2[i]);

        int[] array = {1,2,3,4,5};
        int[] ref;
        ref=ArrayAndMethods.addAllArray(array,7);
        if(array==ref) System.out.println("동일 배열 참조");
        else System.out.println("다른 배열 참조");
        for(int i=0;i<ref.length;i++) System.out.print(array[i]+" ");
        //System.out.println();
        //System.out.println(ArrayMaxAndMin.max(array));
        System.out.println();
        int[][] arr3 = new int[3][4];
        for(int i=0;i<arr3.length;i++) {
            for (int j = 0; j < arr3[i].length; j++) {
                arr3[i][j] = i + j;
                System.out.print(arr3[i][j]);
            }
            System.out.println();
        }
        /*ArrayMaxAndMin.addTwoDArr(arr3,10);
        for(int i=0;i<arr3.length;i++){
            for(int j=0;j<arr3[i].length;j++){
                System.out.println(arr3[i][j]);
            }
        }
        */
        int[][] arr4 = { {1,2},{2,3},{4,5,6,7,8} };
        ArrayMaxAndMin.moveArray(arr4);

        int[] arr5={1,2,3,4,5};
        sum=0;
        for(int e : arr5) sum +=e;
        System.out.println("배열 요소의 합 : "+sum);

        for(int e : arr5){
            e++;
            System.out.print(e+" ");
        }
        System.out.println("");
        for(int e : arr5) System.out.print(e+" ");
        System.out.println("");
        Number[] nArr=new Number[] {
                new Number(2),
                new Number(4),
                new Number(8)
        };
        for(Number e : nArr) e.num++;
        for(Number e : nArr) System.out.print(e.getNum()+" ");
        System.out.println("");
        for(Number e : nArr){
            e=new Number(5);
            e.num+=2;
            System.out.print(e.getNum()+" ");
        }
        System.out.println("");
        for(Number e :nArr) System.out.print(e.getNum()+" ");
    }
}
class ArrayAndMethods{
    public static int[] addAllArray(int[] ar,int addVal){
        for(int i=0;i<ar.length;i++) ar[i]+=addVal;
        return ar;
    }
}

class ArrayMaxAndMin{
    public static int max(int[] arr){
        int max=arr[0];
        for(int i=0;i<arr.length;i++){
            if(max<arr[i]) max=arr[i];
        }
        return max;
    }
    public static int min(int[] arr){
        int min=arr[0];
        for(int i=0;i<arr.length;i++){
            if(min>arr[i]) min=arr[i];
        }
        return min;
    }
    public static void addTwoDArr(int[][] arr,int add){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j]+=add;
            }
        }
    }
    public static void moveArray(int[][] arr){
        int[][] array = new int[arr.length][];
        int idx=0;

        for(int i=0;i<arr.length;i++){
            if(i==arr.length-1) idx=0;
            else idx++;
            array[idx]=new int[arr[i].length];
            for(int j=0;j<arr[i].length;j++){
                array[idx][j]=arr[i][j];
            }
        }

        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
}

class Number{
    public int num;
    public Number(int num){this.num=num;}
    public int getNum(){return num;}
}
