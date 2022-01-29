package com.example.pokepicture.ui.poke_list

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokepicture.R
import com.example.pokepicture.databinding.PokeRowLayoutBinding

class PokeListAdapter : RecyclerView.Adapter<PokeListAdapter.PokeListViewHolder>() {

    private lateinit var context: Context

    class PokeListViewHolder(private val binding: PokeRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            binding.apply {
                pictureBookNo.text = position.toString()
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PokeListViewHolder {
        context = parent.context
        Log.d(TAG, context.resources.getString(R.string.on_create_view_holder_called))

        val layoutInflater = LayoutInflater.from(context)
        val binding = PokeRowLayoutBinding.inflate(layoutInflater, parent, false)
         return PokeListViewHolder(binding)
    }

    override fun onBindViewHolder(holderList: PokeListViewHolder, position: Int) {
        Log.d(TAG, context.resources.getString(R.string.on_bind_view_holder_called))
        // TODO: Entityとのつなぎこみを行う
        holderList.bind(position)
    }

    override fun getItemCount(): Int = 500

    companion object {
        private val TAG = PokeListAdapter::class.java.simpleName
    }
}
