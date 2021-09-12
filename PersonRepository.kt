package com.gft.booktracking.repository

import com.gft.booktracking.domain.entity.PersonEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface PersonRepository : CrudRepository<PersonEntity, Long> {
    override fun findAll(): List<PersonEntity>
}