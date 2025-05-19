package net.codinux.kotlin.concurrent.collections

import kotlin.concurrent.AtomicReference

actual open class ConcurrentSet<E> : MutableSet<E> {

    protected open val atomicSet = AtomicReference(mutableSetOf<E>())


    override val size: Int
        get() = atomicSet.value.size

    override fun isEmpty() = atomicSet.value.isEmpty()


    override fun add(element: E): Boolean {
        if (contains(element)) {
            return false
        }

        var result: Boolean

        do {
            val existing = atomicSet.value

            val updated = existing.toMutableSet()
            result = updated.add(element)
        } while (atomicSet.compareAndSet(existing, updated) == false)

        return result
    }

    override fun addAll(elements: Collection<E>): Boolean {
        var result: Boolean

        do {
            val existing = atomicSet.value

            val updated = existing.toMutableSet()
            result = updated.addAll(elements)
        } while (atomicSet.compareAndSet(existing, updated) == false)

        return result
    }

    override fun remove(element: E): Boolean {
        var removeResult: Boolean

        do {
            val existing = atomicSet.value

            val updated = existing.toMutableSet()
            removeResult = updated.remove(element)
        } while (atomicSet.compareAndSet(existing, updated) == false)

        return removeResult
    }

    override fun removeAll(elements: Collection<E>): Boolean {
        var result: Boolean

        do {
            val existing = atomicSet.value

            val updated = existing.toMutableSet()
            result = updated.removeAll(elements)
        } while (atomicSet.compareAndSet(existing, updated) == false)

        return result
    }

    override fun retainAll(elements: Collection<E>): Boolean {
        var result: Boolean

        do {
            val existing = atomicSet.value

            val updated = existing.toMutableSet()
            result = updated.retainAll(elements)
        } while (atomicSet.compareAndSet(existing, updated) == false)

        return result
    }

    override fun clear() {
        @Suppress("ControlFlowWithEmptyBody")
        while (atomicSet.compareAndSet(atomicSet.value, mutableSetOf()) == false) { }
    }


    override fun iterator() = atomicSet.value.iterator()

    override fun contains(element: E) = atomicSet.value.contains(element)

    override fun containsAll(elements: Collection<E>) = atomicSet.value.containsAll(elements)

}