package net.codinux.kotlin.concurrent.collections

actual class ConcurrentMap<K, V> actual constructor() {

    private val impl = LinkedHashMap<K, V>() // LinkedHashMap is final in WASM so we cannot derive from it


    actual val size: Int get() = impl.size

    actual fun isEmpty(): Boolean = impl.isEmpty()


    actual fun get(key: K): V? = impl[key]

    actual fun put(key: K, value: V): V? = impl.put(key, value)

    actual fun remove(key: K): V? = impl.remove(key)

    actual fun clear() {
        impl.clear()
    }

}