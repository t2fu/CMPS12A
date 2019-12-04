/* CongressMembersTest.java
 * Programmer: Tiancheng Fu
 * CruzID: 1600058
 * Assignment: Sorting Approval Ratings
 * Nov 17th 2017
 * Discription: This CongressMembersTest java file will read through approval.txt and use the datas in the file to create an
 * array of CongressMembers subjects, then this program will use bubble sort to sort the CongressMembers by first names and 
 * the average rating. At last, the program will print out those two sorted CongressMembers array in a new txt file call output.txt
 */
import java.io.*;//import stuffs
import java.util.*;
public class CongressMembersTest{
  static int counter;//Declare int variable counter to count how many congress members are in the .txt file 
 
  public static void main(String[]args)throws IOException{//main class
    
    String fileName="approval.txt";

    counter=0;
    
  try{//Try catch block use t throw exception if the inputs go wrong or the file name isn't right
    
    FileReader fileR=new FileReader(fileName);//Declare a new FileReader to read the file
    BufferedReader BR=new BufferedReader(fileR);//Declare a new BufferedReader to read the datas in the file
     String line = null;//Declare a String variable and insert null in it
     

            while((line = BR.readLine()) != null) {//If there is data on the line
              
                counter++;//add one to the line counter
            }
            BR.close();//close the BufferedReader
            fileR.close();//close the file Reader
            
    }
  
        catch(FileNotFoundException ex) {//When the program can't find the file
            System.out.println("Unable to open file '" + fileName + "'");                
        }
        catch(IOException ex) {//When there's a wrong going on when reading the datas
            System.out.println("Error reading file '"+ fileName + "'");                  
        }
        catch(NoSuchElementException ex){//When there's no line coming up next
        }
        
      //System.out.println(counter); 
        
      String [][] array=initializeArray(counter);//declared a String 2D array that use to store the datas read from the files
     
      CongressMembers [] members=new CongressMembers[counter];//Declare a array of CongressMembers objects
      
      for(int i=0;i<counter;i++){
       members[i]=new CongressMembers(array[i][0],array[i][1],Double.parseDouble(array[i][2]),Double.parseDouble(array[i][3]),Double.parseDouble(array[i][4]),Double.parseDouble(array[i][5]),Double.parseDouble(array[i][6])); 

      }
      
      writeToFile(members);//Write the sorted array to output.txt
      System.out.println("Program finished");
      
  }
  
  public static String[][] initializeArray(int counter)throws IOException{//Read the file again and outputs a 2D array with all the datas in it
    File file=new File("approval.txt");
    String fileName="approval.txt";
    Scanner scan=new Scanner(file);//Declare a new Scanner to scan the datas in the file
    String [][] lists=new String[counter][7];//Declare a String 2D array use to store all the datas from the approval.txt
    
     try{//Try catch block 
    
     FileReader fileR=new FileReader(fileName);//Declare a new FileReader to read the file
     String line = null;//Declare a String variable and insert null in it

            int row=0;//Declare a new int variable to count the rows in the 2D array
            int col=0;//Declare a new int variable to count the columns in the 2D array
            String line2="null";//Declare a String variable and set it to null
                        
            while((line2 = scan.next()) != null) {//If there is data on the line
        
              if(col<7){//if the numbers of col smaller than 7 then put the data in the same row
                 lists[row][col]=line2;
                  
                 col++;
              
              }
              
              if(col>=7){//if the numbers of col exceed or equals to 7 then add 1 to the row and set the col to 0
                  //System.out.println();
                  row++;
                
                  col=0;
                  
                } 
            }

            scan.close();//Close the file scanner
            fileR.close();//Close the FileReader  
           // System.out.println("work");   
    }
        catch(IOException ex) {//When there's a wrong going on when reading the datas
            System.out.println("Error reading file '"+ fileName + "'");                  
        }
        catch(NoSuchElementException ex){//When there's no more line in the file
        }
        return lists;//return the 2D array with the datas
  }
  public static CongressMembers [] sortByFirstName(CongressMembers [] mem){//Sort the array of CongressMembers by their FirstName(From A-Z) use bubble sort
    
    for (int i = 0; i < mem.length-1; i++){
      for (int j = 0; j < mem.length-i-1; j++){
                if ((mem[j].getFirstName()).compareTo(mem[j+1].getFirstName())>0)
                {
                    // swap temp and mem[j]
                     CongressMembers temp = mem[j];
                    mem[j] = mem[j+1];
                    mem[j+1] = temp;
                }
      }
    }
    return mem;//return the sorted CongressMembers array
  }
  
  public static CongressMembers [] sortByApprovalRating(CongressMembers [] mem){//Sort the array of CongressMembers by their average approval rating(large to small) use bubble sort
    
    for (int i = 0; i < mem.length-1; i++){
      for (int j = 0; j < mem.length-i-1; j++){
                if ((mem[j].averageRating())<(mem[j+1].averageRating()))
                {
                    // swap temp and mem[j]
                     CongressMembers temp = mem[j];
                    mem[j] = mem[j+1];
                    mem[j+1] = temp;
                }
      }
    }
    return mem;//return the sorted CongressMembers array
  }
  public static void writeToFile(CongressMembers [] mem)throws IOException{//Write the CongressMembers array sorted by the FirstName and sorted by the average approval rating to output.txt
    FileWriter writ=new FileWriter("output.txt");//Create a new FileWriter
    PrintWriter print=new PrintWriter(writ);//Create a new PrintWriter
    
    print.println("There are "+counter+" congress members");
    print.println();
    print.println("The list of Congress members sort by First Names:");
    CongressMembers [] arr1= sortByFirstName(mem);
    for(int i=0;i<counter;i++){
      print.println(arr1[i].getFirstName()+" "+arr1[i].getLastName()+" "+arr1[i].getRating1()+" "+arr1[i].getRating2()+" "+arr1[i].getRating3()+" "+arr1[i].getRating4()+" "+arr1[i].getRating5());
    }
    print.println();
    print.println();
    print.println("The list of Congress members sort by Average Ratings from high to low:");
    CongressMembers [] arr2= sortByApprovalRating(mem);
    for(int i=0;i<counter;i++){
      print.println(arr2[i].getFirstName()+" "+arr2[i].getLastName()+" "+arr2[i].getRating1()+" "+arr2[i].getRating2()+" "+arr2[i].getRating3()+" "+arr2[i].getRating4()+" "+arr2[i].getRating5());
    }
    print.close();//close the PrintWriter
    writ.close();//close the FileWriter
  }
  
}