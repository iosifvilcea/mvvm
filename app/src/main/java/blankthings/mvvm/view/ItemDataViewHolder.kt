package blankthings.mvvm.view

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import blankthings.mvvm.R
import blankthings.mvvm.net.data.Data

class ItemDataViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val titleView = itemView.findViewById<AppCompatTextView>(R.id.item_data_title)
    private val descriptionView = itemView.findViewById<AppCompatTextView>(R.id.item_data_description)

    fun bind(data: Data, callback: (Data) -> Unit) {
        titleView.text = data.title
        descriptionView.text = data.description
        itemView.setOnClickListener { callback.invoke(data) }
    }

}