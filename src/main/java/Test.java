import com.allen.model.IRT;
import com.allen.model.TimeZoneConverter;
import com.allen.view.single_dialog.SingleDialogNew;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String currentHour = dateFormat.format(new Date()).substring(8, 10);
        String currentMinutes = dateFormat.format(new Date()).substring(10, 12);
        System.out.println(currentHour + " " + currentMinutes);

        try {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            Date date1 = format.parse("22:19");
            Date date2 = format.parse("21:19");
            long difference = (date1.getTime() - date2.getTime())/60/1000;

            System.out.println(difference);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        for (int i = 0; i < 10100; i++) {
//            System.out.println(i);
//            if (i == 40) {
//                Timer timer = new Timer();
//                TimerTask task = new TimerTask() {
//                    @Override
//                    public void run() {
//                        System.out.println("abc");
//                        timer.cancel();
//                    }
//                };
//                timer.schedule(task, new Integer("1") *   // minutes to sleep
//                        60 *   // seconds to a minute
//                        1000);
//            }
//        }
//
//        countDownTimer();

        TimeZone();

        System.out.println(new Integer("08"));


        IRT irt = new IRT("20170825250048");
        irt = new IRT("20170825010048");

        irt = new IRT("20170801250048");
        irt = new IRT("20170801010048");
        irt = new IRT("20170101250048");
        irt = new IRT("20170101010048");
        irt = new IRT("20170701010048");





        //        System.out.println(irt);

//        TimeZoneConverter tzc = new TimeZoneConverter();
//        tzc.convert("20170828220000");
//        Calendar calendar = tzc.getCalendar();

    }


    public static void TimeZone() {
            // Create a calendar object and set it time based on the local
            // time zone
            Calendar localTime = Calendar.getInstance();
            localTime.set(Calendar.YEAR, 2017);
            localTime.set(Calendar.MONTH, 8);
            localTime.set(Calendar.DAY_OF_MONTH, 24);
            localTime.set(Calendar.HOUR, -2);
            localTime.set(Calendar.MINUTE, 15);
            localTime.set(Calendar.SECOND, 20);

            int year = localTime.get(Calendar.YEAR);
            int month = localTime.get(Calendar.MONTH);
            int date = localTime.get(Calendar.DAY_OF_MONTH);
            int hour = localTime.get(Calendar.HOUR);
            int minute = localTime.get(Calendar.MINUTE);
            int second = localTime.get(Calendar.SECOND);


            // Print the local time
            System.out.printf("Local time  : %02d:%02d:%02d:%02d:%02d:%02d\n", year, month, date, hour, minute, second);


            // Create a calendar object for representing a Germany time zone. Then we
            // wet the time of the calendar with the value of the local time

            Calendar germanyTime = new GregorianCalendar(TimeZone.getTimeZone("Europe/Berlin"));
            germanyTime.setTimeInMillis(localTime.getTimeInMillis());
            year = germanyTime.get(Calendar.YEAR);
            month = germanyTime.get(Calendar.MONTH);
            date = germanyTime.get(Calendar.DAY_OF_MONTH);
            hour = germanyTime.get(Calendar.HOUR);
            minute = germanyTime.get(Calendar.MINUTE);
            second = germanyTime.get(Calendar.SECOND);


            // Print the local time in Germany time zone
            System.out.printf("Germany time: %02d:%02d:%02d:%02d:%02d:%02d\n", year, month, date, hour, minute, second);
        }


    private static String loadEmailContent() {
        String result = "";



        File file = new File("email content.txt");
        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                result += sc.next();
            }
            System.out.println(result);
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }


    static String readFile(String path)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, Charset.defaultCharset());
    }

    static int counter;

    private static void countDownTimer() {
        Timer timer = new Timer();
        counter = 10;
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println(counter);
                counter--;
                if (counter == -1) {
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 1000,1000);
    }
}
