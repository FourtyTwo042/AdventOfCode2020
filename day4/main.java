import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws IOException {
        PartOne();
    }
    public static int PartOne()throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line="0", str="";
        Matcher matcher;
        boolean cidPresent=false;
        int keyCount=0,result=0;
        do{
            if(!line.isEmpty()){
                line=reader.readLine();
                str+=" "+line;
            }
           else{
               matcher=Pattern.compile("(\\w+)(?=:)").matcher(str);
               while(matcher.find()){
                   keyCount++;
                   matcher.start();
               }
               cidPresent=Pattern.compile("(cid)").matcher(str).find();
               if(keyCount-(cidPresent?1:0)==7)
                    result++;
            line="0";
            str="";
            keyCount=0;
            cidPresent=false;
           }
        }while(line!=null);
        reader.close();
        return result;
    }
}
