import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;


public class Employee_Management_System
{
    Scanner sc = new Scanner(System.in);

    public void createtable()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/twinkle", "root", "Twinkle@123");

            String sql = "CREATE TABLE IF NOT EXISTS project (\n" +
                    "    id INT,\n" +
                    "    name VARCHAR(255),\n" +
                    "    address VARCHAR(255),\n" +
                    "    phone VARCHAR(255),\n" +
                    "    salary INT,\n" +
                    "    joining_date VARCHAR(255)\n" +
                    ");\n";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void insertdata ()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/twinkle", "root", "Twinkle@123");


            System.out.println("Enter your ID: ");
            int id = sc.nextInt();

            sc.nextLine();
            System.out.println("Enter your name: ");
            String name = sc.nextLine();

            System.out.println("Enter your Address: ");
            String address = sc.nextLine();

            System.out.println("Enter your phone number: ");
            String phone = sc.nextLine();

            System.out.println("Enter your salary: ");
            int salary = sc.nextInt();

            sc.nextLine();
            System.out.println("Enter your joining date: ");
            String date = sc.nextLine();

            String sql = "insert into project values(?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, address);
            ps.setString(4, phone);
            ps.setInt(5, salary);
            ps.setString(6, date);

            int status = ps.executeUpdate();

            if (status > 0)
            {
                System.out.println("your data has been successfully inserted");
            }
            else
            {
                System.out.println("your data has not been successfully inserted please try again");
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void fetchdata ()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/twinkle", "root", "Twinkle@123");

            String sql = "select * from project";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                int salary = rs.getInt("salary");
                String date = rs.getString("joining_date");

                System.out.println("-----------------------------");
                System.out.println("ID IS: " + id);
                System.out.println("NAME IS: " + name);
                System.out.println("ADDRESS IS: " + address);
                System.out.println("PHONE IS: " + phone);
                System.out.println("SALARY IS: " + salary);
                System.out.println("JOINING DATE IS: " + date);

                System.out.println();
                System.out.println("-----------------------------");
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void updatedata ()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/twinkle", "root", "Twinkle@123");
            String sql = "UPDATE project SET name=?, address=?, phone=?, salary=?, joining_date=? WHERE id=?";


            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your new name: ");
            String name = sc.nextLine();

            System.out.println("Enter your new address: ");
            String address = sc.nextLine();

            System.out.println("Enter your new phone number: ");
            String phone = sc.nextLine();

            System.out.println("Enter your new salary amount: ");
            int salary = sc.nextInt();

            sc.nextLine();
            System.out.println("Enter your new joining date: ");
            String date = sc.nextLine();

            System.out.println("Enter your id which you want to update: ");
            int id = sc.nextInt();

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, phone);
            ps.setInt(4, salary);
            ps.setString(5, date);
            ps.setInt(6, id);
            int st = ps.executeUpdate();

            if (st > 0) {
                System.out.println("Your data has been successfully updated.");
            } else {
                System.out.println("Your data was not updated.");
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void deletedata ()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/twinkle", "root", "Twinkle@123");

            String sql = "Delete from project where ID=?";
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your id which you want to delete");
            int id = sc.nextInt();

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int status = ps.executeUpdate();
            if (status > 0)
            {
                System.out.println("your data has been deleted");
            }
            else
            {
                System.out.println("your data has not been deleted");
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void searchdata()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/twinkle", "root", "Twinkle@123");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the ID you want to search:");
            int id = sc.nextInt();

            String sql = "SELECT * FROM project WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id1 = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                int salary = rs.getInt("salary");
                String date = rs.getString("joining_date");

                System.out.println("-----------------------------------------------");
                System.out.println();
                System.out.println("ID IS: " + id1);
                System.out.println("NAME IS: " + name);
                System.out.println("ADDRESS IS: " + address);
                System.out.println("PHONE NUMBER IS: " + phone);
                System.out.println("SALARY IS: " + salary);
                System.out.println("JOINING DATE IS: " + date);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void main (String[]args)
    {
        Scanner sc = new Scanner(System.in);
        Employee_Management_System ob = new Employee_Management_System();
        ob.createtable();
        int choice;

        do
        {
            System.out.println("-*-*-*-*-*-*-*-*Employees Management Data-*-*-*-*-*-*-*-*");

            System.out.println("1.Insertion");
            System.out.println("2.Fetch_Data");
            System.out.println("3.Update");
            System.out.println("4.Delete");
            System.out.println("5.Search");
            System.out.println("6.Exit");

            System.out.println("Enter your choice");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    ob.insertdata();
                    break;

                case 2:
                    ob.fetchdata();
                    break;

                case 3:
                    ob.updatedata();
                    break;

                case 4:
                    ob.deletedata();
                    break;

                case 5:
                    ob.searchdata();
                    break;

                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
        while (choice!=6);
     }
}