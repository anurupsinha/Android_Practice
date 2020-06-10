package com.example.loginmain.ui.login.view.dummyRetrofit

import com.example.loginmain.ui.login.model.JSON_Post
import retrofit2.Call
import retrofit2.http.GET

interface JSON_PlaceholderApi {


    @GET("users")
    fun getPosts(): Call<List<JSON_Post>>

//    @GET(value = "all/day?{api_key})
//    fun getMovies(@Path("api_key") var apikey:String):Call<List<JSON_TMDB_Demo>>
}