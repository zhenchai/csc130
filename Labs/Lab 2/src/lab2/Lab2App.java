package lab2;

import javax.swing.JOptionPane;

public class Lab2App {

	public static void main(String[] args) {
	
		Employee[] employees = new Employee[5];
		employees[0] = new HourlyEmployee( "Smith", "Mary", "323456789", "Clerk", 1995, 15000, 45.0, 26.3);
		
		SalaryEmployee employee1 = new SalaryEmployee("Adams", "Joe", "234567890", "Supervisor", 1999, 23000, 66000);
		employees[1] = employee1;
		
		JOptionPane.showMessageDialog(null, employees[0].toString() + "\n" + "\n" + employees[1].toString(),  "Employee Information", JOptionPane.DEFAULT_OPTION);
		
		double weeklyPay = ((HourlyEmployee) employees[0]).calcWeeklyPay();
		double otherWeeklyPay = ((SalaryEmployee) employees[1]).calcWeeklyPay();
		
		employees[0].updateTotalPay(weeklyPay);
		employees[1].updateTotalPay(otherWeeklyPay);
		
		JOptionPane.showMessageDialog(null, employees[0].toString() + "\n" +"This Week's Pay: " + weeklyPay + "\n" ,  "Employee Information", JOptionPane.DEFAULT_OPTION);
		JOptionPane.showMessageDialog(null, employees[1].toString() + "\n" +"This Week's Pay: " + otherWeeklyPay + "\n" ,  "Employee Information", JOptionPane.DEFAULT_OPTION);
	
		JOptionPane.showMessageDialog(null,"First Employee's Years of Service: " + employees[0].calcYearsOfService(2013),  "Employee Information", JOptionPane.DEFAULT_OPTION);
		
		int compare = employees[0].compareTo(employees[1]);
		
		if (compare < 0 || compare == 0)
		{
			JOptionPane.showMessageDialog(null, "Last Name: " + employees[0].getLast() + "\n" + "SS: " + employees[0].getSocSecNum() + "\n\nLast Name: " + employees[1].getLast() + "\nSS: " + employees[1].getSocSecNum(),  "Employee Information", JOptionPane.DEFAULT_OPTION);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Last Name: " + employees[1].getLast() + "\n" + "SS: " + employees[1].getSocSecNum() + "\n\nLast Name: " + employees[0].getLast() + "\nSS: " + employees[0].getSocSecNum(),  "Employee Information", JOptionPane.DEFAULT_OPTION);
		}
	}
}
