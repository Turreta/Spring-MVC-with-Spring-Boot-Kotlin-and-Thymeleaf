package com.turreta.sb.smvc.kotlin.services

import com.turreta.sb.smvc.kotlin.domain.Student
import org.springframework.stereotype.Service

/**
 * Created by Turreta.com on 16/6/2017.
 */
@Service
class StudentServiceImpl: StudentService {

    // This represents your database or any data source
    val studentList: MutableList<Student> = mutableListOf(
            Student(studentId = "1", lastName = "Doe", firstName = "John"),
            Student(studentId = "2", lastName = "Dean", firstName = "James"))

    override fun getStudents(): List<Student> {
        return studentList
    }

    override fun findStudentById(id: String): Student? {
        return studentList.find { s -> s.studentId.equals(id) }
    }

    override fun createStudent(student: Student) {
        studentList.add(student)
    }
}