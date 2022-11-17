package com.genie.social_media.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import com.genie.Constants
import com.genie.databinding.ActivityViewLiveBinding

class ViewLiveActivity : AppCompatActivity() {
    lateinit var binding:ActivityViewLiveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewLiveBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.liveUserName.text = intent.getStringExtra("name")
        binding.liveViewing.setImageBitmap(Constants().decodeImage(intent.getStringExtra("profile")!!))
        binding.addYourComment.doOnTextChanged { text, start, before, count ->
            if (text != null){
                binding.sendPostComment.visibility = View.VISIBLE
            }
        }
    }
}