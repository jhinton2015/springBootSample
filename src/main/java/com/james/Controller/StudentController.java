package com.james.Controller;

import com.james.Entity.Student;
import com.james.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    public StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> getAllStudents(HttpServletResponse response){
        response.setStatus(200);
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable("id") int id, HttpServletResponse response){
        response.setStatus(200);
        return studentService.getStudentById(id);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStudentById(@PathVariable("id") int id, HttpServletResponse response){
        studentService.removeStudentById(id);
        response.setStatus(200);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteStudentById(@RequestBody Student student, HttpServletResponse response){
        studentService.updateStudent(student);
        response.setStatus(200);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertStudent(@RequestBody Student student, HttpServletResponse response){
        studentService.insertStudent(student);
        response.setStatus(200);
    }


}