package net.codinux.kotlin.concurrent.atomic

import kotlin.concurrent.AtomicInt

actual class AtomicInt actual constructor(value: Int) {

    private val delegate = AtomicInt(value)


    actual fun get() = delegate.value

    actual fun set(newValue: Int) {
        delegate.value = newValue
    }


    actual fun incrementAndGet() = delegate.incrementAndGet()

    actual fun decrementAndGet() = delegate.decrementAndGet()

    actual fun addAndGet(delta: Int) = delegate.addAndGet(delta)


    actual fun getAndIncrement() = delegate.getAndIncrement()

    actual fun getAndDecrement() = delegate.getAndDecrement()

    actual fun getAndAdd(delta: Int): Int = delegate.getAndAdd(delta)


    override fun toString() = get().toString()

}