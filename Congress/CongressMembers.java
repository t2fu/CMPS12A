/* CongressMembers.java
 * Programmer: Tiancheng Fu
 * CruzID: 1600058
 * Assignment: Sorting Approval Ratings
 * Nov 17th 2017
 * Discription: This CongressMembers class have two constructors, and couples of different interaction methods
 */
public class CongressMembers{
  
  private String firstName;
  private String lastName;
  private double appRating1;
  private double appRating2;
  private double appRating3;
  private double appRating4;
  private double appRating5;
  
  public CongressMembers(){//The default constructor
    firstName="none";
    lastName="none";
    appRating1=0;
    appRating2=0;
    appRating3=0;
    appRating4=0;
    appRating5=0;
  }
  
  public CongressMembers(String fn,String ln, double rate1,double rate2,double rate3, double rate4, double rate5){//The user define constructor
    
    firstName=fn;
    lastName=ln;
    appRating1=rate1;
    appRating2=rate2;
    appRating3=rate3;
    appRating4=rate4;
    appRating5=rate5;
  }
  
  public String getFirstName(){//The getter method the access the first name
    return firstName;
  }
  
  public void setFirstName(String newN){//The setter method to set the first name
   firstName=newN; 
  }
  public String getLastName(){//The getter method the access the last name
    return lastName;
  }
  
  public void setLastName(String newN){//The setter method to set the first name
   lastName=newN; 
  }
  
  public double getRating1(){//getter method get rating 1
    
    return appRating1; 
  }
   public double getRating2(){//getter method get rating 2
    
    return appRating2; 
  }
    public double getRating3(){//getter method get rating 3
    
    return appRating3; 
  }
     public double getRating4(){//getter method get rating 4
    
    return appRating4; 
  }
    public double getRating5(){//getter method get rating 5
    
    return appRating5; 
  }
  
  public void setRating(double newRating1, double newRating2, double newRating3, double newRating4, double newRating5){//setter method to set the ratings
   appRating1=newRating1; 
   appRating2=newRating2;
   appRating3=newRating3; 
   appRating4=newRating4;
   appRating5=newRating5; 
   
  }
  
  public double averageRating(){//The return method use to calculate the average rating
    double average=(appRating1+appRating2+appRating3+appRating4+appRating5)/5;
    
    return average;
  }
  
}