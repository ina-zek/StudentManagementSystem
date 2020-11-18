/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaaspire.classrosterupdate.service;

import com.javaaspire.classrosterupdate.dao.ClassRosterPersistenceException;
import com.javaaspire.classrosterupdate.dto.Student;
import java.util.List;

/**
 *
 * @author al_bae_ina
 */
public interface ClassRosterUpdateServiceLayer {
    
    void createStudent(Student student) throws
            ClassRosterUpdateDuplicateIdException,
            ClassRosterUpdateDataValidationException,
            ClassRosterPersistenceException;
 
    List<Student> getAllStudents() throws
            ClassRosterPersistenceException;
 
    Student getStudent(String studentId) throws
            ClassRosterPersistenceException;
 
    Student removeStudent(String studentId) throws
            ClassRosterPersistenceException;
    
    
}
