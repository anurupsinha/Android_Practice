package com.example.loginmain.ui.login.application

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class RealmApp : Application() {

    lateinit var realm: Realm

    override fun onCreate() {
        super.onCreate()

        initRealm()

    }

    // function to initiate Realm
    fun initRealm() {
        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .name("UserDetailsRealm.realm")
            .schemaVersion(1)
            .build()

        Realm.setDefaultConfiguration(config)

    }

}