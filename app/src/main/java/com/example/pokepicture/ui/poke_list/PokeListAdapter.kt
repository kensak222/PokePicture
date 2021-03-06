package com.example.pokepicture.ui.poke_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokepicture.databinding.PokeRowLayoutBinding

class PokeListAdapter : RecyclerView.Adapter<PokeListAdapter.PokeViewHolder>() {

    class PokeViewHolder(private val binding: PokeRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            binding.apply {
                pictureBookNo.text = position.toString()
            }
        }

        companion object {
            fun from(parent: ViewGroup): PokeViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = PokeRowLayoutBinding.inflate(layoutInflater, parent, false)
                return PokeViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PokeViewHolder = PokeViewHolder.from(parent)

    override fun onBindViewHolder(holder: PokeViewHolder, position: Int) {
        // TODO: Entityとのつなぎこみを行う
        holder.bind(position)
    }

    override fun getItemCount(): Int = 500
}
