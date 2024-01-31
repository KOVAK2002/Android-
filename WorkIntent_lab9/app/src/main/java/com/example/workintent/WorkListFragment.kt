package com.example.workintent

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workintent.databinding.FragmentWorkListBinding

private const val TAG = "WorkListFragment"
class WorkListFragment : Fragment() {
    lateinit var _binding: FragmentWorkListBinding

    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }
    private val workListViewModel : WorkListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // u Log.d ispišite veličinu liste jobs koju ste kreirali u workListViewModel

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWorkListBinding.inflate(inflater,container,false)
        // postavite linearLayoutManager u recyclerview
        val workRecycleView = _binding.workRecyclerView
        workRecycleView.layoutManager = LinearLayoutManager(context)
        val jobs  = workListViewModel.jobs
        val adapter = WorkListAdapter(jobs)
        workRecycleView.adapter = adapter
        //Postavite poslove iz klase workListViewmodel u varijablu  val jobs i instancirajte jedan
        // adapter za recyclerView
        //postavite tu instancu kao adapter za workRecyclerView


        return binding.root
    }
}