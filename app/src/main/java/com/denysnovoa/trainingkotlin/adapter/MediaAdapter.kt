package com.denysnovoa.trainingkotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.denysnovoa.trainingkotlin.MediaItem
import com.denysnovoa.trainingkotlin.R
import com.denysnovoa.trainingkotlin.inflate
import com.denysnovoa.trainingkotlin.loadUrl
import kotlinx.android.synthetic.main.view_media_item.view.*
import kotlin.properties.Delegates

class MediaAdapter(items: List<MediaItem>, val listenerClick: (MediaItem) -> Unit) : RecyclerView.Adapter<MediaViewHolder>() {

  var items: List<MediaItem> by Delegates.observable(items) { _, _, _ ->
    this.notifyDataSetChanged()
  }

  override fun onBindViewHolder(holder: MediaViewHolder, position: Int) {
    val mediaItem = items[position]

    holder.bind(mediaItem)
    holder.itemView.setOnClickListener { listenerClick(mediaItem) }
  }

  override fun getItemCount() = items.size

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaViewHolder {
    val view = parent.inflate(R.layout.view_media_item)
    return MediaViewHolder(view)
  }
}

class MediaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
  val imagePhoto = itemView.media_thumb as ImageView
  val textTitle = itemView.media_title as TextView
  val imagePlay = itemView.media_video_indicator as ImageView

  fun bind(mediaItem: MediaItem) {

    textTitle.media_title.text = mediaItem.title
    imagePhoto.loadUrl(mediaItem.url)

    imagePlay.visibility = when (mediaItem.type) {
      MediaItem.Type.PHOTO -> View.GONE
      MediaItem.Type.VIDEO -> View.VISIBLE
    }
  }
}
