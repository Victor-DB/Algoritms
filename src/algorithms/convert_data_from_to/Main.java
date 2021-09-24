package algorithms.convert_data_from_to;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        String oldDateString = "2015-05-15";
        SimpleDateFormat oldDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        SimpleDateFormat newDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());

        Date date = null;
        try {
            date = oldDateFormat.parse(oldDateString);
            System.out.println("old date: " + date);
        } catch (ParseException e) { e.printStackTrace(); }

        String result = newDateFormat.format(date); // 30-09-2022
        System.out.println("result: " + result);
    }
}
