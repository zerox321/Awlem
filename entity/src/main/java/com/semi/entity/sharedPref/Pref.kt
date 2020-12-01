package com.semi.entity.sharedPref

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.google.gson.Gson
import com.semi.entity.response.splash.LoginResponseData


class Pref constructor(private val context: Context, private val PREFNAME: String) {


    //    private val PREFLANGUAGE = "$PREFNAME.language"
    private val userKey = "user"
    private val NotificationTokenKey = "NotificationToken"
//    private val languageKey = "Language"


    fun clear() {
        val sharedPref = context.getSharedPreferences(PREFNAME, MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.clear()
        editor.apply()
    }

    fun getInt(key: String): Int {
        val prefs = context.getSharedPreferences(PREFNAME, MODE_PRIVATE)
        return prefs.getInt(key, 0)
    }

    fun setStr(key: String, value: String?) {
        val sharedPref = context.getSharedPreferences(PREFNAME, MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getStr(key: String): String? {
        val prefs = context.getSharedPreferences(PREFNAME, MODE_PRIVATE)
        return prefs.getString(key, "")
    }

//
//    fun setLanguage(value: String?) {
//        val sharedPref = context.getSharedPreferences(PREFLANGUAGE, MODE_PRIVATE)
//        val editor = sharedPref.edit()
//        editor.putString(languageKey, value)
//        editor.apply()
//    }
//
//    fun getLanguage(): String {
//        val prefs = context.getSharedPreferences(PREFLANGUAGE, MODE_PRIVATE)
//        return prefs.getString(languageKey, context.getString(R.string.language))
//            ?: context.getString(R.string.language)
//    }

    fun setNotificationToken(value: String?) {
        val sharedPref = context.getSharedPreferences(NotificationTokenKey, MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString(NotificationTokenKey, value)
        editor.apply()
    }

    fun getNotificationToken(): String {
        val prefs = context.getSharedPreferences(NotificationTokenKey, MODE_PRIVATE)
        return prefs.getString(NotificationTokenKey, " ") ?: ""
    }


    fun credentials(): String? =
        if (getUser()?.token != null) "Bearer ${getUser()?.token}" else null


    fun saveUser(response: LoginResponseData) {
        val userJson = Gson().toJson(response)
        setStr(userKey, userJson)

    }

    fun getUser(): LoginResponseData? {
        val userJson = getStr(userKey)
        return Gson().fromJson(userJson, LoginResponseData::class.java)

    }


}
