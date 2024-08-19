package me.anfanik.archivarius.service.impl

import me.anfanik.archivarius.config.ArchivariusConfigurationProperties
import me.anfanik.archivarius.exception.notFoundException
import me.anfanik.archivarius.model.entity.DocumentEntity
import me.anfanik.archivarius.repository.DocumentRepository
import me.anfanik.archivarius.service.DocumentService
import me.anfanik.archivarius.utility.extension.alsoConditional
import me.anfanik.archivarius.utility.extension.encode
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.sqids.Sqids
import java.time.LocalDateTime
import java.time.LocalDateTime.now
import kotlin.time.toJavaDuration

@Service
class DocumentServiceImpl(
    val repository: DocumentRepository,
    val sqids: Sqids,
    val archivariusConfig: ArchivariusConfigurationProperties,
    @Value("classpath:about.txt") val aboutDocumentContent: String
) : DocumentService {

    override fun getDocumentByPath(path: String, isVisit: Boolean) =
        repository.findByPath(path)
            ?.alsoConditional(isVisit) { processDocumentVisit(it) }
            ?: notFoundException("'$path' path")

    override fun isDocumentExistsByPath(path: String) =
        repository.existsByPath(path)

    private fun processDocumentVisit(document: DocumentEntity) {
        val now = now()

        document.lastVisitDate = now
        if (document.expirationDate != null) {
            document.expirationDate = generateExpirationDate(now)
        }

        repository.save(document)
    }

    override fun createDocument(
        content: String,
        customPath: String?
    ): DocumentEntity {
        val id = repository.generateId()
        val path = customPath ?: sqids.encode(id)

        val document = DocumentEntity(
            id = id,
            path = path,
            content = content,
            expirationDate = generateExpirationDate()
        )

        return repository.save(document)
    }

    private fun generateExpirationDate(startDate: LocalDateTime = now()) =
        startDate + archivariusConfig.document.duration.toJavaDuration()

    private fun createAboutDocument() {
        val document = createDocument(
            customPath = "about",
            content = aboutDocumentContent
        )
    }

}