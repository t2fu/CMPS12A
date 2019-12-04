/* BoardMember.java
 * Programmer: Tiancheng Fu
 * CruzID: 1600058
 * Assignment: Payroll for Startup Company
 * Dec 6th 2017
 * Discription: This BoardMember.java is a subclass extends from Employee.java
 */
public class BoardMember extends Employee{
 
  public BoardMember(int yearsWorked){
    super(yearsWorked);
    
  } // constructor
  
final double YEARLY_BONUS = 20000; // $/year
final int PAID_VACATION = 20; // days
final int UNPAID_VACATION = 10; // days
final int SICK_LEAVE = 10; // days
final double HEALTH_INSURANCE = 20000;//$/year
final double INCOME = 200000; // $/year


private int usedUnpaidVacation; // keeps track of how much unpaid vacation has been used.

private int usedVacation; // keeps track of how much paid vacation has been used.

private int usedSickDays; // keeps track of how many sick days have been used.

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
public int getUsedSickDays(){//getter method for usedSickDays
  return usedSickDays;
}
public void setUsedSickDays(int newUsed){//setter method for usedSickDays
   usedSickDays=newUsed;
  
}

public void usePaidVacation(){
  usedVacation++;

}// adds one to usedPaidVacation
 
public void useUnpaidVacation(){
  usedUnpaidVacation++;

}// adds one to
// usedUnpaidVacation

public void useSickDay(){
  usedSickDays++;

}// adds one to usedSickDays

public void workYear(){
  int x =getYears() + 1;
  
  setYears(x);

}// adds one to yearsWorked.

public double YTDValue(){
  return YEARLY_BONUS+HEALTH_INSURANCE+INCOME+(PAID_VACATION * (INCOME / 260))+((SICK_LEAVE - usedSickDays) * ((INCOME /260) / 2)); 
  
}/* overridden from Employee class.
YTDValue() is calculated by taking the sum of:
YEARLY_BONUS
HEALTH_INSURANCE
INCOME
PAID_VACATION * (INCOME / 260)
(SICK_LEAVE – usedSickDays) * ((INCOME /
260) / 2) */

 public int yearsTillRetirement(){
   int x=getYears();
  float cal1=(float)usedUnpaidVacation / 260;
  float cal2=((float)usedVacation / 260) * 2;
  float cal3=(float)usedSickDays /260;
  return (int)Math.round(35 -((float)x + cal1 + cal2 + cal3));
  
  
}/* overridden from Employee
class. This should be rounded up to the nearest int. The
calculation should take place as floating point arithmetic to ensure
precision (hint: cast as double where necessary). This number
should not be below zero. This is calculated by: 35 –
(yearsWorked + (usedUnpaidVacation / 260) +
((usedPaidVacation / 260) * 2) + (usedSickDays /
260))
*/
}