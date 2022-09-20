package Section23.Models;

public interface Taxable {
    public double calculateIncomeAfterTax(double amount);
    public void tax(double income);
}
