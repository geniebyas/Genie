package com.genie.social_media.models

class LiveUsersModel {
    lateinit var userprofile:String
    lateinit var username:String

    constructor(userprofile: String, username: String) {
        this.userprofile = userprofile
        this.username = username
    }
}