import java.util.Date;

public class Loan {

    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate;

    // No-argument constructor
    public Loan() {
        annualInterestRate = 2.5;
        numberOfYears = 1;
        loanAmount = 1000;
        loanDate = new Date();
    }

    // Constructor with parameters
    public Loan(double annualInterestRate, int numberOfYears,
                double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        loanDate = new Date();
    }

    // Getter for annualInterestRate
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    // Setter for annualInterestRate
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    // Getter for numberOfYears
    public int getNumberOfYears() {
        return numberOfYears;
    }

    // Setter for numberOfYears
    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    // Getter for loanAmount
    public double getLoanAmount() {
        return loanAmount;
    }

    // Setter for loanAmount
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    // Getter for loanDate
    public Date getLoanDate() {
        return loanDate;
    }

    // Calculate monthly payment
    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200;
        int numberOfPayments = numberOfYears * 12;

        double monthlyPayment = loanAmount * monthlyInterestRate /
                (1 - 1 / Math.pow(1 + monthlyInterestRate,
                        numberOfPayments));

        return monthlyPayment;
    }

    // Calculate total payment
    public double getTotalPayment() {
        return getMonthlyPayment() * numberOfYears * 12;
    }

    // Main method / Test
    public static void main(String[] args) {

        Loan loan = new Loan();

        System.out.println("Annual Interest Rate: "
                + loan.getAnnualInterestRate() + "%");

        System.out.println("Number of Years: "
                + loan.getNumberOfYears());

        System.out.println("Loan Amount: $"
                + loan.getLoanAmount());

        System.out.println("Loan Date: "
                + loan.getLoanDate());

        System.out.println("Monthly Payment: $"
                + loan.getMonthlyPayment());

        System.out.println("Total Payment: $"
                + loan.getTotalPayment());
    }
}