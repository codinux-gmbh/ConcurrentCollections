package net.codinux.kotlin.concurrent.collections

import kotlin.concurrent.AtomicReference

actual open class ConcurrentList<E> actual constructor() : AbstractMutableList<E>(), MutableList<E> {

    protected open val atomicList = AtomicReference(mutableListOf<E>())


    override val size: Int
        get() = atomicList.value.size


    override fun get(index: Int): E = atomicList.value[index]

    override fun add(index: Int, element: E) {
        do {
            val existing = atomicList.value

            val updated = existing.toMutableList()
            updated.add(index, element)
        } while (atomicList.compareAndSet(existing, updated) == false)
    }

    override fun set(index: Int, element: E): E {
        var result: E

        do {
            val existing = atomicList.value

            val updated = existing.toMutableList()
            result = updated.set(index, element)
        } while (atomicList.compareAndSet(existing, updated) == false)

        return result
    }

    override fun removeAt(index: Int): E {
        var result: E

        do {
            val existing = atomicList.value

            val updated = existing.toMutableList()
            result = updated.removeAt(index)
        } while (atomicList.compareAndSet(existing, updated) == false)

        return result
    }

}