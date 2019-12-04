/* Marketer.java
 * Programmer: Tiancheng Fu
 * CruzID: 1600058
 * Assignment: Payroll for Startup Company
 * Dec 6th 2017
 * Discription: This Marketer.java is a subclass extends from Employee.java
 */
public class Marketer extends Employee{
  
  public Marketer(int yearsWorked){
    super(yearsWorked);

  }// constructor
final double CLIENT_BONUS = 2000; // per new client
final int PAID_VACATION = 10; // days
final int UNPAID_VACATION = 10; // days
final double HEALTH_INSURANCE = 10000; // $/year
final double INCOME = 100000; // $/year

int numBonuses; // keeps track of how many commission
// based bonuses the employee received.
int usedUnpaidVacation; // keeps track of how much
 //unpaid vacation has been used.
int usedVacation; // keeps track of how much paid vacation
 // has been used.

public int getUsedUnpaidVacation(){//getter method for usedUnpaidVacation
  return usedUnpaidVacation;
}
public void setUsedUnpaidVacation(int newUsed){//setter method for usedUnpaidVacation
  usedUnpaidVacation=newUsed;
  
}

public int getUsedPaidVacation(){//getter method for usedPaidVacation
  return usedVacation;
}

public void setUsedPaidVacation(int newUsed){//setter method for usedPaidVacation
  usedVacation=newUsed;
  
}

public int getNumBonuses(){//getter method for numBonuses
  return numBonuses;
}
public void setNumBonuses(int newNum){//setter method for numBonuses
  numBonuses=newNum;
  
}



public void signDeal(){
  numBonuses++;

}// adds one to numBonuses.

public void usePaidVacation(){
 usedVacation++;  

}// adds one to usedVacation

public void useUnpaidVacation(){
  usedUnpaidVacation++;
}// adds one to
// usedUnpaidVacation

public void workYear(){
  int x =getYears() + 1;
  setYears(x);


}// Adds one to yearsWorked.
public double YTDValue(){
  
return (CLIENT_BONUS * numBonuses)+HEALTH_INSURANCE+INCOME+(PAID_VACATION * (INCOME / 260));
  
}/* Overridden from Employee class.
This is calculated by taking the sum of:
CLIENT_BONUS * numBonuses
HEALTH_INSURANCE
INCOME
PAID_VACATION * (INCOME / 260)
*/
public int yearsTillRetirement(){
   int x=getYears();
  double cal1=(float)usedUnpaidVacation / 260;
  double cal2=((float)usedVacation / 260) * 2;
  return (int)Math.round(35 -((float)x + cal1 + cal2));

}// Overridden from
/*Employee class. This should be rounded up to the nearest int.
The calculation should take place as floating point arithmetic to
ensure precision (hint: cast as double where necessary). This
number should not be below zero. This is calculated by: 35 –
(yearsWorked + (usedUnpaidVacation / 260) +
((usedPaidVacation / 260) * 2))
*/ 
}