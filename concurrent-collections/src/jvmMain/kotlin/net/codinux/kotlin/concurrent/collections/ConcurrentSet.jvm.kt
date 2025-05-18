package net.codinux.kotlin.concurrent.collections

import java.util.concurrent.CopyOnWriteArraySet

actual open class ConcurrentSet<E> : CopyOnWriteArraySet<E>(), Set<E>