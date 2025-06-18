package com.example.thesisconcierge.ui.rateService

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.thesisconcierge.databinding.FragmentRateServiceBinding

class RateServiceFragment : Fragment() {

    private var _binding: FragmentRateServiceBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRateServiceBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Get reference to ImageView

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

