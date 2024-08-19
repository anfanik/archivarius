package me.anfanik.archivarius.model.response

import me.anfanik.archivarius.model.entity.DocumentEntity

fun DocumentEntity.toCreateResponse() =
    CreateDocumentResponse(
        path = path
    )

data class CreateDocumentResponse(
    val path: String
)
