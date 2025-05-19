package net.codinux.kotlin.concurrent.collections

import kotlin.concurrent.AtomicReference

actual open class ConcurrentMap<K, V>: MutableMap<K, V> {

    protected open val atomicMap = AtomicReference(mutableMapOf<K, V>())


    actual override val size: Int
        get() = atomicMap.value.size

    actual override fun isEmpty(): Boolean = atomicMap.value.isEmpty()


    actual override fun get(key: K): V? =
        atomicMap.value[key]

    actual override fun put(key: K, value: V): V? {
        val previousValue = get(key)

        do {
            val existing = atomicMap.value

            val updated = existing.toMutableMap()
            updated[key] = value
        } while (atomicMap.compareAndSet(existing, updated) == false)

        return previousValue
    }

    override fun putAll(from: Map<out K, V>) {
        do {
            val existing = atomicMap.value

            val updated = existing.toMutableMap()
            updated.putAll(from)
        } while (atomicMap.compareAndSet(existing, updated) == false)
    }

    actual override fun remove(key: K): V? {
        var previousValue: V?

        do {
            val existing = atomicMap.value

            val updated = existing.toMutableMap()
            previousValue = updated.remove(key)
        } while (atomicMap.compareAndSet(existing, updated) == false)

        return previousValue
    }

    actual override fun clear() {
        @Suppress("ControlFlowWithEmptyBody")
        while (atomicMap.compareAndSet(atomicMap.value, mutableMapOf()) == false) { }
    }


    override val entries: MutableSet<MutableMap.MutableEntry<K, V>>
        get() = atomicMap.value.entries

    override val keys: MutableSet<K>
        get() = atomicMap.value.keys

    override val values: MutableCollection<V>
        get() = atomicMap.value.values

    override fun containsKey(key: K) = atomicMap.value.containsKey(key)

    override fun containsValue(value: V) = atomicMap.value.containsValue(value)

}