package com.genie.social_media.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.genie.Constants
import com.genie.R
import com.genie.databinding.SampleLiveStreamBinding
import com.genie.social_media.models.LiveUsersModel
import render.animations.Bounce
import render.animations.Fade
import render.animations.Render
import render.animations.Zoom

class LiveUsersAdapter:RecyclerView.Adapter<LiveUsersAdapter.LiveViewHolder> {
    var live_list:ArrayList<LiveUsersModel>

    constructor(live_list: ArrayList<LiveUsersModel>) : super() {
        this.live_list = live_list
    }

    class LiveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding:SampleLiveStreamBinding
        init {
            binding = SampleLiveStreamBinding.bind(itemView)
        }
        fun setData(live:LiveUsersModel){
            var an =  Render(binding.liveUserBtn.context)
            binding.liveName.text = live.username
            binding.liveProfile.setImageBitmap(Constants().decodeImage(live.userprofile))
            binding.liveUserBtn.setOnClickListener {
                Toast.makeText(binding.liveUserBtn.context,live.username + " Was Live...",Toast.LENGTH_SHORT).show()
                an.setAnimation(Bounce.In(binding.liveUserBtn))
                an.setDuration(500)
                an.start()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveViewHolder {
        return LiveViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.sample_live_stream,null,false))
    }

    override fun onBindViewHolder(holder: LiveViewHolder, position: Int) {
        LiveViewHolder(holder.itemView).setData(live_list[position])
    }

    override fun getItemCount(): Int {
        return live_list.size
    }
}