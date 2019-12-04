/* ReadFile.java
 * Programmer: Tiancheng Fu
 * CruzID: 1600058
 * Assignment: Data Analysis
 * Nov 1st 2017
 * Discription: This program will read rainfall.txt file and allows the user choose between finding average, highest and 
 * lowest inside the data in the .txt file then this program will output the information the user want to know.
 * This program will keeps allowing the user to enter options until the user enters "quit".
 */
import java.util.*;//import all the stuff
import java.io.*;

public class ReadFile{
  static Scanner scan=new Scanner(System.in);//Declare a new scanner calls scan
  public static void main(String[]args)throws IOException{//main method
    
    double [] rainfall=new double[167];//Declare double array to store all the rainfall datas
    rainfall=populateArray();//Insert the rainfall dates into the array
    //populateArray();
    String opt=null;//Declare String variable to store user's choices
    do{//Run the do while loop until the user enters quit
    System.out.println("Enter the option \"average\", \"highest\", \"lowest\" or \"quit\":");
    opt=scan.next();//Insert the user's choice to the String variable
    
    if(opt.equals("average")){//If the user choose to find out the average rainfall
      System.out.println("Average rainfall since 1849: "+findAverage(populateArray())+" inches");
    }
    else if(opt.equals("lowest")){//If the user choose to find out which year have the lowest rainfall, and how much is the lowest rainfall
    System.out.println("Lowest rainfall since 1849: "+rainfall[findLowestYearIndex(populateArray())]+" inches which occured during year "+(1849+findLowestYearIndex(populateArray())));
      
    }
    else if(opt.equals("highest")){//If the user choose to find out which year have the highest rainfall, and how much is the highest rainfall
    System.out.println("Highest rainfall since 1849: "+rainfall[findHighestYearIndex(populateArray())]+" inches which occured during year "+(1849+findHighestYearIndex(populateArray())));
      
    }
    else if(opt.equals("quit")){//If the user choose to quit
    System.out.println("Program done.");
    }
    else{//If the input isn't anyone of the options.
    System.out.println("Invalid input");
    }
    System.out.println();//Empty line              
                  
    }while(!(opt.equals("quit")));//Stop the loop when the user enters quit
    
  }
  
  public static double[] populateArray(){//This method read the .txt file and store it in a double array then returns it
   
    double [] rainFall= new double[168];//Declare the double array to store the rainfall datas from the .txt file  
    String fileName = "rainfall.txt";//Declare a String variable to store the file name
    
    
    try{//Try catch block use t throw exception if the inputs go wrong or the file name isn't right
      
    FileReader fileR=new FileReader(fileName);//Declare a new FileReader to read the file
    BufferedReader BR=new BufferedReader(fileR);//Declare a new BufferedReader to read the datas in the file
    
     String line = null;//Declare a String variable and insert null in it
     
     int i=0;//Declare a Integer variable to count how many line has been read

            while(((line = BR.readLine()) != null)&&(i<168)) {//If there is data on the line and the line counter not exceed 167
                //System.out.println(line);
                rainFall[i] = Double.parseDouble(line);//insert the data to the array after convert it to double from String
                i++;//add one to the line counter
            }   

            BR.close();//Close the BufferedReader
            fileR.close();//Close the FileReader
    }
        catch(FileNotFoundException ex) {//When the program can't find the file
            System.out.println("Unable to open file '" + fileName + "'");                
        }
        catch(IOException ex) {//When there's a wrong going on when reading the datas
            System.out.println("Error reading file '"+ fileName + "'");                  
        }
    
    
   return rainFall;//Return the rainFall array
  }
  
  public static int findHighestYearIndex(double [] array){//This method return the index of the variable in the array which has the highest rainfall
    double highest=0;//Declare double variable to store the value of the highest rainfall
    int hIndex=0;//Declare an Integer variable to store the index of highest rainfall
    for(int i=0;i<array.length;i++){//Use for loop to go through the array
      if(array[i]>highest){//if the current variable is bigger than the highest rainfall store in highest so far
       highest=array[i];//Insert the value of current variable into highest
       hIndex=i;//Insert the index into the hIndex
       
        
      }
      
    }
    return hIndex;//Return the Index
  }
  
  public static int findLowestYearIndex(double [] array){//This method return the index of the variable in the array which has the lowest rainfall
    double lowest=array[0];//Declare double variable to store the value of lowest rainfall
    int lowIndex=0;//Declare an Integer variable to store the index of lowest rainfall
    
    for(int i=0;i<array.length;i++){//Use for loop to go through the array
      
      if(array[i]<lowest){//if the current variable is smaller than the smallest rainfall store in lowest so far
        
       lowest=array[i];//Insert the value of current variable into lowest
       lowIndex=i;//Insert the index into the lowIndex
       
      }
      
    }
    
    return lowIndex;//Return the Index
     
  }
  
  public static double findAverage(double [] array){//This method returns the average of all rainfall datas
    
    double sum=0;//Declare double variable sum to add all the datas together
    for(int i=0;i<array.length;i++){
     sum=sum+array[i];//Add all the datas in the array into sum
      
    }
    double average=sum/168;//Divide the sum of datas by the numbers of datas to get the average
    
    
    return Math.round(average * 100.0)/ 100.0;//Round the average to two decimal places and return it
    
  }
  
  
}