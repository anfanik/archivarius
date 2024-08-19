package me.anfanik.archivarius.config

import jakarta.annotation.PostConstruct
import me.anfanik.archivarius.service.DocumentService
import me.anfanik.archivarius.utility.logger
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class DefaultDocumentInitializer(
    private val documentService: DocumentService,
    @Value("classpath:about.txt") val defaultDocumentContent: Resource
) {

    @PostConstruct
    fun initializeAboutDocument() {
        if (documentService.isDocumentExistsByPath("about")) {
            return;
        }
        logger().info("'about' Document is not exists. Creating default document.")

        documentService.createDocument(
            customPath = "about",
            content = defaultDocumentContent.inputStream
                .bufferedReader()
                .readText()
        )
    }
}
