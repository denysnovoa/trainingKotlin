@file:JvmName("Utils")

package com.denysnovoa.trainingkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso

@JvmOverloads
fun Context.toast(message: CharSequence, length: Int = Toast.LENGTH_SHORT) {
  Toast.makeText(this, message, length).show()
}

fun ImageView.loadUrl(url: String) {
  Picasso.with(context).load(url).into(this)
}

fun ViewGroup.inflate(resource: Int): View {
  return LayoutInflater.from(context).inflate(resource, this, false)
}