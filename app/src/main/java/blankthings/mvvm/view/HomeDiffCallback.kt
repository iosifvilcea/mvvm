package blankthings.mvvm.view

import androidx.recyclerview.widget.DiffUtil
import blankthings.mvvm.net.data.Data

class HomeDiffCallback: DiffUtil.ItemCallback<Data>() {
    override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem == newItem
    }
}