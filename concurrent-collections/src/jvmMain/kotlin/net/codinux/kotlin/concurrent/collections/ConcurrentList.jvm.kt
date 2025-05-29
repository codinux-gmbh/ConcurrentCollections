package net.codinux.kotlin.concurrent.collections

import java.util.concurrent.CopyOnWriteArrayList

actual open class ConcurrentList<E> actual constructor() : CopyOnWriteArrayList<E>(), MutableList<E>