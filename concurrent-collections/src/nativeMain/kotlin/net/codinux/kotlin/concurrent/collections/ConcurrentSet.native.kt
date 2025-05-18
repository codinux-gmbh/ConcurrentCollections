package net.codinux.kotlin.concurrent.collections

import kotlin.concurrent.AtomicReference

actual open class ConcurrentSet<E> : Set<E> {

    protected open val atomicSet = AtomicReference(setOf<E>())


    override val size: Int
        get() = atomicSet.value.size

    override fun isEmpty() = atomicSet.value.isEmpty()


    actual fun add(element: E): Boolean {
        if (contains(element)) {
            return false
        }

        do {
            val existing = atomicSet.value

            val updated = existing.toMutableSet()
            updated.add(element)
        } while (atomicSet.compareAndSet(existing, updated) == false)

        return true
    }

    actual fun remove(element: E): Boolean {
        var removeResult: Boolean

        do {
            val existing = atomicSet.value

            val updated = existing.toMutableSet()
            removeResult = updated.remove(element)
        } while (atomicSet.compareAndSet(existing, updated) == false)

        return removeResult
    }

    actual fun clear() {
        @Suppress("ControlFlowWithEmptyBody")
        while (atomicSet.compareAndSet(atomicSet.value, setOf()) == false) { }
    }


    override fun iterator() = atomicSet.value.iterator()

    override fun contains(element: E) = atomicSet.value.contains(element)

    override fun containsAll(elements: Collection<E>) = atomicSet.value.containsAll(elements)

}