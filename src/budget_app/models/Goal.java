package budget_app.models;

import java.time.LocalDate;

public class Goal {
    private String name;
    private Double target_amount;
    private Double contribution_amount;
    private Interval contribution_interval;
    private LocalDate target_date;
    private Double realized_amount;

    public Goal(String name, Double target_amount, LocalDate target_date) {
        this.name = name;
        this.target_amount = target_amount;
        this.target_date = target_date;
    }

    public Double getContribution_amount() {
        return contribution_amount;
    }

    public void setContribution_amount(Double contribution_amount) {
        this.contribution_amount = contribution_amount;
    }

    public Interval getContribution_interval() {
        return contribution_interval;
    }

    public void setContribution_interval(Interval contribution_interval) {
        this.contribution_interval = contribution_interval;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTarget_amount() {
        return target_amount;
    }

    public void setTarget_amount(Double target_amount) {
        this.target_amount = target_amount;
    }

    public LocalDate getTarget_date() {
        return target_date;
    }

    public void setTarget_date(LocalDate target_date) {
        this.target_date = target_date;
    }

    public Double getRealized_amount() {
        return realized_amount;
    }

    public void setRealized_amount(Double realized_amount) {
        this.realized_amount = realized_amount;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "name='" + name + '\'' +
                ", target_amount=" + target_amount +
                ", target_date=" + target_date +
                ", realized_amount=" + realized_amount +
                '}';
    }
}
