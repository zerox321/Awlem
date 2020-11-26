package com.semi.awlem.base

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.semi.awlem.utility.LangUtil.setLanguage
import java.util.*


@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

//    @Inject
//    lateinit var pref: Pref

    private val language: String
        get() {
            return "ar"
        }

    protected inline fun <reified T : ViewDataBinding> binding(
        @LayoutRes resId: Int
    ): Lazy<T> = lazy { DataBindingUtil.setContentView<T>(this, resId) }

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        setLanguage(language)
        super.onCreate(savedInstanceState)

    }

    override fun onResume() {
        super.onResume()
        val lang = Locale.getDefault().language
        if (lang != language)
            setLanguage(language)

    }


}
