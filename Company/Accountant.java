/* Accountant.java
 * Programmer: Tiancheng Fu
 * CruzID: 1600058
 * Assignment: Payroll for Startup Company
 * Dec 6th 2017
 * Discription: This Accountant.java is a subclass extends from Employee.java
 */
public class Accountant extends Employee{
 
  public Accountant(int yearsWorked){// constructor
  super(yearsWorked);  
  }
  
final int PAID_VACATION = 10; // days
final int UNPAID_VACATION = 10; // days
final double HEALTH_INSURANCE = 15000; // $/year
final double INCOME = 125000; // $/year

private int usedUnpaidVacation;// keeps track of how much
 //unpaid vacation has been used.
private int usedVacation; // keeps track of how much paid vacation
 //has been used.

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

public void usePaidVacation(){
  usedVacation++;
  
}; // adds one to usedVacation

public void useUnpaidVacation(){
  usedUnpaidVacation++;

}// adds one to
// usedUnpaidVacation.

public void workYear(){
  int x =getYears() + 1;
  
  setYears(x);
} // Adds one to yearsWorked.

public double YTDValue(){
  double sum=HEALTH_INSURANCE+INCOME+(PAID_VACATION * (INCOME / 260));
  return sum;
} 
/* overridden from Employee class.
This is calculated by taking the sum of:
HEALTH_INSURANCE
INCOME
PAID_VACATION * (INCOME / 260)
*/

public int yearsTillRetirement(){
  int x=getYears();
  float cal1=(float)x + ((float)usedUnpaidVacation / 260);
  float cal2=((float)usedVacation / 260) * 2;
  
  float answer=35-((float)cal1 + (float)cal2);
  return (int)Math.round(answer);
  
}/* Overridden from
Employee class. This should be rounded up to the nearest int.
The calculation should take place as floating point arithmetic to
ensure precision (hint: cast as double where necessary). This
number should not be below zero. This is calculated by: 35 –
(yearsWorked + (usedUnpaidVacation / 260) +
((usedPaidVacation / 260) * 2))
*/
}