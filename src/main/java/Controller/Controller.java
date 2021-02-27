package Controller;

import ConnectionUtilities.SerialCommunication;
import Model.Led;
import Model.LedDAO;
import com.fazecast.jSerialComm.SerialPort;

import java.util.Scanner;

public class Controller {

    private final SerialPort port;

    public Controller() {
        port = SerialCommunication.getInstance();
        start();
    }

    public void start() {
        Scanner in = new Scanner(port.getInputStream());
        while (in.hasNext()) {

            in.nextLine();
            String ledState = in.nextLine();
            System.out.println(ledState);

            LedDAO ledRequest = new LedDAO();
            Led led = new Led();
            led.setLedState(ledState);
            ledRequest.save(led);

        }
    }


}
