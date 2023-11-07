package controller;

import java.util.ArrayList;
import model.Person;
import view.TaxView;

public class TaxController {
    public Person person;
    public TaxView view;

    public TaxController(Person person, TaxView view) {
        this.person = person;
        this.view = view;
    }

    public void updateView() {
        double taxAmount = calculateTax();
        view.printTaxDetails(person.getTotalIncome(), person.getNumDependents(), person.getDependentDeductions(), person.getDependentOneDeduction(), taxAmount);
    }

    public double calculateTax() {
        double taxableIncome = person.getTotalIncome() - calculateTotalDeductions();
        if (taxableIncome <= 11000000) {
            return 0; // Miễn thuế
        } else if (taxableIncome <= 20000000) {
            return (taxableIncome - 11000000) * 0.05;
        } else if (taxableIncome <= 30000000) {
            return (20000000 - 11000000) * 0.05 + (taxableIncome - 20000000) * 0.1;
        } else {
            return (20000000 - 11000000) * 0.05 + (30000000 - 20000000) * 0.1 + (taxableIncome - 30000000) * 0.2;
        }
    }

    public double calculateTotalDeductions() {
        double totalDeductions = 0;
        totalDeductions += 11000000; // Giảm trừ cho bản thân
        totalDeductions += calculateDependentDeductions();
        totalDeductions += person.getDependentOneDeduction(); // Giảm trừ cho người lao động con một
        return totalDeductions;
    }

    public double calculateDependentDeductions() {
        double dependentDeduction = 0;
        ArrayList<Double> sortedDeductions = new ArrayList<>();
        for (double deduction : person.getDependentDeductions()) {
            if (deduction >= 4400000) {
                sortedDeductions.add(deduction);
            }
        }
        sortedDeductions.sort((a, b) -> Double.compare(b, a)); // Sắp xếp giảm dần

        if (sortedDeductions.size() > 2) {
            sortedDeductions = new ArrayList<>(sortedDeductions.subList(0, 2));
        }

        for (double deduction : sortedDeductions) {
            dependentDeduction += deduction;
        }
        return dependentDeduction;
    }
}
