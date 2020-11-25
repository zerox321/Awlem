package  com.semi.awlem.ui.home.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.semi.awlem.R
import com.semi.awlem.databinding.SuggestProductRowItemBinding
import com.semi.entity.response.home.SuggestedProducts


class SuggestProductsAdapter(private val clickListener: ClickListener) :
    ListAdapter<SuggestedProducts, SuggestProductsAdapter.ViewHolder>(
        USER_COMPARATOR
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(
            parent
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).let { item: SuggestedProducts ->
            holder.bind(item, clickListener)
        }
    }


    class ViewHolder(val binding: SuggestProductRowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                return ViewHolder(
                    DataBindingUtil
                        .inflate(
                            LayoutInflater.from(parent.context),
                            R.layout.suggest_product_row_item,
                            parent,
                            false
                        )
                )
            }
        }

        fun bind(
            suggestedProducts: SuggestedProducts,
            clickListener: ClickListener
        ) {
            binding.clickListener = clickListener
            binding.suggestedProducts = suggestedProducts
            binding.executePendingBindings()
        }
    }

    companion object {
        private val USER_COMPARATOR = object : DiffUtil.ItemCallback<SuggestedProducts>() {
            override fun areItemsTheSame(
                oldItem: SuggestedProducts,
                newItem: SuggestedProducts
            ): Boolean =
                newItem.id == oldItem.id

            override fun areContentsTheSame(
                oldItem: SuggestedProducts,
                newItem: SuggestedProducts
            ): Boolean =
                newItem == oldItem
        }
    }

    interface ClickListener {
        fun onItemClick(v: View, car: SuggestedProducts)
    }
}


