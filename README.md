# dataprovider
Library to make data sets independent from adapters

This library helps to store and operate with data sets in ModelView or Presenter level, attaching it to View on demand.
The primary case to use library - RecyclerView or ViewPager adapters.

Interfaces:
DataContainer - stores data (list, set, map, array, etc.)
DataProvider - observable, which generates events each time, when consumer manipulates data (add, remove, change)
ActiveContainer - combines both of above

Implemetations:
SimpleDataProvider - ActiveContainer based on any data container (ListDataContainer by default)
ArrayDataContainer, ListDataContainer, MapDataContainer - different container implementations

This library needs to be used in couple with androiddataprovider, set of classes to translate DataProvider events to appropriate adapters calls (notifyItemInserted, notifyDataSetChanged, etc.)

Example of usage:
___________________________________________________________________________________________________________________
In ModelView

val provider = SimpleDataProvider<String>()

fun attach(view: View) {
  ...
  view.attach(provider)
  ...
}

fun addString(s: String) {
  provider += s
}

___________________________________________________________________________________________________________________
In View

class MyAdapter(val provider: ActiveConntainer<String>) : RecyclerView.Adapter { 
  private val mDelegate: RecyclerViewDataProviderDelegate = RecyclerViewDataProviderDelegate(this, provider)
  ...
}
  
val rv: RecyclerView

fun attach(provider: ActiveConntainer<String>) {
  ...
  rv.setAdapter(MyAdapter(provider))
  ...
}
