import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Arrays;
class longOne{
    public static void main(String[] args) throws FileNotFoundException {
    
        File input=new File("longInput.txt");
        Scanner reader=new Scanner(input);
        String data;
        int k=0;
        BigInteger[] arr=new BigInteger[100000];
        while(reader.hasNextLine()){
            data= reader.nextLine();
            //arr[k++]=Integer.parseInt(data);
            arr[k++]=new BigInteger(data);
        }
        reader.close();
        System.out.println(PartOne(arr));
        //System.out.println(PartTwo(arr));
    }
    public static BigInteger PartOne(BigInteger[] arr){
        BigInteger result=new BigInteger("0"), subt,num=new BigInteger("99920044");
        HashSet<BigInteger> hshSet= new HashSet<>();
        for (int i=0; i<arr.length;i++){
            subt=num.subtract(arr[i]);
            if(hshSet.contains(subt)){
                result=arr[i].multiply(subt);
                break;
            }
            hshSet.add(arr[i]);    
        }   
        return result;
    }
    public static BigInteger PartTwo(BigInteger[] arr){
        int leftPointer=0, rightPointer=0, comparision=0;
        BigInteger result=new BigInteger("0"), first, num=new BigInteger("99920044"), sum,target;
        Arrays.sort(arr,(left, right)->{
            if(left.toString().length()!=right.toString().length())
                return left.toString().length()-right.toString().length();
            return left.compareTo(right);
        });
        for(int i=0;i<arr.length;i++){
            first=arr[i];
            leftPointer=i+1;
            rightPointer=99999;
            while(leftPointer < rightPointer){
                sum=arr[leftPointer].add(arr[rightPointer]);
                target=num.subtract(first);
                comparision=sum.compareTo(target);
                if(comparision==0){
                    result=first.multiply(arr[leftPointer]).multiply(arr[rightPointer]);//result=first*arr[leftPointer]*arr[rightPointer];
                    break;
                }
                if(sum.compareTo(target)==-1){
                    leftPointer++;
                }
                if(sum.compareTo(target)==1){
                    rightPointer--;
                }
            }
        }
        return result;
    }
}
