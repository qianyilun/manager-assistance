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
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

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

        countDownTimer();
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
            throws IOException
    {
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
