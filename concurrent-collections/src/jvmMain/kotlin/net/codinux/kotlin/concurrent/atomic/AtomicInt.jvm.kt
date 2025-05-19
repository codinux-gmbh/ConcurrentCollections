package net.codinux.kotlin.concurrent.atomic

import java.util.concurrent.atomic.AtomicInteger

actual class AtomicInt actual constructor(value: Int) {

    private val delegate = AtomicInteger(value)


    actual fun get() = delegate.get()

    actual fun set(newValue: Int) = delegate.set(newValue)


    actual fun incrementAndGet() = delegate.incrementAndGet()

    actual fun decrementAndGet() = delegate.decrementAndGet()

    actual fun addAndGet(delta: Int) = delegate.addAndGet(delta)


    actual fun getAndIncrement() = delegate.getAndIncrement()

    actual fun getAndDecrement() = delegate.getAndDecrement()

    actual fun getAndAdd(delta: Int) = delegate.getAndAdd(delta)


    override fun toString() = delegate.toString()

}