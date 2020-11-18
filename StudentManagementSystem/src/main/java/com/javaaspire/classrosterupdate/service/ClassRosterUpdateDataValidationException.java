/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaaspire.classrosterupdate.service;

/**
 *
 * @author al_bae_ina
 */
public class ClassRosterUpdateDataValidationException extends Exception {
    
    public ClassRosterUpdateDataValidationException(String message) {
        super(message);
    }
    
    public ClassRosterUpdateDataValidationException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
