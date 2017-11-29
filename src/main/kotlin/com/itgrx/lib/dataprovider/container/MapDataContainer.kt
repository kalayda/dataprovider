package com.itgrx.lib.dataprovider.container

import com.itgrx.lib.dataprovider.DataContainer
import java.util.HashMap

/**
 *
 * Created by Алексей Калайда on 09.06.2017.
 */

class MapDataContainer<V> : DataContainer<V> {
    private val items: MutableMap<Int, V> = HashMap()

    override fun size(): Int = items.size

    override fun add(item: V) {
        throw UnsupportedOperationException()
    }

    override fun plusAssign(i: V) {
        add(i)
    }

    override fun add(i: Int, item: V) {
        items.put(i, item)
    }

    override fun add(items: Collection<V>) {
        throw UnsupportedOperationException()
    }

    override fun plusAssign(items: Collection<V>) {
        add(items)
    }

    override fun remove(i: Int) {
        items.remove(i)
    }

    override operator fun get(i: Int): V? = items[i]

    override fun clear() {
        items.clear()
    }

    override fun iterator(): Iterator<V>  = items.values.iterator()

}
