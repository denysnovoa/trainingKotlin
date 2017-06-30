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

class MediaAdapter(val items: List<MediaItem>) : RecyclerView.Adapter<MediaViewHolder>() {

  override fun onBindViewHolder(holder: MediaViewHolder, position: Int) {
    holder.bind(items[position])
  }

  override fun getItemCount() = items.size

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaViewHolder {
    val view = parent.inflate(R.layout.view_media_item)
    return MediaViewHolder(view)
  }
}

class MediaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
  val imageView: ImageView = itemView.findViewById<ImageView>(R.id.media_thumb)
  val textView: TextView = itemView.findViewById<TextView>(R.id.media_title)

  fun bind(mediaItem: MediaItem) {
    textView.text = mediaItem.title

    imageView.loadUrl(mediaItem.url)
  }
}
