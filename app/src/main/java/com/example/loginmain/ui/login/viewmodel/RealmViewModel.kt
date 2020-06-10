package com.example.loginmain.ui.login.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.loginmain.ui.login.application.RealmApp
import com.example.loginmain.ui.login.manager.RealmManager
import com.example.loginmain.ui.login.model.UserDetailsRealm

open class RealmViewModel() : ViewModel() {

    init {
        var myApp: RealmApp =
            RealmApp()
    }

    val readResult = MutableLiveData<List<UserDetailsRealm>>()
    val writeSuccess = MutableLiveData<Boolean>()

    var realmManager = RealmManager()
    var userid = ObservableField("")
    var user_email = ObservableField("")
    var user_deptt = ObservableField("")

    fun onSave() =
        writeSuccess.postValue(
            insertupdateUser(
                userid.get() ?: userid.toString(),
                user_email.get() ?: user_email.toString(),
                user_deptt.get() ?: user_deptt.toString()
            )
        )


    fun insertupdateUser(id: String, email: String, deptt: String): Boolean {
        if (id.isNotEmpty() && email.isNotEmpty() && deptt.isNotEmpty()) {
            val user = UserDetailsRealm(id, email, deptt)
            realmManager.add(user)
        }
        getUserRealm()
        return true

    }

    fun getUserRealm() {
        val allusers: List<UserDetailsRealm> = realmManager.findAll()
        readResult.postValue(allusers)
    }
}
