package com.JDBC.service;
import com.JDBC.model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
interface IStudentDB{
    String createQuery(Student student);
    String updateQuery(Student student);
    String deleteQuery(Student student);
    List<Student> getStudents() throws SQLException;
    Student getStudent(int id) throws SQLException;
    ResultSet executeReadQuery(String query);
    boolean executeQuery(String query);
}

class MYSQLStudentDB implements IStudentDB{
    public MYSQLStudentDB() {
        openConnection();
    }

    private static Connection conn;
    static void openConnection()  {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/students", "root", "@root123");
        }catch (SQLException e){
        }
    }

    @Override
    public String createQuery(Student student) {
        return "INSERT INTO students(name,age, id) values(\"" + student.getName() + "\", \"" + student.getAge()+ "\",\"" + student.getId()+ "\")";
    }

    @Override
    public String updateQuery(Student student) {
        return "UPDATE students set name=(\""+  student.getName() + "\")" + "where id=(\"" + student.getId() +"\")";
    }

    @Override
    public String deleteQuery(Student student) {
        return  "DELETE FROM students  where id=(\""+  student.getId() + "\")";
    }


    @Override
    public List<Student> getStudents() throws SQLException {
        ResultSet resultSet = this.executeReadQuery("select * from students;");
        List<Student> studentList = new ArrayList<>();
        while(resultSet.next()){
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setAge(resultSet.getInt("age"));
            studentList.add(student);
        }
        return studentList;
    }

    @Override
    public Student getStudent(int id) throws SQLException {
        ResultSet resultSet = this.executeReadQuery("select * from students where id =" + id + ";");
        resultSet.next();
        Student student = new Student();
        student.setId(resultSet.getInt("id"));
        student.setName(resultSet.getString("name"));
        student.setAge(resultSet.getInt("age"));
        return student;
    }

    @Override
    public ResultSet executeReadQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        }catch (SQLException e){
            return null;
        }
    }


    @Override
    public boolean executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            return  true;
        }catch (SQLException e){
            return  false;
        }
    }
}

public class StudentUI {
    static IStudentDB iStudentDB;
    static Scanner sc;
    public static void main(String[] args) throws SQLException {
        sc = new Scanner(System.in);
        iStudentDB = new MYSQLStudentDB();

        while(true){
            int selection;
            System.out.println();
            System.out.println("Select:\n 1. To register a new student\n 2. To view list of students\n 3. To update a student\n 4. To delete a student\n 5. To exit. ");
            selection = sc.nextInt();
            switch (selection) {
                case 1: {
                    registerStudent();
                    break;
                }
                case 2: {
                    viewStudents();
                    break;
                }
                case 3: {
                    updateName();
                    break;
                }
                case 4: {
                    deleteStudent();
                    break;
                }
                case 5:
                    System.out.println("You are exiting the program.");
                    return;
                default:
                    System.out.println("Enter a correct option.");
                    return;
            }
        }
    }
    private  static void registerStudent() {
        Student student = new Student();
        System.out.print("Enter age: ");
        student.setAge(sc.nextInt());
        System.out.print("Enter ID: ");
        student.setId(sc.nextInt());
        System.out.print("Enter student name: ");
        student.setName(sc.nextLine());

        String create = iStudentDB.createQuery(student);
        System.out.println("Inserting records into the table...");
        iStudentDB.executeQuery(create);
        System.out.println("Inserted records into the table...");


    }
    private  static  void updateName(){
        Student student = new Student();
        System.out.print("Enter student name: ");
        student.setName(sc.nextLine());
        System.out.print("Enter student id: ");
        student.setId(sc.nextInt());

        String update = iStudentDB.updateQuery(student);
        System.out.println("Updating records in the table...");
        iStudentDB.executeQuery(update);
        System.out.println("Updated records in the table...");

    }
    private static void deleteStudent(){
        Student student = new Student();
        System.out.print("Enter student id: ");
        student.setId(sc.nextInt());

        String delete = iStudentDB.deleteQuery(student);
        System.out.println("Deleting records from the table...");
        iStudentDB.executeQuery(delete);
        System.out.println("Deleted records from the table...");

    }
    private static void viewStudents() throws SQLException {
        List<Student> studentList =iStudentDB.getStudents();
        for(Student student: studentList){
            System.out.println(student);
        }

    }

}
