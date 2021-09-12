package com.gft.booktracking.service

import com.gft.booktracking.domain.entity.BookEntity
import com.gft.booktracking.domain.entity.PersonEntity
import com.gft.booktracking.repository.BookRepository
import com.gft.booktracking.repository.PersonRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.awt.print.Book

@Service
class BookTrackingService(val personRepository: PersonRepository, val bookRepository: BookRepository) {

    fun getAllPeopleDetails() : List<PersonEntity> {
        return personRepository.findAll()
    }

    fun getAllBooksDetails() : MutableIterable<BookEntity> {
        return bookRepository.findAll()
    }

    fun getDetailsFromPersonByID(id: Long) : PersonEntity {
        var personEntityValue : PersonEntity = PersonEntity()
       if (id != null && personRepository.existsById(id)) {
           return personRepository.findByIdOrNull(id)!!
       }
        return personEntityValue
    }

    fun getDetailsFromBookByID(id: Long) : BookEntity {
        var bookEntityValue : BookEntity = BookEntity()
        if (id != null && bookRepository.existsById(id)) {
            return bookRepository.findByIdOrNull(id)!!
        }
        return bookEntityValue
    }

    fun createPersonData(personEntity: PersonEntity, bookEntity: BookEntity): PersonEntity {
        return personRepository.save(personEntity)
    }

    fun createBookData(bookEntity: BookEntity) : BookEntity {
        return bookRepository.save(bookEntity)
    }

    fun updatePersonData(id: Long, personEntity: PersonEntity) : PersonEntity {
        if (id != null) {
            var savedPersonEntity: PersonEntity = getDetailsFromPersonByID(id)

            if (savedPersonEntity != null) {
                savedPersonEntity.name = personEntity.name
            }
            if (savedPersonEntity != null) {
                savedPersonEntity.email = personEntity.email
            }
            personRepository.save(savedPersonEntity)
            return savedPersonEntity
        }
        return personEntity
    }

    fun updateBookData(id: Long, bookEntity: BookEntity) : BookEntity {
        if (id != null) {
            var savedBookEntity: BookEntity = getDetailsFromBookByID(id)

            savedBookEntity.author = bookEntity.author
            savedBookEntity.title = bookEntity.title
            savedBookEntity.publishingCompany = bookEntity.publishingCompany
            savedBookEntity.publishingYear = bookEntity.publishingYear
            savedBookEntity.location = bookEntity.location
            bookRepository.save(savedBookEntity)
            return savedBookEntity
        }
        return bookEntity
    }


    fun deletePersonData(id: Long) {
        if (id != null && personRepository.existsById(id))
            personRepository.deleteById(id)
    }

    fun deleteBookData(id: Long) {
        if (id != null && bookRepository.existsById(id))
            bookRepository.deleteById(id)
    }

}