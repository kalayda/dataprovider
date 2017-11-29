package com.itgrx.lib.dataprovider.container

import com.itgrx.lib.dataprovider.DataContainer

import java.util.ArrayList

/**
 *
 * Created by Алексей Калайда on 09.06.2017.
 */

class ListDataContainer<T> : DataContainer<T> {
    private val items: MutableList<T> = ArrayList()

    override fun size(): Int = items.size

    override fun add(item: T) {
        items.add(item)
    }

    override fun plusAssign(i: T) {
        add(i)
    }

    override fun add(i: Int, item: T) {
        items.add(i, item)
    }

    override fun add(items: Collection<T>) {
        this.items.addAll(items)
    }

    override fun plusAssign(items: Collection<T>) {
        add(items)
    }

    override fun remove(i: Int) {
        items.removeAt(i)
    }

    override operator fun get(i: Int): T? = items[i]

    override fun clear() {
        items.clear()
    }

    override fun iterator(): Iterator<T> = items.iterator()

}
