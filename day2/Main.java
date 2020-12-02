import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Main {
    public static void main(String[] args) throws FileNotFoundException{
    
        File input=new File("input.txt");
        Scanner reader=new Scanner(input);
        String data;
        int k=0;
        String[] arr=new String[1000];
        while(reader.hasNextLine()){
            data= reader.nextLine();
            arr[k++]=data;
        }
        reader.close();
        PartOne(arr);
        PartTwo(arr);
    }

    public static int PartOne(String[] arr) {
        String passwordData;
        int low=0, high=0,result=0,letterCount=0;
        Pattern letter=Pattern.compile(""),letterPattern=Pattern.compile("[a-z]{1}(?=:)");
        Pattern digitPattern=Pattern.compile("(\\d+)");
        Pattern passPattern=Pattern.compile("[a-z]{2,}");
        String passW;
        Matcher matcher;

        for (int i = 0; i < arr.length; i++) {
            passwordData=arr[i];
            letterCount=0;
            matcher=letterPattern.matcher(passwordData); //single letter 
            if(matcher.find()){
                letter=Pattern.compile(matcher.group(0));
            }
            matcher=digitPattern.matcher(passwordData); // range
            if(matcher.find()){
                low=Integer.parseInt(matcher.group(1));
                matcher.start();
                if(matcher.find()){
                    high=Integer.parseInt(matcher.group(1));
                }
            }
            matcher=passPattern.matcher(passwordData);
            if(matcher.find()){
                passW=matcher.group(0);
                matcher=letter.matcher(passW);
                while(matcher.find()){
                    letterCount++;
                    matcher.start();
                }
            }
            if(letterCount>=low && letterCount<=high)
                result++;
        }
        return result;
    }
    public static int PartTwo(String[] arr){
        String passwordData; 
        int low=0, high=0,result=0;
        Pattern letter=Pattern.compile(""),letterPattern=Pattern.compile("[a-z]{1}(?=:)");
        Pattern digitPattern=Pattern.compile("(\\d+)");
        Pattern passPattern=Pattern.compile("[a-z]{2,}");
        String passW;
        Matcher matcher;

        for (int i = 0; i < arr.length; i++) {
            passwordData=arr[i];
            matcher=letterPattern.matcher(passwordData); //single letter 
            if(matcher.find()){
                letter=Pattern.compile(matcher.group(0));
            }
            matcher=digitPattern.matcher(passwordData); // range
            if(matcher.find()){
                low=Integer.parseInt(matcher.group(1));
                matcher.start();
                if(matcher.find()){
                    high=Integer.parseInt(matcher.group(1));
                }
            }
            matcher=passPattern.matcher(passwordData);
            if(matcher.find()){
                passW=matcher.group(0);
                if((passW.charAt(low-1)==letter.toString().charAt(0))!= (passW.charAt(high-1)==letter.toString().charAt(0)))
                    result++;   
            }
        }
        return result;
    }
        
}
