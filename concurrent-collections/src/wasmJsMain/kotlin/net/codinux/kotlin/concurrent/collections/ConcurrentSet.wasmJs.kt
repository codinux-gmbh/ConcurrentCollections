package net.codinux.kotlin.concurrent.collections

/**
 * JavaScript has only one thread, so no need to take care of any thread-safety structures
 */
actual class ConcurrentSet<E> actual constructor() : MutableSet<E> {

    private val impl = LinkedHashSet<E>() // LinkedHashSet is final in WASM so we cannot derive from it


    override val size: Int
        get() = impl.size

    override fun isEmpty() = impl.isEmpty()


    override fun add(element: E): Boolean = impl.add(element)

    override fun addAll(elements: Collection<E>) = impl.addAll(elements)

    override fun remove(element: E): Boolean = impl.remove(element)

    override fun removeAll(elements: Collection<E>) = impl.removeAll(elements)

    override fun retainAll(elements: Collection<E>) = impl.retainAll(elements)

    override fun clear() {
        impl.clear()
    }


    override fun iterator() = impl.iterator()

    override fun contains(element: E): Boolean = impl.contains(element)

    override fun containsAll(elements: Collection<E>) = impl.containsAll(elements)

}