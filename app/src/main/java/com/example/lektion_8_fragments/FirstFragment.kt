package com.example.lektion_8_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lektion_8_fragments.databinding.FragmentFirstBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null       // Can be NULL
    private val binding get() = _binding!!                    // Getter ??

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Setup ViewBinding
        _binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        val fbaCloseFragment = binding.fbaCloseFragment

        // Inflate the layout for this fragment
        // val view = inflater.inflate(R.layout.fragment_first, container, false)

        // SetOnClick
        fbaCloseFragment.setOnClickListener() {
            parentFragmentManager.beginTransaction().remove(this).commit()
        }


        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}