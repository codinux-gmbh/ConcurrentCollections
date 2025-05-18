package net.codinux.kotlin.concurrent.atomic

import java.util.concurrent.atomic.AtomicInteger

actual class AtomicInt actual constructor(value: Int) {

    private val impl = AtomicInteger(value)

    actual fun get() = impl.get()

    actual fun set(newValue: Int) = impl.set(newValue)

    actual fun incrementAndGet() = impl.incrementAndGet()

    actual fun decrementAndGet() = impl.decrementAndGet()

    actual fun addAndGet(delta: Int) = impl.addAndGet(delta)

    actual fun getAndIncrement() = impl.getAndIncrement()

    actual fun getAndDecrement() = impl.getAndDecrement()

    actual fun getAndAdd(delta: Int) = impl.getAndAdd(delta)

    override fun toString() = impl.toString()

}