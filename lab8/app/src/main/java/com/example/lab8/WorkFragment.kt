package com.example.lab8

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.activityViewModels


class WorkFragment : Fragment() {
    private val viewModel: WorkViewModel by activityViewModels()
    lateinit var editTextWorkTitle: EditText
    lateinit var checkBoxSolved: CheckBox
    lateinit var buttonSaveWork: Button
    lateinit var toListFragmentBtn: Button
    lateinit var ChangeFragments: ChangeFragments

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_work, container, false)
        editTextWorkTitle = view.findViewById(R.id.editTextWorkTitle)
        checkBoxSolved = view.findViewById(R.id.checkBoxSolved)
        buttonSaveWork = view.findViewById(R.id.buttonSaveWork)
        toListFragmentBtn = view.findViewById(R.id.toListFragmentBtn)
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
        buttonSaveWork.setOnClickListener{
            var unesiText = editTextWorkTitle.text.toString()
            var checked = checkBoxSolved.apply { setOnCheckedChangeListener{_, isSolved->
                var checkBox = isSolved
            } }
            Log.d("Key", checkBoxSolved.isChecked.toString())
            viewModel.addToWorkList(unesiText,checkBoxSolved.isChecked)
            Log.d("key", viewModel.workList.size.toString())


        }
        toListFragmentBtn.setOnClickListener {
            ChangeFragments.toListFragmentTransaction()
        }
    }



}