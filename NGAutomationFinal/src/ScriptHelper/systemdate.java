package ScriptHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class systemdate {

public static void main(String[] args) {
DateFormat Year = new SimpleDateFormat("yyyy");
DateFormat Month = new SimpleDateFormat("MMM");
DateFormat Day = new SimpleDateFormat("dd");
Calendar c = Calendar.getInstance();
c.add(Calendar.DATE, -1);
Date modifiedDate = c.getTime();
System.out.println(Year.format(modifiedDate));
System.out.println(Month.format(modifiedDate));
System.out.println(Day.format(modifiedDate));

}
}

