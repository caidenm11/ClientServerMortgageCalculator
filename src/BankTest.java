import org.testng.annotations.Test;
class BankTest {
        Bank b = new Bank(3.5,3,5000);

    @Test
    void setInterestRate() {

    }

    @org.junit.jupiter.api.Test
    void setYears() {

    }

    @org.junit.jupiter.api.Test
    void setLoanAmount() {
    }

    @org.junit.jupiter.api.Test
    void getMonthlyPayment() {
        System.out.println(b.getMonthlyPayment());
    }

    @org.junit.jupiter.api.Test
    void getTotalPayment() {
        System.out.println(b.getTotalPayment());
    }
}