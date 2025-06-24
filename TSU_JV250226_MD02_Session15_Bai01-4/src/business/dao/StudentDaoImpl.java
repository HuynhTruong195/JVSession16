package business.dao;

import business.model.Students;
import ultils.ConnectionDb;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements IStudentDao {

    @Override
    public List<Students> getAllStudents() {
        List<Students> students = new ArrayList<>();
        Connection cnn = ConnectionDb.getConnection();
        try {
            CallableStatement call = cnn.prepareCall("{call get_all_students()}");
            ResultSet rs = call.executeQuery();

            while (rs.next()) {
                Students s = new Students(
                        rs.getInt("student_id"),
                        rs.getString("full_name"),
                        rs.getString("date_of_birth"),
                        rs.getString("email"));
                students.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public Students findStudentById(int id) {

        Connection cnn = ConnectionDb.getConnection();
        try {
            CallableStatement call = cnn.prepareCall("{call find_student_byId(?)}");
            call.setInt(1, id);
            ResultSet rs = call.executeQuery();

            if (rs.next()) {
                Students s = new Students(
                        rs.getInt("student_id"),
                        rs.getString("full_name"),
                        rs.getString("date_of_birth"),
                        rs.getString("email")
                );
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addStudent(Students student) {

        Connection cnn = ConnectionDb.getConnection();
        try {
            CallableStatement call = cnn.prepareCall("{call add_student(?,?,?)}");
            call.setString(1, student.getFull_name());
            call.setString(2, student.getDate_of_birth());
            call.setString(3, student.getEmail());
            call.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateStudent(Students student) {
        Connection cnn = ConnectionDb.getConnection();
        try {
            CallableStatement call = cnn.prepareCall("{call update_student(?,?,?,?)}");
            call.setInt(1,student.getStudent_Id());
            call.setString(2, student.getFull_name());
            call.setString(3, student.getDate_of_birth());
            call.setString(4, student.getEmail());
            call.executeUpdate();
            System.out.printf("Cập nhật thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void deleteStudent(int id) {
        Connection cnn = ConnectionDb.getConnection();
        try {
            CallableStatement call = cnn.prepareCall("{call delete_student(?)}");
            call.setInt(1, id);
            call.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
