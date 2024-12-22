class QuadraticEquationSolver {

    private double a;
    private double b;
    private double c;

    public QuadraticEquationSolver(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] solve() {
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            return null;
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            return new double[]{root};
        } else {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            return new double[]{root1, root2};
        }
    }
}




________________________________________________________________________________________________________
class LoanInterestCalculator {

    // 计算等额本金总利息
    public static double calculateEqualPrincipalInterest(double loanAmount, int months, double annualInterestRate) {
        double monthlyInterestRate = annualInterestRate / 12;
        double totalInterest = 0;
        double principalPerMonth = loanAmount / months;
        for (int i = 1; i <= months; i++) {
            double interest = (loanAmount - (i - 1) * principalPerMonth) * monthlyInterestRate;
            totalInterest += interest;
        }
        return totalInterest;
    }

    // 计算等额本息总利息
    public static double calculateEqualInstallmentInterest(double loanAmount, int months, double annualInterestRate) {
        double monthlyInterestRate = annualInterestRate / 12;
        double denominator = 1 - Math.pow(1 + monthlyInterestRate, -months);
        double monthlyPayment = loanAmount * (monthlyInterestRate / denominator);
        double totalPayment = monthlyPayment * months;
        return totalPayment - loanAmount;
    }
}