package net.codinux.kotlin.concurrent.atomic

import java.util.concurrent.atomic.AtomicReference

actual class AtomicReference<T> actual constructor(value: T?) {

    private val delegate = AtomicReference(value)


    actual fun get(): T? = delegate.get()

    actual fun set(newValue: T?) = delegate.set(newValue)

    actual fun getAndSet(newValue: T?) = delegate.getAndSet(newValue)


    override fun toString() = delegate.toString()

}