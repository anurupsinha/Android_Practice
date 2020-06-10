package com.example.loginmain.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.loginmain.R
import com.example.loginmain.databinding.FragmentLoginBinding
import com.example.loginmain.ui.login.viewmodel.LoginViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {
    private lateinit var viewModel: LoginViewModel
    private lateinit var fragmentLoginBinding: FragmentLoginBinding

    lateinit var button: Button
    private var views: Views? = null

    private class Views(val binding: FragmentLoginBinding)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
        setHasOptionsMenu(true)
    }


    override fun onPrepareOptionsMenu(menu: Menu) {

        val item = menu.findItem(R.id.logout)
        item?.setEnabled(false)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val bottomNavigation: BottomNavigationView = requireActivity().findViewById(R.id.Bottom_Nav)
        val binding = FragmentLoginBinding.inflate(inflater, container, false)
        views = Views(binding = binding)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        views?.binding?.apply {
            viewmodel = viewModel
        }
        viewModel.loginResult.observe(viewLifecycleOwner, Observer {

            if (viewModel.loginResult.value == true) {
                findNavController().navigate(R.id.action_loginFragment_to_success_Fragment)
            } else {
                user.error = "Incorrect Creds"

            }
        })
    }
}







