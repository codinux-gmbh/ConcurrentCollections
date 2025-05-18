package net.codinux.kotlin.concurrent.atomic

expect class AtomicReference<T>(value: T? = null) {

    fun get(): T?

    fun set(newValue: T?)

    fun getAndSet(newValue: T?): T?

}