package com.example.challangechapter3


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.challangechapter3.databinding.ItemHurufBinding
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView



class HurufAdapter(var listHuruf: ArrayList<ListHuruf>, var onItemClick: ((ListHuruf) -> Unit)? = null): RecyclerView.Adapter<HurufAdapter.ViewHolder>() {
    class ViewHolder(var binding:ItemHurufBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHurufBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var a = listHuruf[position].huruf
        holder.binding.hurufCon.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                val transaction = p0?.context as AppCompatActivity
                val bundle = Bundle()
                //
                bundle.putString("HURUF", a)
                val kumpulanKataFrag = halaman2Fragment()
                kumpulanKataFrag.arguments = bundle
                transaction.supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, kumpulanKataFrag)
                    .addToBackStack(null)
                    .commit()
            }
        })

        holder.binding.hurufCon.text = a
    }


    override fun getItemCount(): Int {
        return listHuruf.size
    }

}






