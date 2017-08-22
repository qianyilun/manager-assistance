import com.allen.view.single_dialog.SingleDialogNew;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

        for (int i = 0; i < 10100; i++) {
            System.out.println(i);
            if (i == 40) {
                Timer timer = new Timer();
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("abc");
                        timer.cancel();
                    }
                };
                timer.schedule(task, new Integer("1") *   // minutes to sleep
                        60 *   // seconds to a minute
                        1000);
            }
        }
    }
}
