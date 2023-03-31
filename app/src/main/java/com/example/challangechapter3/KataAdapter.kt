package com.example.challangechapter3

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

import com.example.challangechapter3.databinding.ItemKataBinding

class KataAdapter(var kataAdapter: ArrayList<ListKata>, var onItemClick: ((ListKata) -> Unit)? = null): RecyclerView.Adapter<KataAdapter.ViewHolder>(){
    class ViewHolder(var binding:ItemKataBinding):RecyclerView.ViewHolder(binding.root) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KataAdapter.ViewHolder {
        val binding = ItemKataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun getItemCount(): Int {
       return kataAdapter.size
    }

    override fun onBindViewHolder(holder: KataAdapter.ViewHolder, @SuppressLint("RecyclerView") position:Int) {
        var a = kataAdapter[position].kata
        holder.binding.kataCon.setOnClickListener (object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val transaction = p0?.context as AppCompatActivity
                val keyword = kataAdapter[position].kata
                val moveToWeb = Intent(Intent.ACTION_VIEW)
                moveToWeb.data = Uri.parse("https://www.google.com/search?q=$keyword")
                transaction.startActivity(moveToWeb)
            }
        })
        holder.binding.kataCon.text = a
    }
}