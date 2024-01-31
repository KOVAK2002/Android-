package com.example.workintent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.workintent.databinding.FragmentWorkDetailBinding
import java.util.*

class WorkDetailFragment : Fragment() {

    private var _binding: FragmentWorkDetailBinding? = null
    private lateinit var work: Work

    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        work = Work(
            id = UUID.randomUUID(),
            title = "",
            date = Date(),
            isSolved = false
        )

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWorkDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            workTitle.doOnTextChanged { text, _, _, _ ->
                work = work.copy(title = text.toString())
            }

            workDate.apply {
                text = work.date.toString()
                isEnabled = false
            }

            workSolved.setOnCheckedChangeListener { _, isChecked ->
                work = work.copy(isSolved = isChecked)

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
