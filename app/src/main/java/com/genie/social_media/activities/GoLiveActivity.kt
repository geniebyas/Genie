package com.genie.social_media.activities

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import com.genie.Constants
import com.genie.R
import com.genie.databinding.ActivityGoLiveBinding
import com.genie.social_media.models.CommentModel

class GoLiveActivity : AppCompatActivity() {
    lateinit var binding:ActivityGoLiveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoLiveBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.goLiveUsername.text = intent.getStringExtra("username")
        var com_list = ArrayList<CommentModel>()
        var com_adapter = ViewLiveActivity.ViewCommentAdapter(com_list)
        binding.liveCommentsRv.adapter = com_adapter
        binding.sendPostComment.setOnClickListener {
            if (binding.addYourComment.text.isNotEmpty()){
                com_list.add(CommentModel("fd",
                    "john_marshilona",
                    Constants().encodeImage(BitmapFactory.decodeResource(resources, R.drawable.profile)),
                    binding.addYourComment.text.trim().toString()))
                binding.addYourComment.text = null
                binding.liveCommentsRv.smoothScrollToPosition(com_list.size - 1)
                com_adapter.notifyDataSetChanged()
            }
        }
        binding.addYourComment.doOnTextChanged { text, start, before, count ->
            if (text != null){
                binding.sendPostComment.visibility = View.VISIBLE
            }
        }

    }
}