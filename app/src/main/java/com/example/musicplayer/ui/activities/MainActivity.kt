package com.example.musicplayer.ui.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicplayer.App
import com.example.musicplayer.databinding.ActivityMainBinding
import com.example.musicplayer.models.ApiResponse
import com.example.musicplayer.models.topsongs.Entry
import com.example.musicplayer.ui.adapter.SongListAdapter
import com.example.musicplayer.utils.isConnectedToInternet
import com.example.musicplayer.viewmodels.DashboardViewModel
import com.example.musicplayer.viewmodels.ViewModelFactory
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

/**
 * This class is used to load songs list from Server/database on UI
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var mViewModelFactory: ViewModelFactory

    private val mDashboardViewModel: DashboardViewModel by viewModels() {
        mViewModelFactory
    }


    /**
     * To maintain songs list data from server
     */
    private val mSongList = ArrayList<Entry>()

    /**
     * To load song list data in recyclerview
     */
    private val mSongListAdapter = SongListAdapter(mSongList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as App).appComponent.inject(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        initView()
        loadDataSet()
    }

    /**
     * This method is used to initialize View
     */
    private fun initView() {
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        binding.content.recyclerView.apply {
            adapter = mSongListAdapter
            layoutManager = linearLayoutManager
        }
    }

    /**
     * This method is used to populate songs list on UI
     */
    private fun loadDataSet() {
        binding.content.progressbar.visibility = View.VISIBLE

        if (isConnectedToInternet(applicationContext)) {
            mDashboardViewModel.getSongList()
        } else {
            mDashboardViewModel.loadFromDB()
        }
        mDashboardViewModel.topSongs.observe(this, {
            Log.d("MainActivity", "onResponse")
            binding.content.progressbar.visibility = View.GONE
            it.let {
                when (it) {
                    is ApiResponse.OnSuccess -> {
                        val list = it.result.feed.entry ?: ArrayList()
                        mSongList.addAll(list)
                        mSongListAdapter.update(mSongList)
                    }
                    is ApiResponse.OnError -> {
                        Snackbar.make(binding.root, it.errorMsg, Snackbar.LENGTH_LONG).show()
                    }
                }
            }

        })
    }
}