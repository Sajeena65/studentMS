/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajeena.studentMS.dao;

import com.sajeena.studentMS.entity.Student;

/**
 *
 * @author Admin
 */
public interface studentDAO {
    boolean insert(Student st);
    boolean delete(int id);
    Student getbyId(int id);
    Student[] getAll();
    
}
