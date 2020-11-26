package com.semi.awlem.ui.home.menu

import android.os.Bundle
import android.view.View
import com.semi.awlem.R
import com.semi.awlem.base.BaseViewModel
import com.semi.awlem.utility.ContextConverter.getActivity
import com.semi.awlem.utility.NavigationUtil.findNavigationController
import com.semi.awlem.utility.NavigationUtil.navigateTo
import com.semi.awlem.utility.dialog.ImageSelectorUtil.showImageSelectorDialog
import java.io.File

class MenuViewModel : BaseViewModel() {
    fun onProfileClick(v: View) {
        val activity = v.context.getActivity()
        activity?.showImageSelectorDialog(onSuccess = { file: File? -> })

    }

    fun staticClick(v: View, pageTitle: String, pageID: Int) {
        v.findNavigationController().navigateTo(
            id = R.id.action_navigation_more_to_StaticPageFragment,
            args = Bundle().apply {
                putInt("pageID", pageID)
                putString("pageTitle", pageTitle)
            }
        )

    }

}