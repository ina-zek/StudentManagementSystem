/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaaspire.classrosterupdate;

import com.javaaspire.classrosterupdate.controller.ClassRosterController;
import com.javaaspire.classrosterupdate.dao.ClassRosterDao;
import com.javaaspire.classrosterupdate.dao.ClassRosterDaoFileImpl;
import com.javaaspire.classrosterupdate.dao.ClassRosterUpdateAuditDao;
import com.javaaspire.classrosterupdate.dao.ClassRosterUpdateAuditDaoFileImpl;
import com.javaaspire.classrosterupdate.service.ClassRosterUpdateServiceLayer;
import com.javaaspire.classrosterupdate.service.ClassRosterUpdateServiceLayerImpl;
import com.javaaspire.classrosterupdate.ui.ClassRosterView;
import com.javaaspire.classrosterupdate.ui.UserIO;
import com.javaaspire.classrosterupdate.ui.UserIOConsoleImpl;

/**
 *
 * @author al_bae_ina
 */
public class App {
    
    
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        ClassRosterView myView = new ClassRosterView(myIo);
        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        ClassRosterUpdateAuditDao myAuditDao = new ClassRosterUpdateAuditDaoFileImpl();
        ClassRosterUpdateServiceLayer myService = new ClassRosterUpdateServiceLayerImpl(myDao, myAuditDao);
        ClassRosterController controller = new ClassRosterController(myService, myView);
        controller.run();
    }
    
}
