package com.genie.social_media.fragments

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.UserHandle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.genie.Constants
import com.genie.R
import com.genie.account.UserModel
import com.genie.databinding.FragmentSearchBinding
import com.genie.databinding.SampleLiveStreamBinding
import com.genie.databinding.SampleSocialPostProfileBinding
import com.genie.databinding.SampleSocialUserBinding
import com.genie.social_media.models.PostModel
import render.animations.Bounce
import render.animations.Render
import render.animations.Slide
import render.animations.Zoom

class SearchFragment : Fragment() {
    lateinit var binding: FragmentSearchBinding
    var search_post_list = ArrayList<PostModel>()
    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(layoutInflater)
        var an = Render(context)
        an.setAnimation(Bounce.InUp(binding.fragmentSearch))
        an.start()
        an.setAnimation(Slide.InDown(binding.searchFilterButtons))
        an.start()
        //search post layout
        var post_adapter = SearchAdapter(search_post_list)
        binding.searchPostRv.adapter = post_adapter
        search_post_list.add(PostModel(Constants().encodeImage(BitmapFactory.decodeResource(context?.resources,R.drawable.profile)),1234567890,"Hey there ","Shakil Patel"))
        search_post_list.add(PostModel(Constants().encodeImage(BitmapFactory.decodeResource(context?.resources,R.drawable.profile1)),1234567890,"Hey there ","Shakil Patel"))
        search_post_list.add(PostModel(Constants().encodeImage(BitmapFactory.decodeResource(context?.resources,R.drawable.dennis_kane)),1234567890,"Hey there ","Shakil Patel"))
        search_post_list.add(PostModel(Constants().encodeImage(BitmapFactory.decodeResource(context?.resources,R.drawable.art)),1234567890,"Hey there ","Shakil Patel"))
        search_post_list.add(PostModel(Constants().encodeImage(BitmapFactory.decodeResource(context?.resources,R.drawable.cover)),1234567890,"Hey there ","Shakil Patel"))
        search_post_list.add(PostModel(Constants().encodeImage(BitmapFactory.decodeResource(context?.resources,R.drawable.new_hope)),1234567890,"Hey there ","Shakil Patel"))
        search_post_list.add(PostModel(Constants().encodeImage(BitmapFactory.decodeResource(context?.resources,R.drawable.deaf)),1234567890,"Hey there ","Shakil Patel"))

        //filter button logic
        binding.searchUser.setOnClickListener {
            an.setAnimation(Zoom.InDown(it))
            an.start()
            binding.searchUser.setBackgroundColor(androidx.appcompat.R.color.material_blue_grey_800)
            binding.searchGroups.setBackgroundColor(R.color.primary)
            binding.searchPost.setBackgroundColor(R.color.primary)
            binding.searchUsersBio.setBackgroundColor(R.color.primary)
            binding.searchPostRv.visibility = View.GONE
            binding.searchUserRv.visibility = View.VISIBLE
            }
        binding.searchPost.setOnClickListener {
            an.setAnimation(Zoom.InDown(it))
            an.start()
            binding.searchPost.setBackgroundColor(androidx.appcompat.R.color.material_blue_grey_800)
            binding.searchGroups.setBackgroundColor(R.color.primary)
            binding.searchUser.setBackgroundColor(R.color.primary)
            binding.searchUsersBio.setBackgroundColor(R.color.primary)
            binding.searchPostRv.visibility = View.VISIBLE
            binding.searchUserRv.visibility = View.GONE
        }
        binding.searchGroups.setOnClickListener {
            an.setAnimation(Zoom.InDown(it))
            an.start()
            binding.searchGroups.setBackgroundColor(androidx.appcompat.R.color.material_blue_grey_800)
            binding.searchUser.setBackgroundColor(R.color.primary)
            binding.searchPost.setBackgroundColor(R.color.primary)
            binding.searchUsersBio.setBackgroundColor(R.color.primary)
            binding.searchPostRv.visibility = View.GONE
            binding.searchUserRv.visibility = View.VISIBLE
        }
        //search users layout
        var users_list = ArrayList<UserModel>()
        var users_adapter =  SearchUsersAdapter(users_list)
        binding.searchUserRv.adapter = users_adapter
        users_list.add(UserModel("Shakil Patel","asdff","d","Shakil Patel",Constants().encodeImage(BitmapFactory.decodeResource(context?.resources,R.drawable.profile))))
        users_list.add(UserModel("John salar","asdff","d","Shakil Patel",Constants().encodeImage(BitmapFactory.decodeResource(context?.resources,R.drawable.profile1))))
        users_list.add(UserModel("Aamir Patel","asdff","d","Shakil Patel",Constants().encodeImage(BitmapFactory.decodeResource(context?.resources,R.drawable.deaf))))
        users_list.add(UserModel("Salman Patel","asdff","d","Shakil Patel",Constants().encodeImage(BitmapFactory.decodeResource(context?.resources,R.drawable.dennis_kane))))
        users_list.add(UserModel("Salim junjunwala","asdff","d","Shakil Patel",Constants().encodeImage(BitmapFactory.decodeResource(context?.resources,R.drawable.dennis))))
        users_list.add(UserModel("Sahil Patel","asdff","d","Shakil Patel",Constants().encodeImage(BitmapFactory.decodeResource(context?.resources,R.drawable.cover))))
        return binding.root
    }
    class SearchAdapter : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>{
        var search_post_list : ArrayList<PostModel>

        constructor(search_post_list: ArrayList<PostModel>) : super() {
            this.search_post_list = search_post_list
        }

        class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var binding = SampleSocialPostProfileBinding.bind(itemView)
            fun setData(model: PostModel){
                binding.postUploaded.setImageBitmap(Constants().decodeImage(model.post_url))
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
            return SearchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.sample_social_post_profile,null,false))
        }

        override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
            SearchViewHolder(holder.itemView).setData(search_post_list[position])
        }

        override fun getItemCount(): Int {
            return search_post_list.size
        }
    }
    class SearchUsersAdapter:RecyclerView.Adapter<SearchUsersAdapter.UsersViewHolder>{
        var users_list:ArrayList<UserModel>

        constructor(users_list: ArrayList<UserModel>) : super() {
            this.users_list = users_list
        }

        class UsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var binding = SampleSocialUserBinding.bind(itemView)
            fun setData(model:UserModel){
                binding.username.text = model.username
                binding.profile.setImageBitmap(Constants().decodeImage(model.profile_pic))
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
            return UsersViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.sample_social_user,null,false))
        }

        override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
            UsersViewHolder(holder.itemView).setData(users_list[position])
        }

        override fun getItemCount(): Int {
            return users_list.size
        }
    }
}