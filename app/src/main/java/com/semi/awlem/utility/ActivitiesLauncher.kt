package com.semi.awlem.utility

import android.app.Activity
import android.content.Intent

object ActivitiesLauncher {

    fun Activity.loadActivity(newActivityClass: Class<*>, isGuest: Boolean? = false) {
        val intent = Intent(this, newActivityClass)
        intent.putExtra("isGuest", isGuest)
        this.startActivity(intent)
        this.finish()
    }
}

//
//fun startContactIntent(fragment: DataBindingFragment, it: Int) {
//    val intent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
//    fragment.startActivityForResult(intent, it)
//}