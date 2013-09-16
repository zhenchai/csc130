package lab2;

/**
 * <p>Title: Lab #2 - Inheritance</p>
 *
 * <p>Description: HourlyEmployee Class - a subclass of Employee; 
 * defines properties and behaviors of an hourly employee</p>
 *
 * @author Andrew Mele and Marvin Yan 
 */
public class HourlyEmployee extends Employee
{
   private double hours;
   private double rate;

   /**
	* default constructor --
	* calls the default constructor of the Employee class (superclass)
	* and initializes local instance variables
	*/
   public HourlyEmployee()
   {
	 super();
	 hours = 0.0;
	 rate = 0.0;
   }

   /**
	* parameterized constructor --
	* calls the parameterized constructor of the Employee class (superclass)
	* and initializes local instance variables
	* @param l - last name
	* @param f - first name
	* @param ssNum - social security number
	* @param t - job title
	* @param startY - starting year
	* @param p - total pay to date
	* @param h - hours worked
	* @param r - rate
	*/
   public HourlyEmployee(String l, String f, String ssNum, String t, int startY,
						 double p, double h, double r)
   {
     super(l, f, ssNum, t, startY, p);
     hours = h;
     rate = r;
   }

   /**
   * setHours method - Changes employee's hours worked.
   * 
   * @param h - hours worked
   */
   public void setHours(double h)
   {
     hours = h;
   }

   /**
   * setRate method - Change employee's pay rate.
   * 
   * @param r - rate
   */
   public void setRate(double r)
   {
     rate = r;
   }

   /**
   * getHours method - Returns the value stored in the instance variable hours.
   * 
   * @return the value stored in hours
   */
  public double getHours()
  {
    return hours;
  }

  /**
   * getRate method - Returns the value stored in the instance variable rate
   * 
   * @return the value stored in rate
   */
  public double getRate()
  {
    return rate;
  }

  /** 
   * toString - Returns a string that displays the hours worked 
   *  and rate of pay for an HourlyEmployee.
   * 
   * @return a string containing Employee info with hours and rate
   */
  public String toString()
  {
	  return(super.toString() +"\n" + "Hours Worked: " + hours + "\n" + "Rate of Pay: " + rate);
  }
  
  /** 
   * calcWeeklyPay - Returns hourly employee's weekly pay by multiplying
   *  rate by hours worked.
   * 
   * @return weekly pay
   */
  public double calcWeeklyPay()
  {
	  return (rate * hours);
  }
  
}

