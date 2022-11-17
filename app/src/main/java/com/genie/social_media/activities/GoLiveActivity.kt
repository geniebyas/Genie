package com.genie.social_media.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.genie.databinding.ActivityGoLiveBinding

class GoLiveActivity : AppCompatActivity() {
    lateinit var binding:ActivityGoLiveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoLiveBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.goLiveUsername.text = intent.getStringExtra("username")

    }
}