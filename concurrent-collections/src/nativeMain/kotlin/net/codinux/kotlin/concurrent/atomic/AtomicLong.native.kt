package net.codinux.kotlin.concurrent.atomic

import kotlin.concurrent.AtomicLong

actual class AtomicLong actual constructor(value: Long) {

    private val delegate = AtomicLong(value)

    actual fun get() = delegate.value

    actual fun set(newValue: Long) {
        delegate.value = newValue
    }

    actual fun incrementAndGet() = delegate.incrementAndGet()

    actual fun decrementAndGet() = delegate.decrementAndGet()

    actual fun addAndGet(delta: Long) = delegate.addAndGet(delta)

    actual fun getAndIncrement() = delegate.getAndIncrement()

    actual fun getAndDecrement() = delegate.getAndDecrement()

    actual fun getAndAdd(delta: Long) = delegate.getAndAdd(delta)

    override fun toString() = get().toString()

}