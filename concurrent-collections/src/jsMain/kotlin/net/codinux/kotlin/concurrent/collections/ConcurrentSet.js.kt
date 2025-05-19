package net.codinux.kotlin.concurrent.collections

/**
 * JavaScript has only one thread, so no need to take care of any thread-safety structures
 */
actual open class ConcurrentSet<E> : LinkedHashSet<E>(), MutableSet<E>