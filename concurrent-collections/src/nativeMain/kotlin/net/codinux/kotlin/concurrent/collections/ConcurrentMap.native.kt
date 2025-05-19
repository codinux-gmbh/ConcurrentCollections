package net.codinux.kotlin.concurrent.collections

import kotlin.concurrent.AtomicReference

actual open class ConcurrentMap<K, V>: Map<K, V> {

    protected open val atomicMap = AtomicReference(mapOf<K, V>())


    actual override val size: Int
        get() = atomicMap.value.size

    actual override fun isEmpty(): Boolean = atomicMap.value.isEmpty()


    actual override fun get(key: K): V? =
        atomicMap.value[key]

    actual open fun put(key: K, value: V): V? {
        val previousValue = get(key)

        do {
            val existing = atomicMap.value

            val updated = existing.toMutableMap()
            updated[key] = value
        } while (atomicMap.compareAndSet(existing, updated) == false)

        return previousValue
    }

    actual open fun remove(key: K): V? {
        var previousValue: V?

        do {
            val existing = atomicMap.value

            val updated = existing.toMutableMap()
            previousValue = updated.remove(key)
        } while (atomicMap.compareAndSet(existing, updated) == false)

        return previousValue
    }

    actual open fun clear() {
        @Suppress("ControlFlowWithEmptyBody")
        while (atomicMap.compareAndSet(atomicMap.value, mapOf()) == false) { }
    }


    override val entries: Set<Map.Entry<K, V>>
        get() = atomicMap.value.entries

    override val keys: Set<K>
        get() = atomicMap.value.keys

    override val values: Collection<V>
        get() = atomicMap.value.values

    override fun containsKey(key: K) = atomicMap.value.containsKey(key)

    override fun containsValue(value: V) = atomicMap.value.containsValue(value)

}