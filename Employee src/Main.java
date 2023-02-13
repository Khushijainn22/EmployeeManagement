package com.khushi.emp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String name;
        int id;
        empinterface dao=new empimplement();
        System.out.println("Welcome to Employee Management Application");

        Scanner sc= new Scanner(System.in);
        do {
            System.out.println("1. Add Employee\n" +
                    "2. Show All Employees\n" +
                    "3. Show Employee based on ID\n" +
                    "4. Update Employee\n" +
                    "5. Delete Employee\n" +
                    "6. Exit Application\n");

            System.out.println("Enter choice: ");
            int choice= sc.nextInt();
            switch (choice){
                case 1:
                    employee emp= new employee();
                    System.out.println("Enter ID: ");
                    id= sc.nextInt();
                    System.out.println("Enter Name: ");
                    name= sc.next();
                    System.out.println("Enter Salary: ");
                    double salary= sc.nextDouble();
                    System.out.println("Enter Age: ");
                    int age= sc.nextInt();
                    emp.setId(id);
                    emp.setName(name);
                    emp.setSalary(salary);
                    emp.setAge(age);
                    dao.createemp(emp);
                    break;
                case 2:
                    dao.showemp();
                    break;
                case 3:
                    System.out.println("Enter ID to view details ");
                    int empid=sc.nextInt();
                    dao.showempid(empid);
                    break;
                case 4:
                    System.out.println("Enter Id to update details ");
                    int empid1=sc.nextInt();
                    System.out.println("Enter new name");
                    name=sc.next();
                    dao.updateemp(empid1,name);
                    break;
                case 5:
                    System.out.println("Enter Id to be deleted ");
                    id=sc.nextInt();
                    dao.deleteemp(id);
                    break;
                case 6:
                    System.out.println("Thank You for using our Application!");
                    System.exit(0);
                default:
                    System.out.println("Enter valid choice");
                    break;
            }
        }while(true);
    }
}
