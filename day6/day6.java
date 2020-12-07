import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
class day6 {
    public static void main(String[] args) throws IOException{
        System.out.println(PartOne());
        System.out.println(PartTwo());
    }
    public static int PartOne()throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder str= new StringBuilder();
        int sum=0;
        Set<String> set;
        while((line=reader.readLine())!=null){
            if(!line.isEmpty()){
                str.append(line);
            }
            else{
                set = new HashSet<>(Arrays.asList(str.toString().split("|\n")));
                sum+=set.size();
                set.clear();
                str.setLength(0);
            }
        }
        return sum;
    }
    public static int PartTwo()throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int sum=0;
        boolean previousWasBlank=true;
        Set<String> intersection = new HashSet<>(),temporarySet=new HashSet<>();

        return sum;
    }
}