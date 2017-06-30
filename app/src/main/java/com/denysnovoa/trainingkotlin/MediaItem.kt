package com.denysnovoa.trainingkotlin

class MediaItem(val title: String, val url: String, val type: Type) {
  enum class Type {PHOTO, VIDEO }
}