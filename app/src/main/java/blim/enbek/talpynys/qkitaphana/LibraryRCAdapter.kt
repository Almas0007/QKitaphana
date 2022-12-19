package blim.enbek.talpynys.qkitaphana

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil

import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import blim.enbek.talpynys.qkitaphana.fragment.CRUDFragment
import blim.enbek.talpynys.qkitaphana.fragment.HomeFragment


class LibraryRCAdapter(private val buttonClick:CRUDFragment): ListAdapter<DataLibraryClass,LibraryRCAdapter.ViewHolder>(DiffCallback()){


    private class DiffCallback : DiffUtil.ItemCallback<DataLibraryClass>() {
        override fun areItemsTheSame(oldItem: DataLibraryClass, newItem: DataLibraryClass): Boolean {
            return oldItem.nameLibrary == newItem.nameLibrary
        }

        override fun areContentsTheSame(oldItem: DataLibraryClass, newItem: DataLibraryClass): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_crud, parent, false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position),buttonClick)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val text = itemView.findViewById(R.id.itemQText) as TextView
        private val address = itemView.findViewById(R.id.itemQAddress) as TextView
        private val rating = itemView.findViewById(R.id.itemQRating) as TextView
        private val buttonDelete = itemView.findViewById(R.id.itemQButtonDelete) as Button
        private val itemRC = itemView.findViewById(R.id.itemQ_rc_id) as ConstraintLayout
        fun bind(item: DataLibraryClass,buttonClick: OnClick) {
            text.text = item.nameLibrary
            address.text = item.addressLibrary
            rating.text = item.ratingLibrary.toString()

            buttonDelete.setOnClickListener {
                buttonClick.onItemDelete(absoluteAdapterPosition)
            }

            itemRC.setOnClickListener{
                buttonClick.onItemEdit(absoluteAdapterPosition)
            }

        }
    }

    interface OnClick {
        fun onItemEdit(position: Int)

        fun onItemDelete(position: Int)
    }

}

