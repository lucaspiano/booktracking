package com.gft.booktracking.domain.entity

import java.io.Serializable
import javax.persistence.*
import kotlin.jvm.Transient

@Entity
@Table(name = "BOOK")
class BookEntity : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var book_id : Long = 0L

    @Column(name="title", nullable = false)
    var title : String = ""

    @Column(name="author", nullable = false)
    var author : String = ""

    @Column(name="publishing_company", nullable = false)
    var publishingCompany : String = ""

    @Column(name="publishing_year", nullable = false)
    var publishingYear : String = ""

    @Column(name="location", nullable = false)
    var location : String = ""

    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id", insertable = true, updatable = true)
    private var person_id : PersonEntity? = PersonEntity()

}