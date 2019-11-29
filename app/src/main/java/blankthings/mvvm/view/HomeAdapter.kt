package blankthings.mvvm.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import blankthings.mvvm.R
import blankthings.mvvm.net.data.Data

class HomeAdapter(private val clickListener: (Data) -> Unit):
    ListAdapter<Data, RecyclerView.ViewHolder>(HomeDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return ItemDataViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemDataViewHolder).bind(getItem(position), clickListener)
    }


}