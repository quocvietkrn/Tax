package model;

public class Person {

    public double getDependentOneDeduction() {
        return dependentOneDeduction;
    }

    public void setDependentOneDeduction(double dependentOneDeduction) {
        this.dependentOneDeduction = dependentOneDeduction;
    }

    public Person() {
    }

    public double totalIncome; // Tổng thu nhập hàng tháng
    public int numDependents; // Số người phụ thuộc
    public double[] dependentDeductions; // Mảng giảm trừ cho người phụ thuộc
    public double dependentOneDeduction; // Giảm trừ cho người lao động con một

    public Person(double totalIncome, int numDependents, double[] dependentDeductions, double dependentOneDeduction) {
        this.totalIncome = totalIncome;
        this.numDependents = numDependents;
        this.dependentDeductions = dependentDeductions;
        this.dependentOneDeduction = dependentOneDeduction;
    }

    @Override
    public String toString() {
        return "Person{" + "totalIncome=" + totalIncome + ", numDependents=" + numDependents + ", dependentDeductions=" + dependentDeductions + '}';
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public int getNumDependents() {
        return numDependents;
    }

    public void setNumDependents(int numDependents) {
        this.numDependents = numDependents;
    }

    public double[] getDependentDeductions() {
        return dependentDeductions;
    }

    public void setDependentDeductions(double[] dependentDeductions) {
        this.dependentDeductions = dependentDeductions;
    }

   

}
