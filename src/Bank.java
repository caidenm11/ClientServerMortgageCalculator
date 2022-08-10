public class Bank {
    private double interestRate;
    private int years;
    private double loanAmount;

    public Bank() {
        interestRate = 0;
        years = 0;
        loanAmount = 0;
    }

    public Bank(double interestRate, int years, double loanAmount) {
        this.interestRate = interestRate;
        this.years = years;
        this.loanAmount = loanAmount;
    }

    public void setInterestRate(double IR) {
        interestRate = IR;
    }

    public void setYears(int y) {
        years = y;
    }

    public void setLoanAmount(double l) {
        loanAmount = l;
    }

    public double getMonthlyPayment() {
        double monthlyInterest = interestRate / 100 / 12;
        int numberOfPayments = years * 12;

        double mathPower = Math.pow(1 + monthlyInterest, numberOfPayments);

        double monthlyPayment = loanAmount * (monthlyInterest * mathPower / (mathPower - 1));
        return monthlyPayment;
    }

    public double getTotalPayment() {
        double monthlyPayment = getMonthlyPayment();
        return monthlyPayment * (years * 12);
    }
}
