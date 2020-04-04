/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.calculator;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author junio
 */
@WebService(serviceName = "CalculatorWS")
public class CalculatorWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "add")
    public int add(@WebParam(name = "i") int i, @WebParam(name = "j") int j) {
        int k = i + j;
        return k;

    }
    
    @WebMethod(operationName = "subtract")
    public int sub(@WebParam(name = "i") int i, @WebParam(name = "j") int j) {
        int k = i - j;
        return k;

    }
    
    @WebMethod(operationName = "multiply")
    public double mul(@WebParam(name = "i") int i, @WebParam(name = "j") int j) {
        double k = i * j;
        return k;

    }
    
    @WebMethod(operationName = "divide")
    public double div(@WebParam(name = "i") int i, @WebParam(name = "j") int j) {
        double k = i / j;
        return k;

    }
}
