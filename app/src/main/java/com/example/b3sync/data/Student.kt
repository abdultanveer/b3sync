package com.example.b3sync.data

class Student(var name:String, var id:Int, val address:String,val marks: Int){

    fun toFaculty(student: Student):Faculty{
        val oneMillion = 1_000_000
        val onemil = 1000000
        var faculty = Faculty(student.name,student.id,student.address,"")
        return  faculty
    }
}