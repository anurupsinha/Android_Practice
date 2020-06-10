package com.example.loginmain.ui.login

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.loginmain.R

//Recycler View Adapter
class MyAdapter(
    var myList: List<BandList_Model>,
    var customListener: OnCustomClickListener
) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnLongClickListener,
        View.OnClickListener {

        init {
            itemView.setOnLongClickListener(this)
            itemView.setOnClickListener(this)
        }

        var textview1 = itemView.findViewById(R.id.textview1) as TextView
        var imageview: ImageView = itemView.findViewById(R.id.image_view) as ImageView

        override fun onLongClick(v: View?): Boolean {
            customListener.onLongPress(myList[adapterPosition])

            return true
        }

        override fun onClick(v: View?) {

            customListener.onPress(myList[adapterPosition])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val vh = LayoutInflater.from(parent.context).inflate(R.layout.cardview_items, parent, false)

        return ViewHolder(vh)

    }


    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val cards: BandList_Model = myList[position]

        holder.textview1.text = cards.text1

        // Glide to fetch image using url
        Glide.with(holder.itemView).load(cards.ImageResource)
            .transition(DrawableTransitionOptions.withCrossFade()).error(R.drawable.logo)
            .placeholder(R.drawable.logo).into(holder.imageview)

    }

    interface OnCustomClickListener {
        fun onPress(textData: BandList_Model)
        fun onLongPress(textData: BandList_Model)
    }

}


