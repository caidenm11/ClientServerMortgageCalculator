public interface Protocol {
    int PORT = 32999;
    int ANNUAL_INTEREST_RATE = 1;
    int NUMBER_OF_YEARS = 2;
    int LOAN_AMOUNT = 3;

    int MONTHLY_PAYMENT = 30;
    int TOTAL_PAYMENT = 31;



    int SUCCESS = 100;
    int FAIL = 101;
    int QUIT = 1000;
    int UKNOWN_COMMAND = 1001;

}
/*
Server:
Monthly-Payment
Total-Payment
 */