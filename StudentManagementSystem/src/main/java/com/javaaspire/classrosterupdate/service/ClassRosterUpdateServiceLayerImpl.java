/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaaspire.classrosterupdate.service;

import com.javaaspire.classrosterupdate.dao.ClassRosterDao;
import com.javaaspire.classrosterupdate.dao.ClassRosterPersistenceException;
import com.javaaspire.classrosterupdate.dao.ClassRosterUpdateAuditDao;
import com.javaaspire.classrosterupdate.dto.Student;
import java.util.List;

/**
 *
 * @author al_bae_ina
 */
public class ClassRosterUpdateServiceLayerImpl implements ClassRosterUpdateServiceLayer {
    
    private ClassRosterUpdateAuditDao auditDao;
    
    ClassRosterDao dao;
   
    public ClassRosterUpdateServiceLayerImpl(ClassRosterDao dao, ClassRosterUpdateAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }
    
    
    @Override
    public void createStudent(Student student) throws ClassRosterUpdateDuplicateIdException, ClassRosterUpdateDataValidationException, ClassRosterPersistenceException {
        if (dao.getStudent(student.getStudentId()) != null) {
            throw new ClassRosterUpdateDuplicateIdException("ERROR: Could not create student.  Student Id "+ student.getStudentId() + " already exists");
        }
        validateStudentData(student);
        dao.addStudent(student.getStudentId(), student);
        auditDao.writeAuditEntry("Student " + student.getStudentId() + " CREATED.");
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        return dao.getAllStudents();
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {
        return dao.getStudent(studentId);
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
        Student removedStudent = dao.removeStudent(studentId);
        auditDao.writeAuditEntry("Student " + studentId + " REMOVED.");
        return removedStudent;
    }
    
    private void validateStudentData(Student student) throws
        ClassRosterUpdateDataValidationException {

        if (student.getFirstName() == null
            || student.getFirstName().trim().length() == 0
            || student.getLastName() == null
            || student.getLastName().trim().length() == 0
            || student.getCohort() == null
            || student.getCohort().trim().length() == 0) {

        throw new ClassRosterUpdateDataValidationException("ERROR: All fields [First Name, Last Name, Cohort] are required.");
        }
    }
    
    
}
