package com.khushi.emp;

public interface empinterface {

    //create employee
    public void createemp(employee emp);
    //show all employee
    public void showemp();
    //show employee based on id
    public void showempid(int id);
    //update employee
    public void updateemp(int id, String name);
    //delete employee
    public void deleteemp(int id);
}
