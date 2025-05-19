package net.codinux.kotlin.concurrent.collections

actual class ConcurrentMap<K, V> actual constructor() : MutableMap<K, V> {

    private val impl = LinkedHashMap<K, V>() // LinkedHashMap is final in WASM so we cannot derive from it


    actual override val size: Int get() = impl.size

    actual override fun isEmpty(): Boolean = impl.isEmpty()


    actual override fun get(key: K): V? = impl[key]

    actual override fun put(key: K, value: V): V? = impl.put(key, value)

    override fun putAll(from: Map<out K, V>) = impl.putAll(from)

    actual override fun remove(key: K): V? = impl.remove(key)

    actual override fun clear() {
        impl.clear()
    }


    override val entries: MutableSet<MutableMap.MutableEntry<K, V>>
        get() = impl.entries

    override val keys: MutableSet<K>
        get() = impl.keys

    override val values: MutableCollection<V>
        get() = impl.values

    override fun containsKey(key: K) = impl.containsKey(key)

    override fun containsValue(value: V) = impl.containsValue(value)

}