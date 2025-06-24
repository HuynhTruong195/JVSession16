package business.dao;

import business.model.Students;

import java.util.List;

public interface IStudentDao {

    List<Students> getAllStudents();
    Students findStudentById(int id);
    void addStudent(Students student);
    void updateStudent(Students student);
    void deleteStudent(int id);

}
