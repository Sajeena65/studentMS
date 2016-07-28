/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajeena.studentMS;

import com.sajeena.studentMS.dao.impl.studentDAOImpl;
import com.sajeena.studentMS.dao.studentDAO;
import com.sajeena.studentMS.entity.Student;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        studentDAO studentdao = new studentDAOImpl();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("1.Enter name of student:");
            System.out.println("2.Delete student record:");
            System.out.println("3.Show all:");
            System.out.println("4.Search by Id:");
            System.out.println("5.Exit");
            System.out.println("Enter your choice [1-5]:");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter student detail:");
                    Student st=new Student();
                    System.out.println("Enter Id:");
                    st.setId(input.nextInt());
                    System.out.println("Enter First Name of student:");
                    st.setFirstname(input.next());
                    System.out.println("Enter last name of student");
                    st.setLastname(input.next());
                    System.out.println("Enter email id:");
                    st.setEmail(input.next());
                    System.out.println("Enter phone no:");
                    st.setPhoneNo(input.next());
                    System.out.println("Enter Gender:");
                    st.setGender(input.next());
                    System.out.println("Enter status:");
                    st.setStatus(input.nextBoolean());
                    if(studentdao.insert(st)){
                        System.out.println("Inserted successfully");
                        
                    }else
                        System.out.println("Data Full");
                    break;
                case 2:
                     System.out.println("Enter the Id to delete: ");
                    int id= input.nextInt();
                    if (studentdao.delete(id)) {
                        System.out.println("Id No " + id + " is deleted successfully.");
                    } else {
                        System.out.println("Id not found.");
                    }

                    break;
                case 3:
                    System.out.println("Listing all student:");
                    Student[] students=studentdao.getAll();
                    for(int i=0;i<students.length;i++){
                        Student student=students[i];
                      if(student!=null){
                         System.out.println("Id:"+student.getId());
                         System.out.println("Name:"+student.getFirstname()+" "+student.getLastname());
                         System.out.println("Email Id:"+student.getEmail());
                         System.out.println("Phone no:"+student.getPhoneNo());
                         System.out.println("Gender:"+student.getGender());
                         System.out.println("Status:"+student.isStatus());
                         
                      }  
                    }
                    break;
                case 4:
                    System.out.println("Enter Id of student:");
                    int a= input.nextInt();
                    Student student=studentdao.getbyId(a);
                    if(student!=null){
                         System.out.println("Id:"+student.getId());
                         System.out.println("Name:"+student.getFirstname()+" "+student.getLastname());
                         System.out.println("Email Id:"+student.getEmail());
                         System.out.println("Phone no:"+student.getPhoneNo());
                         System.out.println("Gender:"+student.getGender());
                         System.out.println("Status:"+student.isStatus());
                    }else
                    System.out.println("Student could not be found."); 
                       
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }

}
