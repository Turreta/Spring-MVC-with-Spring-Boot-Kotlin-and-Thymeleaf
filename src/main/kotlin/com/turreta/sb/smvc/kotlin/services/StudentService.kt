package com.turreta.sb.smvc.kotlin.services

import com.turreta.sb.smvc.kotlin.domain.Student

/**
 * Created by Turreta.com on 16/6/2017.
 */
interface StudentService {

    fun getStudents() : List<Student>

    fun findStudentById(id: String): Student?

    fun createStudent(student: Student)
}