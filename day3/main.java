import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.math.BigInteger;
class Main{
    public static void main(String[] args) throws IOException{
        BigInteger ans=new BigInteger("1");
        //System.out.println(PartOne());
        int[][] partTwoInput={{1,1},{3,1},{5,1},{7,1},{1,2}};
        for(int i=0;i<5;i++){
            System.out.println("part "+i+" "+PartTwo(partTwoInput[i][0],partTwoInput[i][1]));
            //ans=ans.multiply(BigInteger.valueOf(PartTwo(partTwoInput[i][0],partTwoInput[i][1])));
            //System.out.println(ans);
        }
        System.out.println(ans);
        }

    
    public static int PartOne() throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String line;
        int x=0,result=0;
        while(true){
            line=reader.readLine();
            if(line==null)
                break;
            if(x>30)
                x=x-31;
            if(line.charAt(x)=='#')
                result++;
            x+=3;
        }
        reader.close();
        return result;
    }
    public static int PartTwo(int xAxisStep, int yAxisStep) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String line="0";
        int pos=0, result=0;
        while(true){
            for(int i=1;i<=yAxisStep;i++){
                line=reader.readLine();
            }
            if(pos>30)
                pos=pos-31;
            if(line==null)
                break;
            if(line.charAt(pos)=='#')
                result++;
            pos=pos+xAxisStep;
        }
        reader.close();
        return result;
    }
}
