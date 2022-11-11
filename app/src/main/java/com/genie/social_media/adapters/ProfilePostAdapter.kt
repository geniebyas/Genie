package com.genie.social_media.adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.genie.R
import com.genie.databinding.SampleSocialPostProfileBinding
import com.genie.social_media.SocialMediaActivity
import com.genie.social_media.fragments.PostViewFragment
import com.genie.social_media.fragments.ProfileFragment


class ProfilePostAdapter: RecyclerView.Adapter<ProfilePostAdapter.ProfilePostViewHolder>{
    var context:Context
    var post_list:ArrayList<String>

    constructor(context: Context, post_list: ArrayList<String>) : super() {
        this.context = context
        this.post_list = post_list
    }

    class ProfilePostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var binding:SampleSocialPostProfileBinding
        init {
            binding = SampleSocialPostProfileBinding.bind(itemView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfilePostViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.sample_social_post_profile,null,false)
        return ProfilePostViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfilePostViewHolder, position: Int) {
//        Glide.with(context.applicationContext).load(post_list.get(position)).placeholder(R.drawable.image_icon).into(holder.binding.postUploaded)
        holder.binding.postUploaded.setOnClickListener {
        }
    }

    override fun getItemCount(): Int {
        return post_list?.size!!
    }
}