package com.example.loginmain.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.loginmain.R
import com.example.loginmain.databinding.FragmentTwoBinding
import com.example.loginmain.ui.login.application.RealmApp
import com.example.loginmain.ui.login.model.UserDetailsRealm
import com.example.loginmain.ui.login.viewmodel.RealmViewModel
import io.realm.Realm
import kotlinx.android.synthetic.main.fragment_two.*


class RealmFragment : Fragment() {

    private lateinit var realm: Realm
    private lateinit var RealmVM: RealmViewModel
    private lateinit var UserList: List<UserDetailsRealm>

    private var views: Views? = null

    private class Views(val binding: FragmentTwoBinding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        myApp.initRealm()

        val binder: FragmentTwoBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_two,
            container,
            false
        )
        var myApp: RealmApp =
            RealmApp()

        RealmVM = ViewModelProvider(this).get(RealmViewModel::class.java)
        binder.vm = RealmVM
        binder.lifecycleOwner = this
        return binder.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//      views?.binding?.apply {
//            vm = RealmVM
//        }
        RealmVM.writeSuccess.observe(viewLifecycleOwner, Observer {

            if (RealmVM.writeSuccess.value == true) {
                UserList = RealmVM.readResult.value as List<UserDetailsRealm>
                for (user in UserList)
                    tv_response.append("--->  ${user.userId} " + " ${user.emailId} " + " ${user.deptt} ")
            } else {
                tv_response.append("Cannot save to DB")

            }

        })

    }
}
