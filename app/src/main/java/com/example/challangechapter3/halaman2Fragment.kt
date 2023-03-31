package com.example.challangechapter3

import android.app.ActionBar
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challangechapter3.databinding.FragmentHalaman2Binding


@Suppress("DEPRECATION")
class halaman2Fragment() : Fragment() {
    lateinit var binding: FragmentHalaman2Binding
    val kumpulanKata = ArrayList<ListKata>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHalaman2Binding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.kata.layoutManager = LinearLayoutManager(context)
        val listKataAdapter = KataAdapter(kumpulanKata)
        listKataAdapter.onItemClick = {
            val pindahweb = Intent(Intent.ACTION_VIEW)
            pindahweb.data = Uri.parse("https://www.google.com/search?q=${getlisthuruf()}")
            findNavController().navigate(NavDeepLinkRequest(pindahweb))
        }
        getlisthuruf()
        binding.kata.adapter = listKataAdapter
        kumpulanKata.clear()
        kumpulanKata.addAll(getlisthuruf())



    }
    private fun getlisthuruf(): ArrayList<ListKata>{
        val args = this.arguments
        val data = args?.get("HURUF")
        val kata = resources.getStringArray(R.array.dataKata)
        val getListKata = ArrayList<ListKata>()
            for(i in kata.indices){
                val indexpertama = kata[i].take(1)
                if (indexpertama == data){
                    val dataKata = ListKata(kata[i])
                    getListKata.add(dataKata)
                }
            }
        return getListKata
    }

}






