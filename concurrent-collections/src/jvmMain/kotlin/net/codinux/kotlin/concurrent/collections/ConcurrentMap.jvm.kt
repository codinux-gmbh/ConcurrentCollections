package net.codinux.kotlin.concurrent.collections

import java.util.concurrent.ConcurrentHashMap

actual open class ConcurrentMap<K, V> : ConcurrentHashMap<K, V>(), Map<K, V>