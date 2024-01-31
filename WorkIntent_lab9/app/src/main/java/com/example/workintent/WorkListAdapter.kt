package com.example.workintent

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.workintent.databinding.ListItemWorkBinding

class WorkHolder(
    val binding : ListItemWorkBinding
): RecyclerView.ViewHolder(binding.root){
    fun bind(work:Work){
        binding.workTitle.text = work.title
        binding.workDate.text = work.date.toString()
        binding.root.setOnClickListener { Toast.makeText(binding.root.context, "${work.title} clicked!",Toast.LENGTH_SHORT).show()
        }
    }
}
// u konstruktor WorkListAdapter ubacite varijablu koja će predstavljati listu s poslovima
class WorkListAdapter (val jobs: List<Work>): RecyclerView.Adapter<WorkHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkHolder {
        val inflater = LayoutInflater.from(parent.context)

        // u varijablu binding napravite inflate koristeći ListItemWorkBinding
        val binding = ListItemWorkBinding.inflate(inflater)
        return WorkHolder(binding)
    }
    override fun onBindViewHolder(holder: WorkHolder, position: Int) {
        val work = jobs[position] // predati posao s liste na nekoj poziciji
        holder.bind(work)
    }
    override fun getItemCount() = jobs.size// funkcija vraća Int broj itema u RV komponenti

}