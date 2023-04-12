package com.example.memberregistersqlitepro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.memberregistersqlitepro.databinding.ItemViewBinding

class RecyclerAdapter(val memberData: MutableList<Member>) : RecyclerView.Adapter<RecyclerAdapter.CustomViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomViewHolder(binding)
    }

    override fun getItemCount(): Int = memberData.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val binding = holder.binding
        binding.textId.text = memberData.get(position).id
        binding.textMail.text = memberData.get(position).email
        binding.textName.text = memberData.get(position).name
        binding.imageView2.setImageResource(R.drawable.man_24)

        binding.root.setOnLongClickListener(object : View.OnLongClickListener{
            override fun onLongClick(v: View?): Boolean {
                val position = holder.adapterPosition
                val deleteData = memberData.removeAt(position)
                Toast.makeText(binding.root.context, "${deleteData.name} 삭제완료", Toast.LENGTH_SHORT).show()
                notifyDataSetChanged()
                return true
            }
        })
    }
    class CustomViewHolder(val binding: ItemViewBinding): RecyclerView.ViewHolder(binding.root)
}