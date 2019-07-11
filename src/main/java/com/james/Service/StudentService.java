package com.james.Service;

import com.james.Dao.StudentDao;
import com.james.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {

    @Autowired
    private StudentDao fakeStudentDaoImpl;

    public Collection<Student> getAllStudents(){
        return fakeStudentDaoImpl.getAllStudents();
    }

    public Student getStudentById(int id){
        return this.fakeStudentDaoImpl.getStudentById(id);
    }

    public void removeStudentById(int id) {
        this.fakeStudentDaoImpl.removeStudentById(id);
    }

    public void updateStudent(Student student){
        this.fakeStudentDaoImpl.updateStudent(student);

    }

    public void insertStudent(Student student) {
        this.fakeStudentDaoImpl.insertStudentToDb(student);

    }
}
