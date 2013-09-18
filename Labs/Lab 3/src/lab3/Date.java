package lab3;

/**
 * <p>Title: The Date Class</p>
 *
 * <p>Description: Objects of this type can store a month, day, and year as integers.
 * The class provides accessors and mutators for all instance variables along with
 * a toString method.</p>
 *
 * @author Marvin Yan, Milton Arantes
 */
public class Date
{
   private int dMonth;		//variable to store the month
   private int dDay;		//variable to store the day
   private int dYear;		//variable to store the year

   /**
     * default constructor --
     * sets month, day, and year to 1, 1, and 1800 respectively
     */
   public Date()
   {
       dMonth = 1;
       dDay = 1;
       dYear = 1800;
   }

   /**
    * parameterized constructor --
    * sets month, day, and year to user specified values
    * @param month value to be stored as this object's month
    * @param day value to be stored as this object's day
    * @param year value to be stored as this object's year
    * @throws DateException 
    */
   public Date(int month, int day, int year) throws DateException
   {
       setMonth(month);
       setDay(day);
       setYear(year);
   }

   /**
    * setDate --
    * stores month, day, and year by calling the setMethods defined
    * @param month value to be stored as this object's month
    * @param day value to be stored as this object's day
    * @param year value to be stored as this object's year
    * @throws DateException 
    */
   public void setDate(int month, int day, int year) throws DateException
   {
       setMonth(month);
       setDay(day);
       setYear(year);
   }

   /**
    * setMonth --
    * stores the user specified value as the month
    * @param month the value to be stored
    */
   public void setMonth(int month) throws DateException
   {
	   if (month >= 1 && month <= 12)
		   dMonth = month;
	   else
		   throw new DateException("Invalid Month: month out of range");
   }

   /**
    * setDay --
    * stores the user specified value as the day
    * @param day the value to be stored
    */
   public void setDay(int day) throws DateException
   {
	   if (day >= 1 && day <= 31)
		   dDay = day;
	   else
	     throw new DateException("Invalid Day: day out of range");
   }

   /**
    * setYear --
    * stores the user specified value as the year
    * @param year the value to be stored
    */
   public void setYear(int year) throws DateException
   {
	   if (year >= 1)
		   dYear = year;
	   else
	     throw new DateException("Invalid Year: year out of range");
   }

   /**
    * getMonth --
    * accessor for the month
    * @return returns the value stored as the month
    */
   public int getMonth()
   {
       return dMonth;
   }

   /**
    * getDay --
    * accessor for the day
    * @return returns the value stored as the day
    */
   public int getDay()
   {
     return dDay;
   }

   /**
    * getYear --
    * accessor for the year
    * @return returns the value stored as the year
    */
   public int getYear()
   {
       return dYear;
   }

    /**
    * toString --
    * returns the month, day, and year in the format: mm-dd-yyyy;
    * leading zeros are NOT contained within the string
    * @return a String containing the date in month-day-year format
    */
   public String toString()
   {
       return (dMonth + "-" + dDay + "-" + dYear);
   }
 }


