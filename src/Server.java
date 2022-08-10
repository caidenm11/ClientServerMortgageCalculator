import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Protocol{
    public static void main(String[]args) throws IOException {
        ServerSocket sSocket = null;
        Socket client  = null;
        Bank bank = new Bank();
        try {
            sSocket = new ServerSocket(PORT);
            while(true){
                System.out.println("Connecting to client.");
                client = sSocket.accept();
                System.out.println("Connected.");
                BankService bankService = new BankService(client, bank);
                Thread serverThread = new Thread(bankService);
                serverThread.start();
            }
        } catch (IOException e) {
        } finally {
            System.out.println("Closing server.");
            sSocket.close();
        }
    }
}
