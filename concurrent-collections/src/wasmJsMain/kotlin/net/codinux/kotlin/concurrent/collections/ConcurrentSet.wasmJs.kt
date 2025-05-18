package net.codinux.kotlin.concurrent.collections

/**
 * JavaScript has only one thread, so no need to take care of any thread-safety structures
 */
actual class ConcurrentSet<E> actual constructor() : Set<E> {

    private val impl = LinkedHashSet<E>() // LinkedHashSet is final in WASM so we cannot derive from it


    override val size: Int
        get() = impl.size

    override fun isEmpty() = impl.isEmpty()


    actual fun add(element: E): Boolean = impl.add(element)

    actual fun remove(element: E): Boolean = impl.remove(element)

    actual fun clear() {
        impl.clear()
    }


    override fun iterator() = impl.iterator()

    override fun contains(element: E): Boolean = impl.contains(element)

    override fun containsAll(elements: Collection<E>) = impl.containsAll(elements)

}