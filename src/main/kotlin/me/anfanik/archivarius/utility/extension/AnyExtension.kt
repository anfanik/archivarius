package me.anfanik.archivarius.utility.extension

inline fun <T> T.alsoConditional(condition: Boolean, block: (T) -> Unit): T {
    if (condition) {
        block(this)
    }
    return this
}