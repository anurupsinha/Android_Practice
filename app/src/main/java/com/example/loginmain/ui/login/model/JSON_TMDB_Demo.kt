package com.example.loginmain.ui.login.model

import com.google.gson.annotations.SerializedName

class JSON_TMDB_Demo {
    @SerializedName("id")
    var id: Int = 0

    @SerializedName("original_title")
    var original_title: String? = null

    @SerializedName("overview")
    var overview: String? = null


}