package me.anfanik.archivarius.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import java.time.LocalDateTime.now

@Entity
@Table(name = "documents")
data class DocumentEntity(
    @Id val id: Long,
    @Column(unique = true) val path: String,
    @Column(columnDefinition = "text") val content: String,
    var expirationDate: LocalDateTime?,
    var lastVisitDate: LocalDateTime = now(),
    @CreationTimestamp val createDate: LocalDateTime = now()
)
