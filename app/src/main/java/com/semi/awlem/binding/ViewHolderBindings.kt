package com.semi.awlem.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import timber.log.Timber


@BindingAdapter("bindingPostUrl")
fun bindingPostUrl(imageView: ImageView, path: String?) {
    val imageUrl = "http://192.168.1.4/olum/public/images/type/2/photo/Group%208523.png"
//    val imageUrl = "$resizedUrl$path"
    Timber.e("bindingPostUrl   $imageUrl")
    Glide.with(imageView.context)
        .load(imageUrl)
//        .apply(
//            RequestOptions.placeholderOf(R.drawable.car_placeholder)
//                .error(R.drawable.car_placeholder)
//        )
        .transition(DrawableTransitionOptions.withCrossFade())
        .diskCacheStrategy(DiskCacheStrategy.DATA)
        .into(imageView)
}


