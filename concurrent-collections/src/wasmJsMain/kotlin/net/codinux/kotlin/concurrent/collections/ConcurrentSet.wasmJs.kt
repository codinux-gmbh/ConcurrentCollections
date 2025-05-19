package net.codinux.kotlin.concurrent.collections

/**
 * JavaScript has only one thread, so no need to take care of any thread-safety structures
 */
actual class ConcurrentSet<E> actual constructor() : MutableSet<E> {

    private val delegate = LinkedHashSet<E>() // LinkedHashSet is final in WASM so we cannot derive from it


    override val size: Int
        get() = delegate.size

    override fun isEmpty() = delegate.isEmpty()


    override fun add(element: E): Boolean = delegate.add(element)

    override fun addAll(elements: Collection<E>) = delegate.addAll(elements)

    override fun remove(element: E): Boolean = delegate.remove(element)

    override fun removeAll(elements: Collection<E>) = delegate.removeAll(elements)

    override fun retainAll(elements: Collection<E>) = delegate.retainAll(elements)

    override fun clear() {
        delegate.clear()
    }


    override fun iterator() = delegate.iterator()

    override fun contains(element: E): Boolean = delegate.contains(element)

    override fun containsAll(elements: Collection<E>) = delegate.containsAll(elements)

}