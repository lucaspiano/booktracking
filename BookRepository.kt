package com.gft.booktracking.repository

import com.gft.booktracking.domain.entity.BookEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : CrudRepository<BookEntity, Long>{
}