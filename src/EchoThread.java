import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import javax.net.ssl.*;
import javax.net.*;
import java.io.*;
import java.net.*;


public class EchoThread extends Thread {
    protected Socket socket;
    private JSONManager manager = new JSONManager();

    public static void main(String args[]) {


    }

    public EchoThread(Socket clientSocket) {
        this.socket = clientSocket;
    }

    public void run() {
        InputStream inp = null;
        BufferedReader brinp = null;
        DataOutputStream out = null;
        try {
            inp = socket.getInputStream();
            brinp = new BufferedReader(new InputStreamReader(inp));
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            return;
        }
        String line;
        while (true) {
            try {
                line = brinp.readLine();
                System.out.println("Recieved");

                JSONObject obj = manager.getArg(line);

                int x1 = ((Long)obj.get("x1")).intValue();


                if ((line == null) || line.equalsIgnoreCase("QUIT")) {
                    socket.close();
                    return;
                }
                else {
                    out.writeBytes( manager.serverWrite(true, true)+ "\n");
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }catch (ParseException e){

                e.printStackTrace();
                return;

            }
        }
    }
}