package net.codinux.kotlin.concurrent.atomic

import kotlin.concurrent.AtomicInt

actual class AtomicInt actual constructor(value: Int) {

    private val impl = AtomicInt(value)

    actual fun get() = impl.value

    actual fun set(newValue: Int) {
        impl.value = newValue
    }

    actual fun incrementAndGet() = impl.incrementAndGet()

    actual fun decrementAndGet() = impl.decrementAndGet()

    actual fun addAndGet(delta: Int) = impl.addAndGet(delta)

    actual fun getAndIncrement() = impl.getAndIncrement()

    actual fun getAndDecrement() = impl.getAndDecrement()

    actual fun getAndAdd(delta: Int): Int = impl.getAndAdd(delta)

    override fun toString() = get().toString()

}