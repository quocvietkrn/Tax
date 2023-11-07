
import controller.TaxController;
import model.Person;
import view.TaxView;


public class Main {
    
    public static void main(String[] args) {
        String[] menuChoices = {"Calculate Tax", "Exit"};
        
        TaxView taxMenu = new TaxView("Tax Calculation Menu", menuChoices);

        taxMenu.run();
    }
}
