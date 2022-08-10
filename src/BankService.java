import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class BankService implements Protocol, Runnable{
    private Socket client;
    private DataInputStream in;
    private DataOutputStream out;
    private Bank bank;

    public BankService(Socket client, Bank bank){ // add the Bank
        this.client = client;
        this.bank = bank;
    }

    @Override
    public void run() {
        try{
            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());
            int response  = 0;
            while (response != QUIT){
                response = in.readInt();
                double amount = 0;
                int years = -1;
                switch (response){
                    case ANNUAL_INTEREST_RATE:
                        amount = in.readDouble();
                        System.out.println("Annual Interest Rate: " + amount);
                        bank.setInterestRate(amount);
                        Successful();
                        break;
                    case NUMBER_OF_YEARS:
                        years = in.readInt();
                        System.out.println("Number of Years: " + years);
                        bank.setYears(years);
                        Successful();
                        break;
                    case LOAN_AMOUNT:
                        amount  = in.readDouble();
                        System.out.println("Loan Amount: " + amount);
                        bank.setLoanAmount(amount);
                        Successful();
                        break;
                    case MONTHLY_PAYMENT:
                        amount = bank.getMonthlyPayment();
                        out.writeDouble(amount);
                        Successful();
                        break;
                    case TOTAL_PAYMENT:
                        amount  = bank.getTotalPayment();
                        out.writeDouble(amount);
                        Successful();
                        break;
                    default:
                        out.writeInt(UNKNOWN_COMMAND);
                        out.writeInt(FAIL);
                        out.flush();
                        break;
                }
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void Successful() throws IOException {
        out.writeInt(SUCCESS);
        out.flush();
    }

}
