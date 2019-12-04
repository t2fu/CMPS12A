import java.util.Scanner;
import java.util.ArrayList;

public class DataVisualizer {
   public static void main(String[] args) {
      ArrayList<String> a=new ArrayList<String>();
      ArrayList<Integer> b=new ArrayList<Integer>();
      
      Scanner scan=new Scanner(System.in);
      System.out.println("Enter a title for the data:");
      String title=scan.nextLine();
      System.out.println("You entered: "+title);
      System.out.println();
      System.out.println("Enter the column 1 header:");
      String c1=scan.nextLine();
      System.out.println("You entered: "+c1);
      System.out.println("");
      System.out.println("Enter the column 2 header:");
      String c2=scan.nextLine();
      System.out.println("You entered: "+c2);
      System.out.println();
      
      String input;
      String i2="0";
      do{
      System.out.println("Enter a data point (-1 to stop input):");   
      input=scan.nextLine();  
      
      if(input.contains("-1")){
        i2="-1";
        System.out.println();
      }
      else if(!(input.contains(","))){
        System.out.println("Error: No comma in string.");
        System.out.println();
      }
      
      else{
        int count=0;
        for(int z=0;z<input.length();z++){
          if((input.charAt(z))==','){
            count++;
            
          }
          
        }
        if(count>=2){
          System.out.println("Error: Too many commas in input.");
          System.out.println();
        }
        else{
        try{
      int i=input.indexOf(','); 
      String n=input.substring(0,i);
      
      
      int N=Integer.valueOf(input.substring(i+1,input.length()));
      
      i2=input.substring(i+1,input.length());
      a.add(n);
      b.add(N);
      System.out.println("Data string: "+n);
      System.out.println("Data integer: "+N);
      System.out.println("");
      }catch(StringIndexOutOfBoundsException ex){
        System.out.println("Error: Comma not followed by an integer.");
        System.out.println();
      }
      catch(NumberFormatException ex){
        System.out.println("Error: Comma not followed by an integer.");
        System.out.println();
      }
        }
      }
      

      }while(!(Integer.valueOf(i2)==-1));
      
      
     //44
      for(int i=0;i<33-title.length();i++){
        System.out.print(" ");
      }
      System.out.println(title);
      
      System.out.print(c1);
      for(int j=0;j<20-c1.length();j++){
        System.out.print(" ");
      }
      System.out.print("|");
      for(int j=0;j<23-c2.length();j++){
        System.out.print(" ");
      }
      System.out.print(c2);
      System.out.println();
      System.out.println("--------------------------------------------");
      for(int i=0;i<a.size();i++){
        System.out.print(a.get(i));
        for(int j=0;j<20-(a.get(i)).length();j++){
        System.out.print(" ");
      }
      System.out.print("|");
      for(int j=0;j<23-String.valueOf(b.get(i)).length();j++){
      System.out.print(" ");
      }
      System.out.print(b.get(i));
      System.out.println(); 
      }
      System.out.println(); 
      
      for(int i=0;i<a.size();i++){
      
      for(int j=0;j<20-(a.get(i)).length();j++){
        System.out.print(" ");
      }
        System.out.print(a.get(i));
      System.out.print(" ");
      for(int j=0;j<b.get(i);j++){
      System.out.print("*");
      }
      
      System.out.println(); 
      }
      
      
      /* Type your code here. */
      
      return;
   }     
}