package com.example.challangechapter3

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.challangechapter3.databinding.ItemKataBinding

class KataAdapter(var kataAdapter: ArrayList<ListKata>, var onItemClick: ((ListHuruf) -> Unit)? = null): RecyclerView.Adapter<KataAdapter.ViewHolder>(){
    class ViewHolder(var binding:ItemKataBinding):RecyclerView.ViewHolder(binding.root) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KataAdapter.ViewHolder {
        val binding = ItemKataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun getItemCount(): Int {
       return kataAdapter.size
    }

    override fun onBindViewHolder(holder: KataAdapter.ViewHolder, position: Int) {
        var a = kataAdapter[position].kata
        holder.binding.kataCon.setOnClickListener {
            val keyword = kataAdapter[position].kata
            val moveToWeb = Intent(Intent.ACTION_VIEW)
            moveToWeb.data = Uri.parse("https://www.google.com/search?q=$keyword")
            holder.binding.kataCon.context.startActivity(moveToWeb)
        }
        holder.binding.kataCon.text = a
    }
}