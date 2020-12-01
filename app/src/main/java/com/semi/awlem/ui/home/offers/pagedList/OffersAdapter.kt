package com.semi.awlem.ui.home.offers.pagedList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.semi.awlem.R
import com.semi.awlem.databinding.OfferRowItemBinding
import com.semi.entity.response.offer.OfferResponseData

class OffersAdapter(val listener: ClickListener) :
    PagedListAdapter<OfferResponseData, OffersAdapter.ViewHolder>(USER_COMPARATOR) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder.from(parent)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        item?.let { holder.bind(it, listener) }
    }


    class ViewHolder(val binding: OfferRowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        companion object {

            fun from(parent: ViewGroup): ViewHolder {
                return ViewHolder(
                    DataBindingUtil
                        .inflate(
                            LayoutInflater.from(parent.context),
                            R.layout.offer_row_item,
                            parent,
                            false
                        )
                )
            }

        }

        fun bind(offer: OfferResponseData, listener: ClickListener) {
            binding.offer = offer
            binding.clickListener = listener
            binding.executePendingBindings()
        }
    }


    companion object {
        private val USER_COMPARATOR = object : DiffUtil.ItemCallback<OfferResponseData>() {
            override fun areItemsTheSame(
                oldItem: OfferResponseData,
                newItem: OfferResponseData
            ): Boolean =
                newItem.id == oldItem.id

            override fun areContentsTheSame(
                oldItem: OfferResponseData,
                newItem: OfferResponseData
            ): Boolean =
                newItem == oldItem
        }
    }

    interface ClickListener {
        fun onRowClick(v: View, offer: OfferResponseData)
    }


}


