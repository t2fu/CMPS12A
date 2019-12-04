/* Intern.java
 * Programmer: Tiancheng Fu
 * CruzID: 1600058
 * Assignment: Payroll for Startup Company
 * Dec 6th 2017
 * Discription: This Intern.java is a subclass extends from Employee.java
 */
public class Intern extends Employee{
  
  public Intern(int yearsWorked){
    super(yearsWorked);

  } // constructor
  
final int UNPAID_VACATION = 10; // days
final double HEALTH_INSURANCE = 5000; // $/year
final double INCOME = 40000; // $/year

private int usedUnpaidVacation; // keeps track of how much
 //unpaid vacation has been used.
public int getUsedUnpaidVacation(){//getter method for usedUnpaidVacation
  return usedUnpaidVacation;
  
}
public void setUsedUnpaidVacation(int newUsed){//setter method for usedUnpaidVacation
  usedUnpaidVacation=newUsed;
  
}

public void useUnpaidVacation(){
  usedUnpaidVacation++;

}// adds one to
// usedUnpaidVacation
public void workYear(){
  int x =getYears() + 1;
  setYears(x);

}// Adds one to yearsWorked.

public double YTDValue(){
  return HEALTH_INSURANCE+INCOME;
  
  
}/* Overridden from Employee class.
This is calculated by taking the sum of:
HEALTH_INSURANCE
INCOME
*/

public int yearsTillRetirement(){
  int x=getYears();
  double cal1=(float)usedUnpaidVacation/ 260;
  return (int)Math.round(35-((float)x+cal1));
  
  
}/* Overridden from
Employee class. This should be rounded up to the nearest int.
The calculation should take place as floating point arithmetic to
ensure precision (hint: cast as double where necessary). This is
calculated by: 35 – (yearsWorked + (usedUnpaidVacation
/ 260))
*/
}