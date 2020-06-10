package com.example.loginmain.ui.login.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class UserDetailsRealm(
    @PrimaryKey
    var userId: String? = null,
    var emailId: String? = null,
    var deptt: String? = null
) : RealmObject()