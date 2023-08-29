package com.example.passwordmanager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.passwordmanager.databinding.BlockItemBinding

class BlockAdapter : RecyclerView.Adapter<BlockAdapter.BlockHolder>() {
    val blockList = ArrayList<Block>()

    class BlockHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = BlockItemBinding.bind(item)
        fun bind(block: Block) = with(binding){
            ServiceNameText.text = block.service
            LoginTextt.setText(block.log)
            PasswordTextt.setText(block.password)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlockHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.block_item, parent, false)
        return BlockHolder(view)
    }

    override fun getItemCount(): Int {
        return blockList.size
    }

    override fun onBindViewHolder(holder: BlockHolder, position: Int) {
        holder.bind(blockList[position])
    }

    fun addBlock(block: Block) {
        blockList.add(block)
        notifyDataSetChanged()
    }

    fun delitem_byid(block: Block) {

    }

}