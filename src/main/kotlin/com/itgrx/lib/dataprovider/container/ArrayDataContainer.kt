package com.itgrx.lib.dataprovider.container

import com.itgrx.lib.dataprovider.DataContainer

import java.util.Arrays

/**
 *
 * Created by Алексей Калайда on 09.06.2017.
 */

class ArrayDataContainer<T>(private val items: Array<T?>) : DataContainer<T> {

    override fun size(): Int = items.size

    override fun add(item: T) {
        throw UnsupportedOperationException()
    }

    override fun plusAssign(i: T) {
        add(i)
    }

    override fun add(i: Int, item: T) {
        throw UnsupportedOperationException()
    }

    override fun add(items: Collection<T>) {
        throw UnsupportedOperationException()
    }

    override fun plusAssign(items: Collection<T>) {
        add(items)
    }

    override fun remove(i: Int) {
        items[i] = null
    }

    override operator fun get(i: Int): T? = items[i]

    override fun clear() {
        Arrays.fill(items, null)
    }

    override fun iterator(): Iterator<T> = object : Iterator<T> {

        var i = getNext(0)

        override fun hasNext(): Boolean = i == items.size

        override fun next(): T {
            if (!hasNext())
                throw IllegalStateException()
            val res = items[i]!!
            i = getNext(i)
            return res
        }

        private fun getNext(start: Int): Int {
            var i = start
            for (ii in start until items.size)
                if (items[i++] != null)
                    break;
            return i;
        }

    }

}
