package com.example.musicplayer.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.example.musicplayer.models.ApiResponse
import com.example.musicplayer.models.topsongs.Link
import com.example.musicplayer.models.topsongs.imimage.ImImage
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException


/**
 * This method is used to check internet connection available or not
 * @param context context of application
 * @return status of network connection
 */
fun isConnectedToInternet(context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                    return true
                }
            }
        }
    } else {
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
            return true
        }
    }
    return false
}

/**
 * This method is used to parse network error
 * @param e exception
 * @return error code with error message
 */
fun geNetworkError(e: Exception): ApiResponse.OnError {
    when (e) {
        is SocketTimeoutException -> {
            return ApiResponse.OnError(ERROR_CODE_401, ERROR_MSG_401)
        }
        is UnknownHostException -> {
            return ApiResponse.OnError(ERROR_CODE_500, ERROR_MSG_500)
        }
        is ConnectException -> {
            return ApiResponse.OnError(ERROR_CODE_402, ERROR_MSG_402)
        }
        is IOException -> {
            return ApiResponse.OnError(ERROR_CODE_403, ERROR_MSG_403)
        }
        else -> {
            return ApiResponse.OnError(ERROR_CODE_400, ERROR_MSG_400)
        }
    }
}

/**
 * This method is used to image height as per ratio
 * @param context context of application
 * @return height of imageview
 */
fun getImageHeight(context: Context, imageHeight: Int): Int {
    val displayMetrics = context.resources.displayMetrics
    return ((displayMetrics.widthPixels * imageHeight) / IMAGE_WIDTH_RATIO)
}

/**
 * This method is used to get image url from list
 * @param list list of image content
 */
fun getImageLink(list: List<ImImage>?): String {
    var link = ""
    var maxHeight = 0
    if (list.isNullOrEmpty()) {
        return link
    }
    for (imImage in list) {
        val currentHeight = imImage.attributes?.height ?: 0
        if (maxHeight < currentHeight) {
            maxHeight = currentHeight
            link = imImage.label ?: ""
        }
    }
    return link
}

/**
 * This method is used to audio link url to play track
 * @param list list of hyperlink
 */
fun getAudioLink(list: List<Link>?): String {
    var url = ""
    if (list.isNullOrEmpty()) {
        return url
    }
    for (link: Link in list) {
        val type = link.attributes?.type ?: ""
        if (type == KEY_MEDIA_AUDIO_TYPE) {
            url = link.attributes?.href ?: ""
        }
    }
    return url
}