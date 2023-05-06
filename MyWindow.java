package digitalClock;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyWindow extends JFrame{

    private JLabel heading;
    private JLabel clockLabel;
    private Font font = new Font("", Font.BOLD, 35);

    MyWindow(){
        super.setTitle("Digital Clock");
        super.setSize(800,300);
        super.setLocation(300,50);
        this.createGUI();
        createtimer();
        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void createGUI(){
        heading = new JLabel("Digital Clock");
        clockLabel = new JLabel("clock");

        heading.setFont(font);
        clockLabel.setFont(font);

        this.setLayout(new GridLayout(2,1));
        this.add(heading);
        this.add(clockLabel);
    }

    public void createtimer(){
//        Timer timer = new Timer(1000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                String dateTime = new Date().toString();
//                Date date = new Date();
//                SimpleDateFormat sdf = new SimpleDateFormat("hh : mm : ss a");
//                String dateTime = sdf.format(date);
//                clockLabel.setText(dateTime);
//            }
//        });
//        timer.start();

        Thread t = new Thread(){
            public void run(){
                while(true){
                    try {
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("E, dd MMMM yyyy \t hh:mm:ss a ");
                    String dateTime = sdf.format(date);
                    clockLabel.setText(dateTime);

                    Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        t.start();

    }


}