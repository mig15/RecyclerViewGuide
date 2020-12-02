package com.android.developer.recyclerviewguide.renderer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import com.android.developer.recyclerviewguide.R
import com.android.developer.recyclerviewguide.holder.SimpleVH
import com.android.developer.recyclerviewguide.items.ModelBlue
import kotlinx.android.synthetic.main.item_blue.view.*

class RendererBlue : ViewRenderer<ModelBlue, SimpleVH>() {

    override fun createViewHolder(parent: ViewGroup): SimpleVH {
        return SimpleVH(LayoutInflater.from(parent.context).inflate(R.layout.item_blue, parent, false))
    }

    override fun bindView(model: ModelBlue, holder: SimpleVH) {
        holder.itemView.run {
            name.text = model.name
            container.setBackgroundColor(ResourcesCompat.getColor(resources, model.color, null))

            setOnClickListener { model.onClick?.invoke() }
        }
    }
}