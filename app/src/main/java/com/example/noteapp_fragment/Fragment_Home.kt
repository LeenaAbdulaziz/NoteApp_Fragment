package com.example.noteapp_fragment

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp_room.data2.Note

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Fragment_Home : Fragment() {

    lateinit var save: Button
    lateinit var note: EditText
    lateinit var recycle: RecyclerView



    lateinit var myViewModel :MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment__home, container, false)

        note=view.findViewById(R.id.ednote)
        save=view.findViewById(R.id.btnsave)
        recycle=view.findViewById(R.id.rv)


        myViewModel= ViewModelProvider(this).get(MyViewModel::class.java)

        save.setOnClickListener {
            val s1=note.text.toString()
            if(s1.isNotEmpty()) {
                myViewModel.addNotes(s1)
                note.text.clear()

                Toast.makeText(requireContext(), "data successfully added", Toast.LENGTH_SHORT)
                    .show()

            }
            else{
                Toast.makeText(requireContext(),"please add note first", Toast.LENGTH_SHORT).show()
            }
        }

        updatedrecycle()

        view.findViewById<RecyclerView>(R.id.rv).setOnClickListener {

            Navigation.findNavController(view).navigate(R.id.action_fragment_Home_to_fragment_Update)

        }
        return view

    }

    fun updatedrecycle(){
        myViewModel.getnotes().observe(viewLifecycleOwner,{
                notes1->
            recycle.adapter = RVAdapter ( notes1,this)
            recycle.layoutManager = LinearLayoutManager(requireContext())
        })

    }


    fun confirm(id:Int){

        var at= AlertDialog.Builder(requireContext())
        at.setTitle("delete Note")
        at.setPositiveButton("Delete", DialogInterface.OnClickListener { dialogInterface, i ->
            deleteitem(id)
        })
        at.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })

        at.show()
    }

    private fun deleteitem(id:Int) {
        myViewModel.deleteNotes(id)
        Toast.makeText(requireContext(), "data successfully Deleted", Toast.LENGTH_SHORT)
            .show()

    }


}


