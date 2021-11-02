package com.example.noteapp_fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp_room.data2.Note


class Fragment_Update : Fragment() {
lateinit var updatebtn:Button
    lateinit var myViewModel :MyViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment__update, container, false)

        myViewModel= ViewModelProvider(this).get(MyViewModel::class.java)

        view.findViewById<Button>(R.id.btnupdate).setOnClickListener {
            var note= view.findViewById<EditText>(R.id.edupdate).text.toString()

           update(note,getid.id)
            


      }
      view.findViewById<Button>(R.id.btnView).setOnClickListener {
          Navigation.findNavController(view).navigate(R.id.action_fragment_Update_to_fragment_Home)
      }
        return view
    }


    fun update(n: String,id:Int) {


        if (n.isNotEmpty()) {

            myViewModel.updatesNotes(id, n)
            Toast.makeText(requireContext(), "data successfully Edited", Toast.LENGTH_SHORT)
                .show()
        } else {

            Toast.makeText(requireContext(), "Field is empty", Toast.LENGTH_SHORT)
                .show()
        }


    }


    }


