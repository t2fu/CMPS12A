/* Payroll.java
 * Programmer: Tiancheng Fu
 * CruzID: 1600058
 * Assignment: Payroll for Startup Company
 * Dec 6th 2017
 * Discription: This class will not explicitly subclass from anything. It will
   have following instance variables and methods:
 */
public class Payroll {
  private Employee[] employees;//an array of Employees
  public int index;//the length of the array of Employees
  
  public Payroll(int x){
   index=x;
  initializeEmployees();

  }// Constructor takes the length for the array of Employees
  
  public void initializeEmployees(){//this method initialize the array of Employees
   employees = new Employee [index]; // array of index Employee objects.
  }
  
 // See constructor.

public Employee [] getEmployees(){//the getter method to get the array of Employees
  
  return employees;
  
}

public void setEmployees(Employee [] newE){//the setter method to get the array of Employees
  
  employees=newE;
  
}

public void sortEmployeesByRetirement(){
  for(int i=0;i<index-1;i++){
    for(int j=0;j<index-i-1;j++){
      if(employees[j].yearsTillRetirement()>employees[j+1].yearsTillRetirement()){
       Employee temp=employees[j];
       employees[j]=employees[j+1];
       employees[j+1]=temp;
      }
    }
  }
   
}/* sort employees
in ascending order of when the employee will retire. Employees
retiring the soonest will go at the beginning of the array. */

public void sortEmployeesByCost(){
  for(int i=0;i<index-1;i++){
    for(int j=0;j<index-i-1;j++){
      if(employees[j].YTDValue()<employees[j+1].YTDValue()){
       Employee temp=employees[j];
       employees[j]=employees[j+1];
       employees[j+1]=temp;
      }
    }
  }
   
}/* sort employees in
descending order of the YTDValue() of each employee.
Employees having the lowest YTDValue() will go at the beginning
of the array. */
}