package com.khushi.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class empimplement implements empinterface {
Connection con;

    @Override
    public void createemp(employee emp) {
        con=DBconnect.createdb();
        String query="insert into employee values(?,?,?,?)";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,emp.getId());
            pstm.setString(2,emp.getName());
            pstm.setDouble(3,emp.getSalary());
            pstm.setInt(4,emp.getAge());
            int count=pstm.executeUpdate();
            if(count!=0) {
                System.out.println("Employee Data inserted successfully!");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void showemp() {
        con=DBconnect.createdb();
        String query="SELECT * FROM employee";
        System.out.println("----------------------------------------");
        System.out.println("Employee Details: ");
        System.out.println("----------------------------------------");
        System.out.format("%s\t%s\t%s\t\t\t%s\n","ID","Name","Salary","Age");
        System.out.println("----------------------------------------");

        try{
            Statement stmt=con.createStatement();
            ResultSet result=stmt.executeQuery(query);
            while (result.next()) {
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
                System.out.println("----------------------------------------");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void showempid(int id) {
        con=DBconnect.createdb();
        String query="SELECT * FROM employee where id="+id;
        System.out.println("----------------------------------------");
        System.out.println("Employee Details: ");
        System.out.println("----------------------------------------");
        System.out.format("%s\t%s\t%s\t\t\t%s\n","ID","Name","Salary","Age");
        System.out.println("----------------------------------------");


        try{
            Statement stmt=con.createStatement();
            ResultSet result=stmt.executeQuery(query);
            while (result.next()) {
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
                System.out.println("----------------------------------------");

            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void updateemp(int id, String name) {
        con=DBconnect.createdb();
        String query="update employee set name=? where id=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,name);
            pstm.setInt(2,id);
            int count=pstm.executeUpdate();
            if(count!=0) {
                System.out.println("Employee details updated successfully!");
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void deleteemp(int id) {
        con=DBconnect.createdb();
        String query="delete from employee where id=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,id);
            int count=pstm.executeUpdate();
            if(count!=0) {
                System.out.println("Employee deleted successfully!");
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
