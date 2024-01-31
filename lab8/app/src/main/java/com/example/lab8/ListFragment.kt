package com.example.lab8

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import kotlinx.coroutines.CompletionHandlerException


class ListFragment : Fragment() {
    private val viewModel: WorkViewModel by activityViewModels()
    lateinit var buttonLogLenght: Button
    lateinit var buttonGoToWorkFragment: Button
    lateinit var textViewWorkList: TextView
    lateinit var ChangeFragments: ChangeFragments

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        buttonLogLenght = view.findViewById(R.id.buttonLogLength)
        buttonGoToWorkFragment = view.findViewById(R.id.buttonGoToWorkFragment)
        textViewWorkList = view.findViewById(R.id.textViewWorkList)
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is ChangeFragments){
            ChangeFragments = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewWorkList.setText(viewModel.workList.toString())
        buttonLogLenght.setOnClickListener{
            Log.d("Duzina",viewModel.workList.size.toString())
        }
        buttonGoToWorkFragment.setOnClickListener {
            ChangeFragments.toWorkFragmentTransaction()
        }
    }


}