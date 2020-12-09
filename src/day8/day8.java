import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;

class day8{
    public static void main(String[] args)throws IOException{
        System.out.println(PartOne());
        System.out.println(PartTwo());
    }
    public static int PartOne()throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        String line;
        int p=0, acc=0, i=0;
        String[][] instructions= new String[654][3];
        HashSet<Integer> visitedIndex= new HashSet<>();
        while((line=reader.readLine())!=null){
            String[] splt=line.split(" ");
            instructions[p][0]=splt[0];
            instructions[p][1]=splt[1];
            instructions[p][2]="0";
            p++;
        }
       while(true) {
           String inst=instructions[i][0];
           String val=instructions[i][1];
           if(visitedIndex.contains(i)){
               return acc;
           }
           if (inst.equals("acc")) {
               visitedIndex.add(i);
               acc += Integer.parseInt(val);
               i++;
               continue;
           }
           if (inst.equals("jmp")) {
               visitedIndex.add(i);
               i += Integer.parseInt(val);
               continue;
           }
           if (inst.equals("nop")) {
               i++;
               continue;
           }
       }
    }
    public static boolean execute(String[][] instr){
        HashSet<Integer> visitedIndex= new HashSet<>();
        int i=0, acc=0;
        while(i<instr.length) {
            String inst=instr[i][0];
            String val=instr[i][1];
            if(visitedIndex.contains(i)){
                return false;
            }
            if (inst.equals("acc")) {
                visitedIndex.add(i);
                acc += Integer.parseInt(val);
                i++;
                continue;
            }
            if (inst.equals("jmp")) {
                visitedIndex.add(i);
                i += Integer.parseInt(val);
                continue;
            }
            if (inst.equals("nop")) {
                i++;
                continue;
            }
        }
        return true;
    }
    public static int PartTwo()throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        String line;
        int p=0, acc=0, i=0;
        String[][] instructions= new String[654][3];
        HashSet<Integer> visitedIndex= new HashSet<>();
        while((line=reader.readLine())!=null){
            String[] splt=line.split(" ");
            instructions[p][0]=splt[0];
            instructions[p][1]=splt[1];
            instructions[p][2]="0";
            p++;
        }
        while(true) {
            String inst=instructions[i][0];
            String val=instructions[i][1];


        }

    }
}
