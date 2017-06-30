package com.denysnovoa.trainingkotlin

class MediaItem(val title: String, val url: String) {
  companion object Type {
    val PHOTO = 1
    val VIDEO = 2
  }
}