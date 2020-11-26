package  com.semi.awlem.ui.home.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.semi.awlem.R
import com.semi.awlem.databinding.CategoryRowItemBinding
import com.semi.entity.database.categoryController.CategoryEntity


class CategoryAdapter(private val clickListener: ClickListener) :
    ListAdapter<CategoryEntity, CategoryAdapter.ViewHolder>(
        USER_COMPARATOR
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(
            parent
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).let { item: CategoryEntity ->
            holder.bind(item, clickListener)
        }
    }


    class ViewHolder(val binding: CategoryRowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                return ViewHolder(
                    DataBindingUtil
                        .inflate(
                            LayoutInflater.from(parent.context),
                            R.layout.category_row_item,
                            parent,
                            false
                        )
                )
            }
        }

        fun bind(
            Category: CategoryEntity,
            clickListener: ClickListener
        ) {
            binding.clickListener = clickListener
            binding.category = Category
            binding.executePendingBindings()
        }
    }

    companion object {
        private val USER_COMPARATOR = object : DiffUtil.ItemCallback<CategoryEntity>() {
            override fun areItemsTheSame(
                oldItem: CategoryEntity,
                newItem: CategoryEntity
            ): Boolean =
                newItem.id == oldItem.id

            override fun areContentsTheSame(
                oldItem: CategoryEntity,
                newItem: CategoryEntity
            ): Boolean =
                newItem == oldItem
        }
    }

    interface ClickListener {
        fun onItemClick(v: View, car: CategoryEntity)
    }
}


