package com.yildirimtechnologies.not_alma_uygulamas

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yildirimtechnologies.not_alma_uygulamas.databinding.RecyclerRowBinding

class NotAdapter(val notList: List<Notlar>) : RecyclerView.Adapter<NotAdapter.NotHolder> (){
    class NotHolder(val recyclerRowBinding: RecyclerRowBinding) : RecyclerView.ViewHolder(recyclerRowBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotHolder {
        val recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NotHolder(recyclerRowBinding)
    }

    override fun getItemCount(): Int {
        return notList.size
    }

    override fun onBindViewHolder(holder: NotHolder, position: Int) {
        holder.recyclerRowBinding.recyclerViewTextView.text = notList.get(position).baslik
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,DetayActivity::class.java)
            holder.itemView.context.startActivity(intent)
        }
    }
}