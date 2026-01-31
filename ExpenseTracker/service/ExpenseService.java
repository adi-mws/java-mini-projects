package ExpenseTracker.service;

import java.util.*;
import ExpenseTracker.models.Expense;

public class ExpenseService {
    private List<Expense> expenses = new ArrayList<>();

    public void showExpenses() {
        for (Expense e : expenses) {
            System.out.println(e);
        }
    }

    public void addExpense(String title, double amount, String category) {
        expenses.add(new Expense(title, amount, category));

    }

    public void totalExpense() {
        int sum = 0;
        for (Expense e : expenses) {
            sum += e.amount;
        }
        System.out.println("Total Amount = " + sum);
    }
}