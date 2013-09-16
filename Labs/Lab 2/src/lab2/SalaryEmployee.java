package lab2;

public class SalaryEmployee extends Employee {
	
	private double annualSalary;

	/** 
	 * SalaryEmployee - Uses the default constructor of the superclass and also sets value of annualSalary to 0
	*/
	
	public SalaryEmployee()     
	{
		super();
		annualSalary = 0;
	}
	
	/** 
	 * SalaryEmployee - Parameterized constructor
	 * 
	 * @param l - last name
	 * @param f - first name	
 	 * @param s - social security number
	 * @param t - title 
	 * @param startY - starting year
	 * @param p - total pay to date 
	 * @param annualSalary - annual salary
	 */
	
	public SalaryEmployee(String l, String f, String s, String t, int startY, double p, double annualSalary)
	{
		super(l, f, s, t, startY, p);
		this.annualSalary = annualSalary;
	}
	
	/** 
	 * getAnnualSalary - Use to return value of annualSalary  
	 * 
	 * @return annual salary
	 */
	public double getAnnualSalary()
	{
		return annualSalary;
	}
	
	/** 
	 * changeAnnualSalary - Use to change value of annualSalary to newSalary
	 * 
	 * @param newSalary
	 */
	public void changeAnnualSalary(double newSalary)
	{
		annualSalary = newSalary;
	}
	
	/** 
	 * toString - Returns a string that displays the annual salary
	 * of a salaryEmployee object
	 * 
     * @return a string containing basic Employee info with annual salary
     */
	public String toString()
	{
		return(super.toString() + "\n" + "Annual Salary: " + annualSalary);
	}
	
	/** 
	 * calcWeeklyPay - Returns salary employee's weekly pay by dividing
	 * annual salary by 52
	 * 
	 * @return weekly pay
	 */
	public double calcWeeklyPay()
	{
		return (annualSalary / 52);
	}
}
