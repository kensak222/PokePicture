package com.example.pokepicture

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokepicture.databinding.FragmentPokeListBinding

class PokeListFragment : Fragment() {

//    private val pokeAdapter: PokeAdapter by lazy {
//        PokeAdapter()
//    }

    private var _binding: FragmentPokeListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, this.resources.getString(R.string.on_create_view_called))

        _binding = FragmentPokeListBinding.inflate(inflater, container, false)

        // recycleViewのセットアップ
        val decoration = DividerItemDecoration(requireContext(), LinearLayoutManager(requireContext()).orientation)
//        binding.pokeRecyclerView.apply {
//            addItemDecoration(decoration)
//            adapter = pokeAdapter
//            layoutManager = LinearLayoutManager(requireContext())
//            setHasFixedSize(true)
//        }

        return binding.root
    }

    override fun onDestroy() {
        Log.d(TAG, this.resources.getString(R.string.on_destroy_called))

        super.onDestroy()
        _binding = null
    }

    companion object {
        private val TAG = PokeListFragment::class.java.simpleName

        // TODO: 必要なければ削除
//        fun newInstance() = FavoriteFragment()

        // FIXME: ダミーデータなので、削除する
        private val dummyData = List<String>(100) {i -> "dummy$i"}
    }
}
