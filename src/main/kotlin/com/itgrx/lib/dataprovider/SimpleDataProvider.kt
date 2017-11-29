package com.itgrx.lib.dataprovider

import com.itgrx.lib.dataprovider.container.ListDataContainer
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

open class SimpleDataProvider<T>(private val container: DataContainer<T> = ListDataContainer()) : ActiveContainer<T> {
    protected val updatesSubject: PublishSubject<DataProvider.Event> = PublishSubject.create()

    override fun updates(): Observable<DataProvider.Event> = updatesSubject

    override fun size(): Int = container.size()

    override fun add(item: T) {
        container.add(item)
        updatesSubject.onNext(DataProvider.Inserted(size() - 1, 1))
    }

    override fun plusAssign(i: T) {
        add(i)
    }

    override fun add(i: Int, item: T) {
        container.add(i, item)
        updatesSubject.onNext(DataProvider.Inserted(i, 1))
    }

    override fun add(items: Collection<T>) {
        val position = size()
        container.add(items)
        updatesSubject.onNext(DataProvider.Inserted(position, items.size))
    }

    override operator fun plusAssign(items: Collection<T>) {
        add(items)
    }

    override fun remove(i: Int) {
        container.remove(i)
        updatesSubject.onNext(DataProvider.Removed(i, 1))
    }

    override fun get(i: Int): T? = container[i]

    override fun clear() {
        container.clear()
        updatesSubject.onNext(DataProvider.AllChanged())
    }

    override fun iterator(): Iterator<T> = container.iterator()

}
