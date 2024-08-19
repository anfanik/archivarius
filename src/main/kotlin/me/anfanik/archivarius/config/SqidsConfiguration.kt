package me.anfanik.archivarius.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.sqids.Sqids

@Configuration
class SqidsConfiguration(
    val archivariusConfig: ArchivariusConfigurationProperties
) {

    @Bean
    fun sqids(): Sqids = Sqids.builder()
        .alphabet(archivariusConfig.sqids.alphabet)
        .minLength(archivariusConfig.sqids.minimalLength)
        .build()

}