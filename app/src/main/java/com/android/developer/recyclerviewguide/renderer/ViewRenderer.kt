package com.android.developer.recyclerviewguide.renderer

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.developer.recyclerviewguide.items.RecyclerAdapterItem

abstract class ViewRenderer<M : RecyclerAdapterItem, VH : RecyclerView.ViewHolder> {

    abstract fun createViewHolder(parent: ViewGroup): VH

    abstract fun bindView(model: M, holder: VH)
}