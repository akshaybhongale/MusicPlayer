package com.example.musicplayer.viewmodels

import android.util.Log
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.musicplayer.models.ApiResponse
import com.example.musicplayer.models.TopSongs
import com.example.musicplayer.repo.Repos
import com.example.musicplayer.utils.ERROR_CODE_501
import com.example.musicplayer.utils.ERROR_MSG_501
import com.example.musicplayer.utils.geNetworkError
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

/**
 * This class is used to deal with REST API call and Database operation
 *
 */
class DashboardViewModel @Inject constructor(private val repos: Repos) : ViewModel() {

    companion object {
        private val TAG = DashboardViewModel::class.java.simpleName
    }

    /**
     * Live data for showing list of songs on UI
     */
    val topSongs: MediatorLiveData<ApiResponse<TopSongs>> = MediatorLiveData()


    /**
     * This method is used to songs list from server
     */
    fun getSongList(
    ) {
        topSongs.addSource(makeNetworkCall()) {
            topSongs.postValue(it)
        }
    }


    /**
     * This method is used to make REST API call and Save data into local database
     */
    private fun makeNetworkCall() = liveData(Dispatchers.IO) {
        try {
            val result = repos.getTopSongs()
            repos.saveIntoDB(result)
            emit(ApiResponse.OnSuccess(result))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(geNetworkError(e))
        }
    }

    /**
     * This method is used to load song list from database and update UI
     */
    fun loadFromDB() {
        topSongs.addSource(getLocalDB()) {
            Log.d(TAG, "load from DB")
            topSongs.postValue(it)
        }
    }

    /**
     * This method is used to get song list from database
     */
    private fun getLocalDB() = liveData(Dispatchers.IO) {
        val result = repos.getSongListFromDB()
        if (result != null) {
            val topSongs = result.results
            if (topSongs != null) {
                emit(ApiResponse.OnSuccess(topSongs))
            } else {
                emit(ApiResponse.OnError(ERROR_CODE_501, ERROR_MSG_501))
            }
        } else {
            emit(ApiResponse.OnError(ERROR_CODE_501, ERROR_MSG_501))
        }
    }


}