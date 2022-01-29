package com.example.pokepicture.ui.poke_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pokepicture.R
import com.example.pokepicture.databinding.FragmentPokeListBinding

class PokeListFragment : Fragment() {

    private lateinit var pokeListViewModel: PokeListViewModel
    private var _binding: FragmentPokeListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, this.resources.getString(R.string.on_create_view_called))

        pokeListViewModel =
            ViewModelProvider(this).get(PokeListViewModel::class.java)

        _binding = FragmentPokeListBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        pokeListViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, this.resources.getString(R.string.on_destroy_called))

        _binding = null
    }

    companion object {
        private val TAG = PokeListFragment::class.java.simpleName
    }
}
