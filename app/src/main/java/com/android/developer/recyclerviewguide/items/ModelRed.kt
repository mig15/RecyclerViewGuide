package com.android.developer.recyclerviewguide.items

import androidx.annotation.ColorRes

data class ModelRed(@ColorRes val color: Int,
                    val name: String) : RecyclerAdapterItem {

    var onClick: (() -> Unit)? = null
}