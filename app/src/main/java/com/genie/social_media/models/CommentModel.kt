package com.genie.social_media.models

class CommentModel {
    lateinit var uid :String
    lateinit var username:String
    lateinit var profile_pic:String
    lateinit var comment:String

    constructor(uid: String, username: String, profile_pic: String, comment: String) {
        this.uid = uid
        this.username = username
        this.profile_pic = profile_pic
        this.comment = comment
    }
}