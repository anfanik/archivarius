package me.anfanik.archivarius.service

import me.anfanik.archivarius.exception.EntityNotFoundException
import me.anfanik.archivarius.model.entity.DocumentEntity
import kotlin.jvm.Throws

interface DocumentService {

    @Throws(EntityNotFoundException::class)
    fun getDocumentByPath(path: String, isVisit: Boolean = false): DocumentEntity

    fun isDocumentExistsByPath(path: String): Boolean

    fun createDocument(content: String, customPath: String? = null): DocumentEntity

}