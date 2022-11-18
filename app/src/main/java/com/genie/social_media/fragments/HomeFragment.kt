package com.genie.social_media.fragments

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.genie.Constants
import com.genie.R
import com.genie.databinding.FragmentHomeBinding
import com.genie.social_media.adapters.PostAdapter
import com.genie.social_media.models.PostModel
import com.google.firebase.database.FirebaseDatabase


class HomeFragment : Fragment() {
    lateinit var binding :FragmentHomeBinding
    lateinit var database:FirebaseDatabase
    lateinit var post_list:ArrayList<PostModel>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
//        database = FirebaseDatabase.getInstance()
        post_list = ArrayList()
        var adapter = PostAdapter(context?.applicationContext!!,post_list)
        binding.feedPostRv.adapter = adapter
        post_list.add(PostModel(Constants().encodeImage(BitmapFactory.decodeResource(context?.resources,R.drawable.dennis)),
            1234567890,
            "Hello bro i am your big fan....",
            "Salim Panwala"))
        post_list.add(PostModel(Constants().encodeImage(BitmapFactory.decodeResource(context?.resources,R.drawable.hipster)),
            1234567890,
            "Hello bro i am your big fan....",
            "Rafik Rabdiwala"))
        post_list.add(PostModel(Constants().encodeImage(BitmapFactory.decodeResource(context?.resources,R.drawable.dennis_kane)),
            1234567890,
            "Hello bro i am your big fan....",
            "Samir Gochu"))

        adapter.notifyDataSetChanged()
//        database.reference.child("social_media")
//            .child("posts")
//            .addValueEventListener(object :ValueEventListener{
//                override fun onDataChange(snapshot: DataSnapshot) {
//                    post_list.clear()
//                    if (snapshot.exists()){
//                        for (i in snapshot.children){
//                            var post: PostModel? =i.getValue(PostModel::class.java)
//                            post?.post_id = i.key.toString()
//                            if (post != null) {
//                                post_list.add(0,post)
//                            }
//                        }
//                        adapter.notifyDataSetChanged()
//                    }
//                }
//
//                override fun onCancelled(error: DatabaseError) {
//                }
//
//            })
        return binding.root
    }
}