package controller;

import model.Currency;
import view.ProjectView;

public class ProjectController {

    private ProjectView view;
    private Currency currency = Currency.getInstance();

    public ProjectController(ProjectView view) {
        this.view = view;
    }

    public void calculate(Double amount, String cur1, String cur2) {
        Double result = currency.convert(amount, cur1, cur2);
        Double roundedResult = Math.round(result * 100.0) / 100.0;
        view.setResult(roundedResult);
    }

    public java.util.Set<String> currencies() {
        return currency.getCurrencies();
    }
}
