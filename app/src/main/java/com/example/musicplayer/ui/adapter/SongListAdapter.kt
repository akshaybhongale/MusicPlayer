package com.example.musicplayer.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.musicplayer.R
import com.example.musicplayer.databinding.AdapterSongListBinding
import com.example.musicplayer.models.topsongs.Entry
import com.example.musicplayer.ui.activities.SongDetailsActivity
import com.example.musicplayer.utils.SELECTED_SONG

/**
 * This class is used to load list of song data in recycler view
 */
class SongListAdapter(characterList: ArrayList<Entry>) :
    RecyclerView.Adapter<SongListAdapter.SongsViewHolder>() {

    private var mList = ArrayList<Entry>()

    init {
        mList = characterList
    }

    inner class SongsViewHolder(private val holder: AdapterSongListBinding) :
        RecyclerView.ViewHolder(holder.root), View.OnClickListener {
        init {
            holder.root.setOnClickListener(this)
        }

        fun bind(results: Entry) {
            results.let {
                holder.txtSongName.text = it.imName?.label
                Glide.with(holder.root.context)
                    .applyDefaultRequestOptions(RequestOptions.circleCropTransform()
                        .placeholder(R.drawable.ic_launcher_background))
                    .load(it.imAttributes?.get(0)?.label).into(holder.ivSongImage)
            }

        }

        override fun onClick(v: View?) {
            try {
                val data = mList[layoutPosition]
                val intent = Intent(holder.root.context, SongDetailsActivity::class.java)
                intent.putExtra(SELECTED_SONG, data)
                holder.root.context.startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongsViewHolder {
        val holder =
            AdapterSongListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        return SongsViewHolder(holder)
    }

    /**
     * This method is used to update list and populate UI
     * @param list updated list
     */
    fun update(list: ArrayList<Entry>) {
        mList = list
        notifyItemRangeInserted(0, mList.size)
    }

    override fun onBindViewHolder(itemView: SongsViewHolder, position: Int) {
        itemView.bind(mList[position])
    }

    override fun getItemCount() = mList.size
}