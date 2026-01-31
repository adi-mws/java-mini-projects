package ExpenseTracker.models;
import java.time.LocalDate;

public class Expense {
    public String title;
    public double amount; 
    public String category; 
    public LocalDate date; 

    public Expense(String title, double amount, String category) {
        this.title = title; 
        this.amount = amount; 
        this.category = category; 
        this.date = LocalDate.now(); 
    }

    public String toString() {
        return date + " | " + title + " | " + category  + " |  Rs" + amount; 
    }
}




