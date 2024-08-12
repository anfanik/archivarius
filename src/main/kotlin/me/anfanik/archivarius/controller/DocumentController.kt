package me.anfanik.archivarius.controller

import me.anfanik.archivarius.model.response.toCreateResponse
import me.anfanik.archivarius.model.response.toRawResponse
import me.anfanik.archivarius.model.response.toResponse
import me.anfanik.archivarius.service.DocumentService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/documents")
class DocumentController(
    val service: DocumentService
) {

    @GetMapping("/{path}")
    fun getDocumentByPath(@PathVariable path: String) =
        service.getDocumentByPath(path, isVisit = true).toResponse()

    @GetMapping("/{path}/raw", produces = [MediaType.TEXT_PLAIN_VALUE])
    fun getRawDocumentByPath(@PathVariable path: String) =
        service.getDocumentByPath(path, isVisit = true).toRawResponse()

    @PutMapping
    fun createDocument(@RequestBody content: String) =
        service.createDocument(content).toCreateResponse()

}