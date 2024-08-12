package me.anfanik.archivarius.repository

import me.anfanik.archivarius.model.entity.DocumentEntity
import me.anfanik.archivarius.utility.Sequence.DOCUMENT_ID_SEQUENCE
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface DocumentRepository : CrudRepository<DocumentEntity, Long> {

    fun findByPath(path: String): DocumentEntity?

    fun existsByPath(path: String): Boolean

    @Query(value = "select nextval('$DOCUMENT_ID_SEQUENCE')", nativeQuery = true)
    fun generateId(): Long

}