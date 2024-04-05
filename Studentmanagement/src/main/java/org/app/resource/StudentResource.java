package org.app.resource;

import org.app.model.Student;
import org.app.repo.StudentRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("resource")
public class StudentResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAllStudents() throws SQLException {
        List<Student> lisOfStudents = StudentRepository.getAllStudent();
        return lisOfStudents;
    }

    @GET
    @Path("student/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudentById(@PathParam("id") int id) throws SQLException {
        return StudentRepository.getStudentById(id);
    }

    @POST
    @Path("student")
    public Student create(Student student) throws SQLException {
        StudentRepository.creatStudent(student);
        return student;
    }

    @PUT
    @Path("student")
    public Student update(Student student) throws SQLException {
        StudentRepository.updateStudent(student);
        int id = student.getId();
        return StudentRepository.getStudentById(id);
    }

    @DELETE
    @Path("student/{id}")
    public Student delete(@PathParam("id") int id) throws SQLException {
        Student student = StudentRepository.getStudentById(id);
        StudentRepository.deleteStudent(id);
        return student;
    }
}
