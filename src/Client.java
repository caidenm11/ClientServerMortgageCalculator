import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client implements Protocol {

    private static DataOutputStream out;
    private static DataInputStream in;

    public static void main(String[] args) {
        try {
            Socket cSocket = new Socket("localhost", PORT);
            out = new DataOutputStream(cSocket.getOutputStream());
            in = new DataInputStream(cSocket.getInputStream());

            RunClient();
        } catch (Exception e) {
        } finally {
            System.out.println("Closing client.");
        }
    }

    private static void RunClient() throws IOException {
        InterestSender(3.5);
        FailCheck();

        YearSender(3);
        FailCheck();

        LoanSender(5000.0);
        FailCheck();

        GetMonthly();
        FailCheck();

        GetTotal();
        FailCheck();

        out.writeInt(QUIT);
        out.flush();
    }

    private static void FailCheck() throws IOException {
        int checker = in.readInt();
        if (checker == FAIL) {
            System.out.println("Something went wrong, received a fail message");
        }
    }

    private static void GetTotal() throws IOException {
        out.writeInt(TOTAL_PAYMENT);
        double t = in.readDouble();
        System.out.println("Total Payment: " + t);
        out.flush();
    }

    private static void GetMonthly() throws IOException {
        out.writeInt(MONTHLY_PAYMENT);
        double v = in.readDouble();
        System.out.println("Monthly Payment: " + v);
        out.flush();
    }


    private static void LoanSender(double v) throws IOException {
        out.writeInt(LOAN_AMOUNT);
        out.writeDouble(v);
        out.flush();
    }

    private static void YearSender(int i) throws IOException {
        out.writeInt(NUMBER_OF_YEARS);
        out.writeInt(i);
        out.flush();
    }

    private static void InterestSender(double v) throws IOException {
        out.writeInt(ANNUAL_INTEREST_RATE);
        out.writeDouble(v);
        out.flush();
    }

}
