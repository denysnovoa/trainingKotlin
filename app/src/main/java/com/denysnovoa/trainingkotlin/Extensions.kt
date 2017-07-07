@file:JvmName("Utils")

package com.denysnovoa.trainingkotlin

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
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

inline fun <reified T : Activity> Context.startActivity() {
  val intent = Intent(this, T::class.java)
}

fun <T : View> View.find(id: Int): T {
  return findViewById(id)
}

fun RecyclerView.ViewHolder.find(id: Int) {
  find(id)
}

fun View.visible(visible: Boolean) {
  this.visibility = if (visible) View.VISIBLE else View.GONE
}
