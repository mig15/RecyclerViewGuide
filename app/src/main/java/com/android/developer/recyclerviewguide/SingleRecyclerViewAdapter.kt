package com.android.developer.recyclerviewguide

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.developer.recyclerviewguide.items.RecyclerAdapterItem
import com.android.developer.recyclerviewguide.renderer.ViewRenderer
import kotlin.reflect.KClassifier

class SingleRecyclerViewAdapter(private val data: MutableList<RecyclerAdapterItem> = arrayListOf()) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val rendererArray = LinkedHashMap<KClassifier, ViewRenderer<RecyclerAdapterItem, RecyclerView.ViewHolder>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val renderer = rendererArray.values.elementAt(viewType)
        return renderer.createViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        rendererArray[item::class]?.bindView(item, holder)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return rendererArray.keys.indexOfFirst { it == item::class }
    }

    fun <M : RecyclerAdapterItem, VH : RecyclerView.ViewHolder> registerRenderer(renderer: ViewRenderer<M, VH>) {
        renderer as ViewRenderer<RecyclerAdapterItem, RecyclerView.ViewHolder>
        val classfiler = renderer::class.supertypes.flatMap { it.arguments }.first().type?.classifier!!
        rendererArray[classfiler] = renderer
    }

    fun notifyData(list: List<RecyclerAdapterItem>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    fun getData() = data

    private fun getItem(position: Int) = data[position]
}