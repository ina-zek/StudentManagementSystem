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
public class ClassRosterUpdateDuplicateIdException extends Exception  {
    
    
    public ClassRosterUpdateDuplicateIdException(String message) {
        super(message);
    }
    
     public ClassRosterUpdateDuplicateIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
