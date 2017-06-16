package com.turreta.sb.smvc.kotlin.controllers

import com.turreta.sb.smvc.kotlin.domain.Student
import com.turreta.sb.smvc.kotlin.forms.CreateStudentForm
import com.turreta.sb.smvc.kotlin.services.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

/**
 * Created by Turreta.com on 16/6/2017.
 */
@Controller
class StudentController {

    @Autowired
    lateinit var studentService: StudentService

    @RequestMapping("/students")
    fun listStudents(model: Model) : String {
        model.addAttribute("students", studentService.getStudents())
        return "students"
    }

    @RequestMapping("/student/{studentId}")
    fun findStudent(@PathVariable("studentId") sId: String, model: Model) : String {
        model.addAttribute("student", studentService.findStudentById(sId))
        return "student"
    }

    @RequestMapping(value="/student", method = arrayOf(RequestMethod.POST))
    fun addStudent(createStudentForm: CreateStudentForm, model: Model) : String {

        studentService.createStudent(Student(
                studentId = createStudentForm.studentId!!,
                lastName = createStudentForm.lastName!!,
                firstName = createStudentForm.firstName!!))

        return "redirect:/student/" + createStudentForm.studentId
    }

    @RequestMapping(value="/student")
    fun createStudentPage(model: Model) : String {
        model.addAttribute("studentForm", CreateStudentForm())
        return "new-student-form"
    }
}