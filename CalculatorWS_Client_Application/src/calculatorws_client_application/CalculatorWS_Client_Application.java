/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorws_client_application;

/**
 *
 * @author junio
 */
public class CalculatorWS_Client_Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            int i = 3;
            int j = 4;
            int result1 = add(i, j);
            int result2 = subtract(i, j);
            double result3 = multiply(i, j);
            double result4 = divide(i, j);
            System.out.println("Addition Result = " + result1);
            System.out.println("Subtraction Result = " + result2);
            System.out.println("Multiplication Result = " + result3);
            System.out.println("Division Result = " + result4);
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
    }

    private static int add(int i, int j) {
        org.me.calculator.CalculatorWS_Service service = new org.me.calculator.CalculatorWS_Service();
        org.me.calculator.CalculatorWS port = service.getCalculatorWSPort();
        return port.add(i, j);
    }

    private static double divide(int i, int j) {
        org.me.calculator.CalculatorWS_Service service = new org.me.calculator.CalculatorWS_Service();
        org.me.calculator.CalculatorWS port = service.getCalculatorWSPort();
        return port.divide(i, j);
    }

    private static double multiply(int i, int j) {
        org.me.calculator.CalculatorWS_Service service = new org.me.calculator.CalculatorWS_Service();
        org.me.calculator.CalculatorWS port = service.getCalculatorWSPort();
        return port.multiply(i, j);
    }

    private static int subtract(int i, int j) {
        org.me.calculator.CalculatorWS_Service service = new org.me.calculator.CalculatorWS_Service();
        org.me.calculator.CalculatorWS port = service.getCalculatorWSPort();
        return port.subtract(i, j);
    }
    
    
  
}
