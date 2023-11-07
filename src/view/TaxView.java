
package view;

import controller.TaxController;
import model.Person;




public class TaxView extends Menu<String> {

    public TaxController taxController;

    public TaxView(String title, String[] menuChoices, TaxController taxController) {
        super(title, menuChoices);
        this.taxController = taxController;
    }

    public TaxView(String tax_Calculation_Menu, String[] menuChoices) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                double taxAmount = taxController.calculateTax();
                System.out.println("Tax Amount: " + taxAmount + " VND");
                
                break;
            case 2:
                System.out.println("Exiting TaxView...");
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
                break;
        }
    }


    public void printTaxDetails(double totalIncome, int numDependents, double[] dependentDeductions, double dependentOneDeduction, double taxAmount) {
        System.out.println("Thuế thu nhập chi tiết:");
        System.out.println("Tổng thu nhập hàng tháng: " + totalIncome + " đồng");
        System.out.println("Số người phụ thuộc: " + numDependents);
        System.out.println("Các giảm trừ cho người phụ thuộc: ");
        for (int i = 0; i < numDependents; i++) {
            System.out.println("Người phụ thuộc " + (i + 1) + ": " + dependentDeductions[i] + " đồng/tháng");
        }
        System.out.println("Người lao động con một: " + dependentOneDeduction + " đồng/tháng");
        System.out.println("Số tiền thuế phải nộp: " + taxAmount + " đồng");
    }
}