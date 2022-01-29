package com.example.pokepicture.ui.poke_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokepicture.R
import com.example.pokepicture.databinding.FragmentPokeListBinding

class PokeListFragment : Fragment() {

    private val pokeListAdapter: PokeListAdapter by lazy {
        PokeListAdapter()
    }

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

        // recycleViewのセットアップ
        val decoration = DividerItemDecoration(requireContext(), LinearLayoutManager(requireContext()).orientation)
        binding.pokeRecyclerView.apply {
            addItemDecoration(decoration)
            adapter = pokeListAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }

        return binding.root
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
