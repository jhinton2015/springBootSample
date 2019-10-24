package com.james.Service;

import com.james.Dao.StudentDao;
import com.james.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {

    @Autowired
    private StudentDao StudentDao;

    public Collection<Student> getAllStudents(){
        return StudentDao.getAllStudents();
        //gets all of the students
    }

    public Student getStudentById(int id){
        return this.StudentDao.getStudentById(id);
    }

    public void removeStudentById(int id) {
        this.StudentDao.removeStudentById(id);
    }

    public void updateStudent(Student student){
        this.StudentDao.updateStudent(student);

    }

    public void insertStudent(Student student) {
        this.StudentDao.insertStudentToDb(student);

    }
}
