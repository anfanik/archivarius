package me.anfanik.archivarius.exception

inline fun <reified E> notFoundException(
    query: String
): E {
    throw EntityNotFoundException(
        entityName = E::class.simpleName ?: "Entity",
        query = query
    )
}

class EntityNotFoundException(
    entityName: String,
    query: String
) : RuntimeException("$entityName is not found by $query query")