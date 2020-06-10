package com.example.loginmain.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.loginmain.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Success_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Success_Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_success, container, false)

        val display_button: Button = v.findViewById(R.id.button_display_list)
        display_button.setOnClickListener {

            Toast.makeText(
                activity,
                "Displaying List",
                Toast.LENGTH_SHORT
            ).show()

            Navigation.findNavController(it)
                .navigate(R.id.action_success_Fragment_to_fragment_RecyclerView)


        }

        val back_button: ImageButton = v.findViewById(R.id.back_button)
        back_button.setOnClickListener {

            Toast.makeText(
                activity,
                "Logging Off",
                Toast.LENGTH_SHORT
            ).show()
            Navigation.findNavController(it).navigate(R.id.action_success_Fragment_to_loginFragment)
        }
        return v
    }

}