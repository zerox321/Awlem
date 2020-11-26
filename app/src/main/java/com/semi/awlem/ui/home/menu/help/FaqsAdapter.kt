package  com.semi.awlem.ui.home.menu.help

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.semi.awlem.R
import com.semi.awlem.databinding.FaqRowItemBinding
import com.semi.entity.response.menu.FaqResponse


class FaqsAdapter(private val clickListener: ClickListener) :
    ListAdapter<FaqResponse, FaqsAdapter.ViewHolder>(
        USER_COMPARATOR
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(
            parent
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = getItem(position)
        user?.let { holder.bind(it, clickListener) }

    }


    class ViewHolder(private val binding: FaqRowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                return ViewHolder(
                    DataBindingUtil
                        .inflate(
                            LayoutInflater.from(parent.context),
                            R.layout.faq_row_item,
                            parent,
                            false
                        )
                )
            }
        }

        fun bind(
            faq: FaqResponse,
            clickListener: ClickListener,
        ) {
            binding.faq = faq

            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object {
        private val USER_COMPARATOR = object : DiffUtil.ItemCallback<FaqResponse>() {
            override fun areItemsTheSame(
                oldItem: FaqResponse,
                newItem: FaqResponse
            ): Boolean =
                newItem.id == oldItem.id

            override fun areContentsTheSame(
                oldItem: FaqResponse,
                newItem: FaqResponse
            ): Boolean =
                newItem == oldItem
        }
    }


    interface ClickListener {
        fun onItemClick(v: View, faq: FaqResponse)
    }
}


