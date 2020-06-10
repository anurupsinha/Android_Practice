package com.example.loginmain.ui.login.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.loginmain.ui.login.BandList_Model
import com.example.loginmain.ui.login.bands

open class LoginViewModel : ViewModel() {

    val loginResult = MutableLiveData<Boolean>()

    var username = ObservableField("")
    var password = ObservableField("")

    fun performLogin() =
        loginResult.postValue(
            checkCredentials(
                username.get() ?: username.toString(),
                password.get() ?: password.toString()
            )
        )

    fun checkCredentials(username: String, password: String): Boolean {
        return ((username.contains("@")) and (username.endsWith(".com")) and (username.length > 7) and (password.length >= 8))

    }

    fun generateList(size: Int): ArrayList<BandList_Model> {
        bands = ArrayList()
        bands.add(
            BandList_Model(
                "https://cdn.mos.cms.futurecdn.net/UCf44DTx56UUSpLdstukXA-320-80.jpg",
                "NIRVANA"
            )
        )
        bands.add(
            BandList_Model(
                "https://seeklogo.com/images/R/Red_Hot_Chili_Peppers-logo-4B4DFA04B7-seeklogo.com.png",
                "RHCP"
            )
        )
        bands.add(
            BandList_Model(
                "https://img.discogs.com/1DKqsIXV7sx8vl7wXxBOo9QG-w4=/fit-in/300x300/filters:strip_icc():format(jpeg):mode_rgb():quality(40)/discogs-images/R-12433272-1535201496-4408.jpeg.jpg",
                "PEARL JAM"
            )
        )
        bands.add(
            BandList_Model(
                "https://upload.wikimedia.org/wikipedia/en/e/ed/Green_Day_-_American_Idiot_album_cover.png",
                "GREEN DAY"
            )
        )
        return bands
    }
}



