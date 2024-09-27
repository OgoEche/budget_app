package budget_app.models;

public record Income(String source, Double amount, Interval pay_interval) {
}
