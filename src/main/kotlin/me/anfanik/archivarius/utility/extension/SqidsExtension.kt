package me.anfanik.archivarius.utility.extension

import org.sqids.Sqids

fun Sqids.encode(vararg numbers: Long): String =
    encode(listOf(*numbers.toTypedArray()))