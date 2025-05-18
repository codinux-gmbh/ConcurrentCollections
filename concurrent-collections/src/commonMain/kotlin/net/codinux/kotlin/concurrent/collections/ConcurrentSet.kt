package net.codinux.kotlin.concurrent.collections

expect class ConcurrentSet<E>() : Set<E> {

    fun add(element: E): Boolean

    fun remove(element: E): Boolean

    fun clear()

}