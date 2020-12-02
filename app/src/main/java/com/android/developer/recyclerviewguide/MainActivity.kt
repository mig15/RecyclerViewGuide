package com.android.developer.recyclerviewguide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.developer.recyclerviewguide.items.ModelBlue
import com.android.developer.recyclerviewguide.items.ModelRed
import com.android.developer.recyclerviewguide.items.ModelYellow
import com.android.developer.recyclerviewguide.items.RecyclerAdapterItem
import com.android.developer.recyclerviewguide.renderer.RendererBlue
import com.android.developer.recyclerviewguide.renderer.RendererRed
import com.android.developer.recyclerviewguide.renderer.RendererYellow
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var adapter: SingleRecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = SingleRecyclerViewAdapter()
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)

        adapter?.registerRenderer(RendererBlue())
        adapter?.registerRenderer(RendererYellow())
        adapter?.registerRenderer(RendererRed())
        adapter?.notifyData(mapData())
    }

    private fun mapData(): List<RecyclerAdapterItem> {
        val data = arrayListOf<RecyclerAdapterItem>()

        val yellowModel = ModelYellow(color = R.color.yellow, name = "Yellow").apply {
            onClick = {
                //do something
            }
        }

        val blueModel = ModelBlue(color = R.color.blue, name = "Blue").apply {
            onClick = {
                //do something
            }
        }

        val redModel = ModelRed(color = R.color.red, name = "Red").apply {
            onClick = {
                //do something
            }
        }

        data.add(yellowModel)
        data.add(blueModel)
        data.add(redModel)

        return data
    }
}