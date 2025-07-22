import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentServices {

    public static void addStudent(String firstName, String lastName, String email) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "root";
        String password = "root";

        String sql = "INSERT INTO student (first_name, last_name, email) " +
                "VALUES ('" + firstName + "', '" + lastName + "', '" + email + "')";

        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

        int update = statement.executeUpdate(sql);
        System.out.println("Student added " + update);

    }

    public static void addCourse(String name, String description, int credits) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "root";
        String password = "root";

        String sql = "INSERT INTO course (course_name, description, credits) " +
                "VALUES ('" + name + "', '" + description + "', " + credits + ")";

        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

        int update = statement.executeUpdate(sql);
        System.out.println("Course added " + update);
    }

    public static void updateStudent(int id, String firstName, String lastName, String email) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "root";
        String password = "root";

        String sql = "UPDATE student SET first_name = '" + firstName + "', last_name = '" + lastName +
                "', email = '" + email + "' WHERE id = " + id;

        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

        int update = statement.executeUpdate(sql);
       System.out.println("Student updated");
    }

    public static void updateCourse(int id, String name, String description, int credits) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "root";
        String password = "root";

        String sql = "UPDATE course SET course_name = '" + name + "', description = '" + description +
                "', credits = " + credits + " WHERE id = " + id;

        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

        int update = statement.executeUpdate(sql);
         System.out.println("Course updated");
    }
    public static void registerStudentForCourse(int studentId, int courseId) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "root";
        String password = "root";

        String sql = "INSERT INTO registration (student_id, course_id) VALUES (" + studentId + ", " + courseId + ")";

        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

        int update = statement.executeUpdate(sql);
        System.out.println("Student registered for course: " + update);
    }
    public static void deleteStudent(int id) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "root";
        String password = "root";

        String sql = "DELETE FROM student WHERE id = " + id;

        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

        int update = statement.executeUpdate(sql);
        System.out.println("Student deleted");
    }

    public static void deleteCourse(int id) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "root";
        String password = "root";

        String sql = "DELETE FROM course WHERE id = " + id;

        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

        int update = statement.executeUpdate(sql);
        System.out.println("Course deleted");

    }
    public static void deleteRegistration(int studentId, int courseId) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "root";
        String password = "root";

        String sql = "DELETE FROM registration WHERE student_id = " + studentId + " AND course_id = " + courseId;

        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

        int update = statement.executeUpdate(sql);
        System.out.println("Registration deleted: " + update);
    }
}
