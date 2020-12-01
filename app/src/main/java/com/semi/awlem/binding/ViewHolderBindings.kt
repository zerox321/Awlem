package com.semi.awlem.binding

import android.graphics.Color
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import android.webkit.WebView
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.semi.awlem.R
import com.semi.network.BuildConfig.resizedUrl
import timber.log.Timber
import java.util.*

@BindingAdapter("bindSlideView")
fun bindSlideView(view: View, isSlideUp: Boolean) {
    val animID = if (isSlideUp) R.anim.slide_up else R.anim.slide_down
    val lastVisibility = if (isSlideUp) View.VISIBLE else View.INVISIBLE
    view.visibility = View.INVISIBLE
    Looper.myLooper()?.let {
        Handler(it).postDelayed({
            view.startAnimation(AnimationUtils.loadAnimation(view.context, animID))
            view.visibility = lastVisibility
        }, 250)
    }


}

@BindingAdapter("bindingPostUrl")
fun bindingPostUrl(imageView: ImageView, path: String?) {
    val imageUrl = "$resizedUrl$path"
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

@BindingAdapter("bindingCirclePostUrl")
fun bindingCirclePostUrl(imageView: ImageView, path: String?) {
    if (path != null)
        Glide.with(imageView.context)
            .load("$resizedUrl$path")
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_profile_placeholder)
                    .error(R.drawable.ic_profile_placeholder)
            )
            .apply(RequestOptions().circleCrop())
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(imageView)
}

@BindingAdapter("loadHtml")
fun loadHtml(browser: WebView, text: String?) {
    browser.settings.javaScriptEnabled = true
    val isArabic = Locale.getDefault().language == "ar"
    val direction = if (isArabic) "rtl" else "ltr"
    browser.loadData(
        "<html dir=\"$direction\" lang=\"\"><body>$text</body></html>",
        "text/html; charset=utf-8",
        "UTF-8"
    )
    browser.setBackgroundColor(Color.TRANSPARENT)
}
