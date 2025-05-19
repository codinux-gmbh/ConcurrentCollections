package net.codinux.kotlin.concurrent.atomic

import kotlin.concurrent.AtomicReference

actual class AtomicReference<T> actual constructor(value: T?) {

    private val delegate = AtomicReference(value)


    actual fun get(): T? = delegate.value

    actual fun set(newValue: T?) {
        delegate.value = newValue
    }

    actual fun getAndSet(newValue: T?): T? = delegate.getAndSet(newValue)


    override fun toString() = get().toString()

}