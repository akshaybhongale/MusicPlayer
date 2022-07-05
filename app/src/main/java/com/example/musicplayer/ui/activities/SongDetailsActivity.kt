package com.example.musicplayer.ui.activities

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.musicplayer.R
import com.example.musicplayer.databinding.ActivitySongDetailsBinding
import com.example.musicplayer.models.topsongs.Entry
import com.example.musicplayer.utils.*
import com.google.android.material.snackbar.Snackbar

/**
 * This class is used to display details of song and play audio for selected song on UI
 */
class SongDetailsActivity : AppCompatActivity() {

    companion object {
        private val TAG = SongDetailsActivity::class.java.simpleName
    }

    private lateinit var mBinding: ActivitySongDetailsBinding

    /**
     * Reference for intent data
     */
    private var mSongDetails: Entry? = null

    /**
     * Reference for media player
     */
    private var mediaPlayer: MediaPlayer = MediaPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySongDetailsBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        setSupportActionBar(mBinding.toolbarSongsDetails)
        mBinding.toolbarSongsDetails.setNavigationOnClickListener {
            finish()
        }
        mSongDetails = intent.getParcelableExtra(SELECTED_SONG)
        mSongDetails?.let {
            mBinding.contentSongs.txtAuthor.text = it.imArtist?.label
            mBinding.contentSongs.txtSongName.text = it.imName?.label
            mBinding.contentSongs.txtSongDetails.text = getString(R.string.song_details,
                it.category?.attributes?.label,
                it.imContentType?.contentAttributes?.label,
                it.imPrice?.label)
            setImageView(entry = it)
            playMusic(entry = it)
        }

    }

    /**
     * This method is used to load Image resource in ImageView
     */
    private fun setImageView(entry: Entry) {
        val layoutParam = mBinding.contentSongs.ivSelectedSong.layoutParams
        layoutParam.height = getImageHeight(applicationContext, IMAGE_HEIGHT_RATIO)
        mBinding.contentSongs.ivSelectedSong.layoutParams = layoutParam
        val imageUrl = getImageLink(entry.imAttributes)
        Glide.with(mBinding.root.context)
            .applyDefaultRequestOptions(
                RequestOptions.centerCropTransform()
                    .placeholder(R.drawable.ic_launcher_background))
            .load(imageUrl).into(mBinding.contentSongs.ivSelectedSong)
    }


    /**
     * This method is used to handle audio play/pause operation
     * @param entry audio link details for playing a song
     */
    private fun playMusic(entry: Entry) {
        val audioLink = getAudioLink(entry.link)
        if (!isConnectedToInternet(applicationContext)) {
            mBinding.contentSongs.ivSongTrack.setBackgroundResource(R.drawable.ic_song_play_disable)
            Snackbar.make(mBinding.root,
                getString(R.string.no_internet_connection),
                Snackbar.LENGTH_LONG).show()
            return
        }
        try {
            Log.d(TAG, "play music $audioLink")
            mediaPlayer.setDataSource(audioLink)
            mediaPlayer.setOnPreparedListener {
                mediaPlayer.start()
                mBinding.contentSongs.ivSongTrack.setBackgroundResource(R.drawable.ic_song_stop)
            }
            mediaPlayer.prepareAsync()

            mBinding.contentSongs.ivSongTrack.setOnClickListener {
                try {
                    if (mediaPlayer.isPlaying) {
                        mediaPlayer.stop()
                        mediaPlayer.reset()
                        mBinding.contentSongs.ivSongTrack.setBackgroundResource(R.drawable.ic_song_play)
                    } else {
                        mediaPlayer.setDataSource(audioLink)
                        mediaPlayer.prepareAsync()
                        mBinding.contentSongs.ivSongTrack.setBackgroundResource(R.drawable.ic_song_stop)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onDestroy() {
        mediaPlayer.stop()
        mediaPlayer.reset()
        mediaPlayer.release()
        super.onDestroy()

    }

}