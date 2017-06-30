package com.denysnovoa.trainingkotlinimport android.os.Bundleimport android.support.v7.app.AppCompatActivityimport android.support.v7.widget.GridLayoutManagerimport android.support.v7.widget.RecyclerViewimport android.widget.Toastimport com.denysnovoa.trainingkotlin.adapter.MediaAdapterclass MainActivity : AppCompatActivity() {  override fun onCreate(savedInstanceState: Bundle?) {    super.onCreate(savedInstanceState)    setContentView(R.layout.activity_main)    val recycler = findViewById(R.id.recycler) as RecyclerView    recycler.layoutManager = GridLayoutManager(this, 2)    recycler.adapter = MediaAdapter(getMedia())  }  private fun toast(message: String) {    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()  }  private val thumbBase = "http://lorempixel.com/400/400/cats/"  fun getMedia() = listOf(      MediaItem("Title 1", "${thumbBase}1"),      MediaItem("Title 2", "${thumbBase}2"),      MediaItem("Title 3", "${thumbBase}3"),      MediaItem("Title 4", "${thumbBase}4"),      MediaItem("Title 5", "${thumbBase}5"),      MediaItem("Title 6", "${thumbBase}6"),      MediaItem("Title 7", "${thumbBase}7"),      MediaItem("Title 8", "${thumbBase}8"),      MediaItem("Title 9", "${thumbBase}9"),      MediaItem("Title 10", "${thumbBase}10")  )}