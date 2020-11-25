package com.semi.awlem.utility

import com.semi.awlem.R
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException


fun handleThrowable(throwable: Throwable): Int {
    return when (throwable) {
        is IOException -> R.string.internetError
        is SocketTimeoutException -> R.string.badInternet
        is HttpException -> {
            return when {
                throwable.code() == 401 -> R.string.invalidToken
                throwable.code() == 500 -> R.string.server_error
                else -> throwable.code()
            }
        }
        else -> R.string.internetError
    }
}