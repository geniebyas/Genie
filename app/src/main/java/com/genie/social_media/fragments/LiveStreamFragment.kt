package com.genie.social_media.fragments

import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.genie.Constants
import com.genie.R
import com.genie.databinding.ActivitySocialMediaBinding
import com.genie.databinding.FragmentLiveStreamBinding
import com.genie.social_media.activities.GoLiveActivity
import com.genie.social_media.adapters.LiveUsersAdapter
import com.genie.social_media.models.LiveUsersModel
import render.animations.Bounce
import render.animations.Render
import render.animations.Rotate
import render.animations.Zoom
import java.io.InputStream

class LiveStreamFragment : Fragment() {
    lateinit var binding: FragmentLiveStreamBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLiveStreamBinding.inflate(layoutInflater)

        var liveusers = ArrayList<LiveUsersModel>()
        liveusers.add(LiveUsersModel(Constants().encodeImage(BitmapFactory.decodeResource(context?.resources,R.drawable.profile)),"Alina Parkar"))
        liveusers.add(LiveUsersModel(Constants().encodeImage(BitmapFactory.decodeResource(context?.resources,R.drawable.profile1)),"John Doe"))
        liveusers.add(LiveUsersModel(Constants().encodeImage(BitmapFactory.decodeResource(context?.resources,R.drawable.dennis)),"Dennis rene"))
        liveusers.add(LiveUsersModel(Constants().encodeImage(BitmapFactory.decodeResource(context?.resources,R.drawable.hipster)),"Hipster soa"))
        liveusers.add(LiveUsersModel(Constants().encodeImage(BitmapFactory.decodeResource(context?.resources,R.drawable.new_hope)),"Dennis kane"))
        liveusers.add(LiveUsersModel(Constants().encodeImage(BitmapFactory.decodeResource(context?.resources,R.drawable.deaf)),"Nive selava"))
        liveusers.add(LiveUsersModel(Constants().encodeImage(BitmapFactory.decodeResource(context?.resources,R.drawable.cover)),"Lora lala"))
        liveusers.add(LiveUsersModel(Constants().encodeImage(BitmapFactory.decodeResource(context?.resources,R.drawable.art)),"Selovera sona"))
        var live_adapter = LiveUsersAdapter(liveusers)
        binding.liveUsersRv.adapter = live_adapter
        var rn = Render(context)
        rn.setAnimation(Bounce.InUp(binding.liveUsersRv))
        rn.start()
        rn.setAnimation(Zoom.InUp(binding.addYourLive))
        rn.setDuration(900)
        rn.start()
        binding.addYourLive.setOnClickListener {
            rn.setAnimation(Bounce.InDown(binding.addYourLive))
            rn.start()
            var intent = Intent(context,GoLiveActivity::class.java)
            intent.putExtra("username","@patelshakil95")
            startActivity(intent)
        }
        return binding.root
    }
}