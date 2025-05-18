package net.codinux.kotlin.concurrent.atomic

expect class AtomicBoolean(value: Boolean = false) {

    fun get(): Boolean

    fun set(newValue: Boolean)

}