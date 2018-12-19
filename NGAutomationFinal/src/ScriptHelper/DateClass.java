package ScriptHelper;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class DateClass {

public static void main(String[] args) {
// TODO Auto-generated method stub

DateFormat Year = new SimpleDateFormat("yyyy");
DateFormat Month = new SimpleDateFormat("MMM");
DateFormat Day = new SimpleDateFormat("dd");
Date currentDate = new Date();
Calendar c = Calendar.getInstance();
c.add(currentDate.getDay(), -1);
Date modifiedDate = c.getTime();
System.out.println(Year.format(modifiedDate));
System.out.println(Month.format(modifiedDate));
System.out.println(Day.format(modifiedDate));
}

}
