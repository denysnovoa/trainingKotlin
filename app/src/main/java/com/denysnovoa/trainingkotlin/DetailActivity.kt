package com.denysnovoa.trainingkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.denysnovoa.trainingkotlin.adapter.MediaProvider
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

  companion object {
    val PARAMETER_ID = "id"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail)

    val id = intent.extras[PARAMETER_ID]

    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowHomeEnabled(true)

    MediaProvider.getMediaAsync {
      media ->
      val mediaItem: MediaItem? = media.firstOrNull { it.id == id }

      mediaItem?.let {
        detail_thumb.loadUrl(it.url)
        media_title_detail.text = it.title
        supportActionBar?.title = media_title_detail.text
      }
    }
  }

  override fun onOptionsItemSelected(item: MenuItem) =
      if (item.itemId == android.R.id.home) {
        onBackPressed()
        true
      } else {
        true
      }
}

