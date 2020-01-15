package moneycalculator;

/**
 *
 * @author Néstor
 */

import moneycalculator.controller.Controller;
import moneycalculator.view.MoneyCalculatorView;

public class Main {

    public static void main(String[] args) {
        MoneyCalculatorView mainFrame = new MoneyCalculatorView("Money Calculator");
        Controller controller = new Controller(mainFrame);
        controller.initialize();
    }
}