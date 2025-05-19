package net.codinux.kotlin.concurrent.atomic

import java.util.concurrent.atomic.AtomicBoolean

actual class AtomicBoolean actual constructor(value: Boolean) {

    private val delegate = AtomicBoolean(value)

    actual fun get() = delegate.get()

    actual fun set(newValue: Boolean) = delegate.set(newValue)

    override fun toString() = delegate.toString()

}