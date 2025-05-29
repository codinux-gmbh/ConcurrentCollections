package net.codinux.kotlin.concurrent.collections

actual open class ConcurrentList<E> actual constructor() : AbstractMutableList<E>(), MutableList<E> {

    private val delegate = mutableListOf<E>()


    override val size: Int
        get() = delegate.size


    override fun get(index: Int) = delegate[index]

    override fun add(index: Int, element: E) = delegate.add(index, element)

    override fun set(index: Int, element: E) = delegate.set(index, element)

    override fun removeAt(index: Int) = delegate.removeAt(index)

}