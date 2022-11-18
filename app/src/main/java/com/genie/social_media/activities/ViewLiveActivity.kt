package com.genie.social_media.activities

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.RecyclerView
import com.genie.Constants
import com.genie.R
import com.genie.databinding.ActivityViewLiveBinding
import com.genie.databinding.SampleLiveUserCommentBinding
import com.genie.social_media.models.CommentModel

class ViewLiveActivity : AppCompatActivity() {
    lateinit var binding:ActivityViewLiveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewLiveBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.liveUserName.text = intent.getStringExtra("name")
        binding.liveViewing.setImageBitmap(Constants().decodeImage(intent.getStringExtra("profile")!!))
        var com_list = ArrayList<CommentModel>()
        var com_adapter = ViewCommentAdapter(com_list)
        binding.liveCommentRv.adapter = com_adapter
        binding.sendPostComment.setOnClickListener {
            if (binding.addYourComment.text.isNotEmpty()){
                com_list.add(CommentModel("fd","john_marshilona",Constants().encodeImage(BitmapFactory.decodeResource(resources,R.drawable.profile)),binding.addYourComment.text.trim().toString()))
                binding.addYourComment.text = null
                binding.liveCommentRv.smoothScrollToPosition(com_list.size - 1)
                com_adapter.notifyDataSetChanged()
            }
        }
        binding.addYourComment.doOnTextChanged { text, start, before, count ->
            if (text != null){
                binding.sendPostComment.visibility = View.VISIBLE
            }
        }
    }
    class ViewCommentAdapter: RecyclerView.Adapter<ViewCommentAdapter.ViewCommentViewHolder>{
        var comment_list = ArrayList<CommentModel>()

        constructor(comment_list: ArrayList<CommentModel>) : super() {
            this.comment_list = comment_list
        }

        class ViewCommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var binding : SampleLiveUserCommentBinding
            init {
                binding = SampleLiveUserCommentBinding.bind(itemView)
            }
            fun setData(model: CommentModel){
                binding.comUserUsername.text = "@" + model.username
                binding.commentText.text = model.comment
                binding.comUserProfile.setImageBitmap(Constants().decodeImage(model.profile_pic))
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewCommentViewHolder {
            return ViewCommentViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.sample_live_user_comment,null,false))
        }

        override fun onBindViewHolder(holder: ViewCommentViewHolder, position: Int) {
            ViewCommentViewHolder(holder.itemView).setData(comment_list[position])

        }

        override fun getItemCount(): Int {
            return comment_list.size
        }
    }
}