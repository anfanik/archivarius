package me.anfanik.archivarius.model.response

import me.anfanik.archivarius.model.entity.DocumentEntity

fun DocumentEntity.toResponse() =
    DocumentResponse(
        path = path,
        content = content
    )

fun DocumentEntity.toRawResponse() = content

data class DocumentResponse(
    val path: String,
    val content: String
)
