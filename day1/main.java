import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Arrays;
class Main{
    public static void main(String[] args) throws FileNotFoundException{
    
        File input=new File("input.txt");
        Scanner reader=new Scanner(input);
        String data;
        int k=0;
        int[] arr=new int[200];
        while(reader.hasNextLine()){
            data= reader.nextLine();
            arr[k++]=Integer.parseInt(data);
        }
        reader.close();
        System.out.println(PartOne(arr));
        System.out.println(PartTwo(arr));
    }
    public static int PartOne(int[] arr){
        int result=0;
        HashSet<Integer> hshSet= new HashSet<>();
        for (int i=0; i<arr.length;i++){
            if(hshSet.contains(2020-arr[i]))
                System.out.println((arr[i]*(2020-arr[i])));
            hshSet.add(arr[i]);    
        }   
        return result;
    }
    public static int PartTwo(int[] arr){
        int first=0, leftPointer=0, rightPointer=0, sum=0, target=0,result=0;
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            first=arr[i];
            leftPointer=i+1;
            rightPointer=199;
            while(leftPointer < rightPointer){
                sum=arr[leftPointer]+arr[rightPointer];
                target=2020-first;
                if(sum==target){
                    result=first*arr[leftPointer]*arr[rightPointer];
                    break;
                }
                if(sum<target){
                    leftPointer++;
                }
                if(sum > target){
                    rightPointer--;
                }
            }
        }
        return result;
    }
}
