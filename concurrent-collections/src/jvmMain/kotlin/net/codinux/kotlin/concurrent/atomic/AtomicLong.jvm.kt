package net.codinux.kotlin.concurrent.atomic

import java.util.concurrent.atomic.AtomicLong

actual class AtomicLong actual constructor(value: Long) {

    private val delegate = AtomicLong(value)


    actual fun get() = delegate.get()

    actual fun set(newValue: Long) = delegate.set(newValue)


    actual fun incrementAndGet() = delegate.incrementAndGet()

    actual fun decrementAndGet() = delegate.decrementAndGet()

    actual fun addAndGet(delta: Long) = delegate.addAndGet(delta)


    actual fun getAndIncrement() = delegate.getAndIncrement()

    actual fun getAndDecrement() = delegate.getAndDecrement()

    actual fun getAndAdd(delta: Long) = delegate.getAndAdd(delta)


    override fun toString() = delegate.toString()

}