package net.codinux.kotlin.concurrent.collections

actual class ConcurrentMap<K, V> actual constructor() : MutableMap<K, V> {

    private val delegate = LinkedHashMap<K, V>() // LinkedHashMap is final in WASM so we cannot derive from it


    override val size: Int get() = delegate.size

    override fun isEmpty(): Boolean = delegate.isEmpty()


    override fun get(key: K): V? = delegate[key]

    override fun put(key: K, value: V): V? = delegate.put(key, value)

    override fun putAll(from: Map<out K, V>) = delegate.putAll(from)

    override fun remove(key: K): V? = delegate.remove(key)

    override fun clear() {
        delegate.clear()
    }


    override val entries: MutableSet<MutableMap.MutableEntry<K, V>>
        get() = delegate.entries

    override val keys: MutableSet<K>
        get() = delegate.keys

    override val values: MutableCollection<V>
        get() = delegate.values

    override fun containsKey(key: K) = delegate.containsKey(key)

    override fun containsValue(value: V) = delegate.containsValue(value)

}