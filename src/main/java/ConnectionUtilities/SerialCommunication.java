package ConnectionUtilities;

import com.fazecast.jSerialComm.SerialPort;

public class SerialCommunication {

    private static SerialPort port;

    private SerialCommunication() {
    }

    public static SerialPort getInstance() {
        if (port == null) {
            port = SerialPort.getCommPorts()[0];
            port.openPort();
            port.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        }
        return port;
    }
}
