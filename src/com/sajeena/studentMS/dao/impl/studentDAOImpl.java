/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajeena.studentMS.dao.impl;

import com.sajeena.studentMS.dao.studentDAO;
import com.sajeena.studentMS.entity.Student;

/**
 *
 * @author Admin
 */
public class studentDAOImpl implements studentDAO {
    private int count=0;
    private Student[] studentname=new Student[10];
    @Override
    public boolean insert(Student st) {
        if(count==studentname.length){
        return false;
        }
    studentname[count]=st;
    count++;
    return true;
    }

   

    @Override
    public boolean delete(int id) {
     for(int i=0;i<studentname.length;i++){
      Student st=studentname[i];
      if(st!=null && st.getId()==id){
          studentname[i]=null;
          return true;
      }
              }
     return false;
    }

    @Override
    public Student getbyId(int id) {
        for(int i=0;i<studentname.length;i++){
      Student st=studentname[i];
      if(st!=null && st.getId()==id){
        
          return st;
      }
              }
     return null;
    }

    @Override
    public Student[] getAll() {
        return studentname;
    }
    
}
