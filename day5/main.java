import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
class Main{
    public static void main(String[] args) throws IOException{
        PartOne();
        PartTwo();
    }

    public static int PartOne() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line="0", ID="";
        int intID=0, highest=0; 
        while((line=reader.readLine())!=null){
            ID=line.replace('F', '0').replace('B','1').replace('R', '1').replace('L','0');
            intID=Integer.parseInt(ID);
            if(intID>highest)
                highest=intID;
        }
        return Integer.parseInt(Integer.toString(highest),2);
    
    }
    public static long PartTwo() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line="0", ID="";
        int intID=0,k=0;
        int[] arr=new int[945];
        while((line=reader.readLine())!=null){
            ID=line.replace('F', '0').replace('B','1').replace('R', '1').replace('L','0');
            intID=Integer.parseInt(ID,2);
            arr[k++]=intID;
        }
        k=0;
        Arrays.sort(arr);
       for(int i=0;i<arr.length-1;i++){
           if(arr[i]-arr[i+1]!=-1)
                return arr[i]+1;
       }
       return 0;
    }
}