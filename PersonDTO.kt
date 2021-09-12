package com.gft.booktracking.domain.dto

class PersonDTO {
    var person_id : Long = 0
    var name : String = ""
    var email : String = ""
    lateinit var book : ArrayList<BookDTO>
}