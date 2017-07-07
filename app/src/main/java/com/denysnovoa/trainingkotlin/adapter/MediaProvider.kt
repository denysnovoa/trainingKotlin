package com.denysnovoa.trainingkotlin.adapter

import com.denysnovoa.trainingkotlin.MediaItem
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

private val thumbBase = "http://lorempixel.com/400/400/cats/"

object MediaProvider {

  private fun getMedia(): List<MediaItem> {
    Thread.sleep(2000)

    return (1..30).map {
      val isVideo = it % 3 == 0

      MediaItem("Tittle$it", "$thumbBase$it", if (isVideo) MediaItem.Type.VIDEO else MediaItem.Type.PHOTO)
    }
  }

  fun getMediaAsync(callback: (List<MediaItem>) -> Unit) {
    doAsync {
      val media = getMedia()
      uiThread {
        callback(media)
      }
    }
  }
}
/*
listOf(
MediaItem("Title 1", "${thumbBase}1", MediaItem.Type.PHOTO),
MediaItem("Title 2", "${thumbBase}2", MediaItem.Type.PHOTO),
MediaItem("Title 3", "${thumbBase}3", MediaItem.Type.VIDEO),
MediaItem("Title 4", "${thumbBase}4", MediaItem.Type.VIDEO),
MediaItem("Title 5", "${thumbBase}5", MediaItem.Type.VIDEO),
MediaItem("Title 6", "${thumbBase}6", MediaItem.Type.PHOTO),
MediaItem("Title 7", "${thumbBase}7", MediaItem.Type.VIDEO),
MediaItem("Title 8", "${thumbBase}8", MediaItem.Type.PHOTO),
MediaItem("Title 9", "${thumbBase}9", MediaItem.Type.VIDEO),
MediaItem("Title 10", "${thumbBase}10", MediaItem.Type.VIDEO)

)
*/