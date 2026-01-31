package ExpenseTracker;
import ExpenseTracker.service.ExpenseService;

public class Main {
    public static void main(String[] args) {
        ExpenseService expService = new ExpenseService();
        expService.addExpense("Bought groceries", 290, "Essentials");
        expService.showExpenses();
        expService.totalExpense();
    }    
}
