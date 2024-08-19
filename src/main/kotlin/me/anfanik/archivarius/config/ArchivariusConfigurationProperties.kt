package me.anfanik.archivarius.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.sqids.Sqids
import kotlin.time.Duration
import kotlin.time.Duration.Companion.days

@ConfigurationProperties("archivarius")
data class ArchivariusConfigurationProperties(
    val sqids:  SqidsConfig = SqidsConfig(),
    val document: DocumentConfig = DocumentConfig()
)

data class SqidsConfig(
    val alphabet: String = Sqids.Builder.DEFAULT_ALPHABET,
    val minimalLength: Int = 6
)

data class DocumentConfig(
    val duration: Duration = 30.days
)