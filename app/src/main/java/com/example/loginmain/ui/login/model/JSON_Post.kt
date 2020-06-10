package com.example.loginmain.ui.login.model

import com.google.gson.annotations.SerializedName

class JSON_Post {

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("name")
    var name: String? = null

    @SerializedName("username")
    var username: String? = null

    @SerializedName("email")
    var email: String? = null


}