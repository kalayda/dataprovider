package com.itgrx.lib.dataprovider

interface DataContainer<T> : Iterable<T> {

    fun size(): Int
    fun add(item: T)
    operator fun plusAssign(i: T)
    fun add(i: Int, item: T)
    fun add(items: Collection<T>)
    operator fun plusAssign(items: Collection<T>)
    fun remove(i: Int)
    operator fun get(i: Int): T?
    fun clear()

}