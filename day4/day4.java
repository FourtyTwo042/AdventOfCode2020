import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class day4 {
    public static void main(String[] args) throws IOException {

        System.out.println(PartTwo());
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
    public static int PartTwo() throws IOException{
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
                    result+=validatePassport(str)?1:0;
                else
                    break;
            line="0";
            str="";
            keyCount=0;
            cidPresent=false;
           }
        }while(line!=null);
        reader.close();
        return result;
    }
    public static boolean validatePassport(String passport){
        Matcher matcher=Pattern.compile("(\\w+(?=:))|(?<=:)(\\w+|#\\w+)").matcher(passport);
        String key="", value="";
        boolean flag=true;
        while(matcher.find()){
            key=matcher.group(0);
            matcher.start();
            if(matcher.find())
                value=matcher.group(0);
            switch(key){
                case "byr": int num=Integer.parseInt(value);
                            flag=(num>=1920 && num<=2020)?true:false;
                            break;    
                case "iyr": int iyr=Integer.parseInt(value);
                            flag=(iyr>=2010 && iyr<=2020)?true:false;
                            break;
                case "eyr":int eyr=Integer.parseInt(value);
                            flag=(eyr>=2020 && eyr<=2030)?true:false;
                            break;
                case "hgt": String suffix=value.substring(value.length()-2,value.length()-1);
                            int hgt=Integer.parseInt(value.substring(0,value.length()));
                            flag=suffix=="in"?((hgt>=59&&hgt<=76)?true:false):false;
                            flag=suffix=="cm"?((hgt>=150&&hgt<=193)?true:false):false;
                            break;
                case "hcl":flag=value.charAt(0)=='#'?true:false;
                            break;
                case "ecl": flag= (value=="amb" ||value=="blu" ||value=="brn" ||value=="gry" ||value=="grn" ||value=="hzl"
                ||value=="oth")?true:false;
                break;
                case "pid": try{ Integer.parseInt(value); flag=value.length()==9?true:false;} catch(Exception e){ flag=false;}
                            break;
            }
        }
        return flag;
    }

}
