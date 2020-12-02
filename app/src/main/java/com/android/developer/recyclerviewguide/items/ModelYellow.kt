package com.android.developer.recyclerviewguide.items

import androidx.annotation.ColorRes

data class ModelYellow(@ColorRes val color: Int,
                       val name: String) : RecyclerAdapterItem {

    var onClick: (() -> Unit)? = null
}