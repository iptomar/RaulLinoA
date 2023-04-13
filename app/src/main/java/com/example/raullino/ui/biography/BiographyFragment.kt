package com.example.raullino.ui.biography

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.raullino.MainActivity
import com.example.raullino.databinding.FragmentBiographyBinding
import com.example.raullino.JsonParse

class BiographyFragment : Fragment() {

    private var _binding: FragmentBiographyBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
                ViewModelProvider(this).get(BiographyViewModel::class.java)

        _binding = FragmentBiographyBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textBiography
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val main = activity as MainActivity
        val t = JsonParse(main)
        print("\nTesting the json file\n")
        print(t.get_number())
        print("\nEnd\n")

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}