package net.codinux.kotlin.concurrent.atomic

import kotlin.concurrent.AtomicReference

actual class AtomicBoolean actual constructor(value: Boolean) {

    private val delegate = AtomicReference(value)

    actual fun get() = delegate.value

    actual fun set(newValue: Boolean) {
        delegate.value = newValue
    }

    override fun toString() = get().toString()

}