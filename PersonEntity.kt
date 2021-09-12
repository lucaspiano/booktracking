package com.gft.booktracking.domain.entity

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "PERSON")
class PersonEntity : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var person_id : Long = 0L

    @Column(name="name", nullable = false)
    var name : String = ""

    @Column(name="email", nullable = false)
    var email : String = ""

    @OneToMany(mappedBy = "person_id", cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
    var books : List<BookEntity?> = mutableListOf()
}
