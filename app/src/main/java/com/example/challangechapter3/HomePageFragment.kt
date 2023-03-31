@file:Suppress("UNREACHABLE_CODE")

package com.example.challangechapter3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challangechapter3.databinding.FragmentHomePageBinding


class HomePageFragment : Fragment(){
    lateinit var binding: FragmentHomePageBinding
    val kumpulanHuruf = ArrayList<ListHuruf>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomePageBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.huruf.layoutManager = LinearLayoutManager(context)
        val kumpulanKataFrag = halaman2Fragment()
        val listAbjadAdapter = HurufAdapter(kumpulanHuruf)
        listAbjadAdapter.onItemClick = {

            findNavController().navigate(R.id.action_homePageFragment_to_halaman2Fragment)
        }
        binding.huruf.adapter = listAbjadAdapter
        kumpulanHuruf.clear()
        kumpulanHuruf.addAll(getlisthuruf())
        getlisthuruf()



    }
    private fun getlisthuruf(): ArrayList<ListHuruf> {
        val dataNama = resources.getStringArray(R.array.dataHuruf)
        val listHuruf = ArrayList<ListHuruf>()

        for (i in dataNama.indices) {
            val huruf = ListHuruf(dataNama[i])
            listHuruf.add(huruf)
        }
        return listHuruf
    }


}




