package lab2;

/**
 * <p>Title: Lab #2 - Inheritance</p>
 *
 * <p>Description: Employee Class - defines those properties that are common to
 * all employees and is used as the parent for other employee classes</p>
 *
 * @author Andrew Mele and Marvin Yan 
 */
public class Employee
{
   private String last;       //employee's last name
   private String first;      //employee's first name
   private String socSecNum;  //employee's social security number
   private String title;      //employee's title
   private int startYear;     //starting year of employment
   private double totalPay;   //total pay to date

   /**
    * default constructor --
    * stores default values in all variables
    */
   public Employee()
   {
     last = "";
     first = "";
     socSecNum = "";
     title = "";
     startYear = 0;
     totalPay = 0.0;
   }

   /**
    * parameterized constructor --
    * stores user-specified values in all variables
    * @param l - last name
    * @param f - first name
    * @param s - social security number
    * @param t - title
    * @param startY - starting year
    * @param p - total pay to date
    */
   public Employee(String l, String f, String s, String t, int startY, double p)
   {
     last = l;
     first = f;
     socSecNum = s;
     title = t;
     startYear = startY;
     totalPay = p;
   }

   /**
    * getLast method - Returns employee's last name
    * 
    * @return last name as a string
    */
   public String getLast()
   {
     return last;
   }
   
   /**
    * getSocSecNum method - Returns the employee's social security number
    * 
    * @return the employee's social security number as a string
    */
   public String getSocSecNum()
   {
	   return socSecNum;
   }

   /**
    * getTotalPay method - Returns employee's total pay to date
    * 
    * @return the total pay to date
    */
   public double getTotalPay()
   {
     return totalPay;
   }

   /**
    * calcYearsOfService method - calculates how many years a person has been employed
    * 
    * @param year - end year
    * @return the number of years worked from startYear to year
    */
   public int calcYearsOfService(int year)
   {
     return year - startYear;
   }

   /**
    * updateTotalPay - Updates the total amount paid to the employee
    * 
    * @param p - total pay to date
    */
   public void updateTotalPay(double p)
   {
     totalPay += p;
   }

   /**
    * toString method - Creates a String displaying basic Employee information
    * 
    * @return employee information
    */
   public String toString()
   {
     return (first + " " + last + "\n" +
             socSecNum + "\n" +
             title + "\n" +
             "Hired: " + startYear + "\n" +
             "Pay to date: " + totalPay);
   }
   
   /**
    * compareTo - Compares two employee's social security numbers and returns 
    * the position of the first compared to the second.
    * 
    * @param theEmployee - employee being compared to
    * @return a negative integer, positive integer, or 0 indicating position
    */
   public int compareTo(Employee theEmployee)
   {
	   return (this.socSecNum.compareTo(theEmployee.getSocSecNum()));
   }
}
