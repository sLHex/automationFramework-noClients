package com.automation;

import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DataManipulationUtils {

        private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        private static final DateFormat stf = new SimpleDateFormat("HH:mm");
        private static final DateFormat fullstf = new SimpleDateFormat("HH:mm:ss");

public static String modifyTime (Date dtIn, String hourChangeType, int hours, String minsChangeType, int mins) {


        Calendar cal = Calendar.getInstance();
        cal.setTime(dtIn);

        switch (hourChangeType.toLowerCase()){

                case "add":
                        cal.add(Calendar.HOUR, hours);
                        break;
                case "minus":
                        cal.add(Calendar.HOUR, hours-(hours*2));
                        break;
                case "none":
                        break;
                default:
                        System.out.println("unknown Hour Modifier :" + hourChangeType + " Expected \'add\' or \"minus\" only");


        }


        switch (minsChangeType.toLowerCase()){

                case "add":
                        cal.add(Calendar.MINUTE, mins);
                        break;
                case "minus":
                        cal.add(Calendar.MINUTE, mins-(mins*2));
                        break;
                case "none":
                        break;
                default:
                        System.out.println("unknown minute Modifier :" + minsChangeType + " Expected \'add\', \"minus\" or \"none\" only");


        }



        return stf.format(cal.getTime());

}



        public static Calendar addMins(Date Time, int mins){

                Calendar cal = Calendar.getInstance();

                cal.setTime(Time);

                cal.add(Calendar.MINUTE, mins);


                return cal;


        }

        public static Calendar minusMins(Date Time, int mins){

                Calendar cal = Calendar.getInstance();

                cal.setTime(Time);

                mins=mins-(mins*2);

                cal.add(Calendar.MINUTE, mins);

                return cal;


        }


        public static Calendar minusHours(Date dateTime, int hours){

                Calendar cal = Calendar.getInstance();

                cal.setTime(dateTime);

                hours = hours-(hours*2);

                cal.add(Calendar.HOUR, hours); //minus number would decrement the days

                return cal;


        }


        public static Calendar addHours(Date dateTime, int hours){

                Calendar cal = Calendar.getInstance();

                cal.setTime(dateTime);

                cal.add(Calendar.HOUR, hours); //minus number would decrement the days

                return cal;


        }

        public static Calendar addDays(Date date, int days)
        {

            Calendar cal = Calendar.getInstance();

            cal.setTime(date);

            cal.add(Calendar.DATE, days); //minus number would decrement the days

            return cal;

        }


        public static String addMonths(Date date, int iMonths)


        {


        Calendar cal = Calendar.getInstance();

        cal.setTime(date);

        cal.add(Calendar.MONTH, iMonths); //minus number would decrement the days

        return cal.getTime().toString();


        }

        public static String addYears(Date date, int iYears)


        {

        Calendar cal = Calendar.getInstance();

        cal.setTime(date);

        cal.add(Calendar.YEAR, iYears); //minus number would decrement the days

        return cal.getTime().toString();


        }


}
