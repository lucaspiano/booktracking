package com.gft.booktracking.controller

import com.gft.booktracking.domain.dto.BookDTO
import com.gft.booktracking.domain.entity.BookEntity
import com.gft.booktracking.domain.entity.PersonEntity
import com.gft.booktracking.service.BookTrackingService
import org.springframework.data.rest.webmvc.ResourceNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI
import javax.validation.Valid


@RestController
class BookTrackingController(private val bookTrackingService: BookTrackingService) {

    @GetMapping("/people")
    fun getAllDataFromPeople(): List<PersonEntity> = bookTrackingService.getAllPeopleDetails()

    @GetMapping("/books")
    fun getAllDataFromBooks(): MutableIterable<BookEntity> = bookTrackingService.getAllBooksDetails()

    @GetMapping("/person/{id}")
    fun getPersonDataById(@PathVariable id : Long): ResponseEntity<PersonEntity> {
        return ResponseEntity.ok().body(bookTrackingService.getDetailsFromPersonByID(id));
    }

    @GetMapping("/book/{id}")
    fun getBookDataById(@PathVariable id : Long): ResponseEntity<BookEntity> {
        return ResponseEntity.ok().body(bookTrackingService.getDetailsFromBookByID(id));
    }


    @PostMapping(value = ["/person"], consumes = ["application/json"], produces = ["application/json"])
    fun createUserData(@Valid @RequestBody personEntity : PersonEntity, bookEntity: BookEntity) : ResponseEntity<PersonEntity> {
       val personEntityValue : PersonEntity = bookTrackingService.createPersonData(personEntity, bookEntity)
        val location: URI = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/person/{id}")
            .buildAndExpand(personEntity.person_id)
            .toUri()
        return ResponseEntity.created(location)
            .body(personEntityValue)
    }


    @PostMapping(value = ["/book"], consumes = ["application/json"], produces = ["application/json"])
    fun createUserData(@Valid @RequestBody bookEntity : BookEntity) : ResponseEntity<BookEntity> {
        val bookEntityValue : BookEntity = bookTrackingService.createBookData(bookEntity)
        val location: URI = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/person/{id}")
            .buildAndExpand(bookEntity.book_id)
            .toUri()
        return ResponseEntity.created(location)
            .body(bookEntityValue)
    }

    @PutMapping("person/{id}")
    fun updateUserData(@PathVariable(value = "id")  id: Long,
    @Valid @RequestBody personEntity: PersonEntity): ResponseEntity<PersonEntity> {
        var changedPersonEntity : PersonEntity = bookTrackingService.updatePersonData(id, personEntity)
        return ResponseEntity.ok(changedPersonEntity)
    }

    @PutMapping("book/{id}")
    fun updateUserData(@PathVariable(value = "id")  id: Long,
                       @Valid @RequestBody bookEntity: BookEntity): ResponseEntity<BookEntity> {
        var changedBookEntity : BookEntity = bookTrackingService.updateBookData(id, bookEntity)
        return ResponseEntity.ok(changedBookEntity)
    }

    @DeleteMapping("/person/{id}")
    fun deleteUserDataById(@PathVariable id: Long) : ResponseEntity<Any> {
        bookTrackingService.deletePersonData(id)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("/book/{id}")
    fun deleteBookDataById(@PathVariable id: Long) : ResponseEntity<Any> {
        bookTrackingService.deletePersonData(id)
        return ResponseEntity.noContent().build()
    }

}