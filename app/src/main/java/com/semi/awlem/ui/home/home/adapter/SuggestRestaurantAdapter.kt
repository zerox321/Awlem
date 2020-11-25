package  com.semi.awlem.ui.home.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.semi.awlem.R
import com.semi.awlem.databinding.SuggestRestaurantRowItemBinding
import com.semi.entity.response.home.SuggestedRestaurantsResponse


class SuggestRestaurantAdapter(private val clickListener: ClickListener) :
    ListAdapter<SuggestedRestaurantsResponse, SuggestRestaurantAdapter.ViewHolder>(
        USER_COMPARATOR
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(
            parent
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).let { item: SuggestedRestaurantsResponse ->
            holder.bind(item, clickListener)
        }
    }


    class ViewHolder(val binding: SuggestRestaurantRowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                return ViewHolder(
                    DataBindingUtil
                        .inflate(
                            LayoutInflater.from(parent.context),
                            R.layout.suggest_restaurant_row_item,
                            parent,
                            false
                        )
                )
            }
        }

        fun bind(
            SuggestedRestaurants: SuggestedRestaurantsResponse,
            clickListener: ClickListener
        ) {
            binding.clickListener = clickListener
            binding.suggestedRestaurants = SuggestedRestaurants
            binding.executePendingBindings()
        }
    }

    companion object {
        private val USER_COMPARATOR =
            object : DiffUtil.ItemCallback<SuggestedRestaurantsResponse>() {
                override fun areItemsTheSame(
                    oldItem: SuggestedRestaurantsResponse,
                    newItem: SuggestedRestaurantsResponse
                ): Boolean =
                    newItem.id == oldItem.id

                override fun areContentsTheSame(
                    oldItem: SuggestedRestaurantsResponse,
                    newItem: SuggestedRestaurantsResponse
                ): Boolean =
                    newItem == oldItem
            }
    }

    interface ClickListener {
        fun onItemClick(v: View, car: SuggestedRestaurantsResponse)
    }
}


