package com.example.pokepicture.ui.favorite

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
import com.example.pokepicture.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment() {

    private lateinit var favoriteViewModel: FavoriteViewModel
    private var _binding: FragmentFavoriteBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, this.resources.getString(R.string.on_create_view_called))

        favoriteViewModel =
            ViewModelProvider(this).get(FavoriteViewModel::class.java)

        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        favoriteViewModel.text.observe(viewLifecycleOwner, Observer {
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
        private val TAG = FavoriteFragment::class.java.simpleName
    }
}
