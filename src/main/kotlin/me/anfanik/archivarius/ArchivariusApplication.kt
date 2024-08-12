package me.anfanik.archivarius

import me.anfanik.archivarius.config.ArchivariusConfigurationProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(
    ArchivariusConfigurationProperties::class
)
class ArchivariusApplication

fun main(args: Array<String>) {
    runApplication<ArchivariusApplication>(*args)
}