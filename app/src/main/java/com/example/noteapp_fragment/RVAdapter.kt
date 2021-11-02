package com.example.noteapp_fragment

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp_room.data2.Note
import kotlinx.android.synthetic.main.item.view.*


//import kotlinx.android.synthetic.main.single_item.view.*

class RVAdapter( val notes: List<Note>,  val Fragment: Fragment_Home) : RecyclerView.Adapter<RVAdapter.recyclerViewHolder>() {
    class recyclerViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): recyclerViewHolder {
        return recyclerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item,
                parent,
                false))
    }

    override fun onBindViewHolder(holder: recyclerViewHolder, position: Int) {
        val note = notes[position]

        holder.itemView.apply {

            textview2.text = note.note

           imageView.setOnClickListener {
              getid.id=note.id
              Fragment.findNavController().
               navigate(R.id.action_fragment_Home_to_fragment_Update)


           //  Fragment2!!.update(note.id)


           }
            imageView2.setOnClickListener {
                Fragment.confirm(note.id)
            }
        }}


    override fun getItemCount()=notes.size
}