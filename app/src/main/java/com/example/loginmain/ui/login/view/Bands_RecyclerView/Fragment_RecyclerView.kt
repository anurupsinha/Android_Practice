package com.example.loginmain.ui.login

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loginmain.R
import com.example.loginmain.ui.login.viewmodel.LoginViewModel

//import com.example.loginmain.ui.login.viewmodel.LoginMain_ViewModel

/**
 * A simple [Fragment] subclass.
 */

var bands = ArrayList<BandList_Model>()
var listobject: LoginViewModel = LoginViewModel()

lateinit var navigationController: NavController

class Fragment_RecyclerView : Fragment(), MyAdapter.OnCustomClickListener {

    lateinit var myAdapter: MyAdapter

    private var pos: Int = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v: View = inflater.inflate(R.layout.frag_recycler, container, false)

        navigationController = findNavController()

        val recyclerview: RecyclerView = v.findViewById(R.id.RecyclerView)
        recyclerview.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)


        val BandList = listobject.generateList(20)
        myAdapter = MyAdapter(BandList, this)
        recyclerview.adapter = myAdapter
        recyclerview.layoutManager = LinearLayoutManager(context)

        return v
    }

    override fun onPress(textData: BandList_Model) {

        Toast.makeText(
            view?.context,
            "OnClick",
            Toast.LENGTH_SHORT
        ).show()

        navigationController.navigate(R.id.action_fragment_RecyclerView_to_viewPagerFragment)

    }

    override fun onLongPress(textData: BandList_Model) {

        Toast.makeText(
            view?.context,
            "OnLongClick",
            Toast.LENGTH_SHORT
        ).show()

        pos = bands.indexOf(textData)


        val builder: AlertDialog.Builder = AlertDialog.Builder(activity as Activity)
        builder.setTitle("Change Title")
        val customLayout: View = layoutInflater.inflate(R.layout.custom_alert_dialog, null)

        builder.setMessage("Change ${textData.text1} to : - ")
        builder.setIcon(R.drawable.ic_dialog_icon)
        builder.setView(customLayout)
        // add a button
        builder.setPositiveButton(
            "EDIT"
        ) { dialog, which ->
            val editText: EditText = customLayout.findViewById(R.id.editText)
            bands[pos].text1 = editText.text.toString()

            myAdapter.notifyDataSetChanged()

            Toast.makeText(
                view?.context,
                "Changed to ${textData.text1}",
                Toast.LENGTH_SHORT
            ).show()

        }
        builder.setNegativeButton("Cancel") { dialog, which ->
            dialog.dismiss()

        }

        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

}






