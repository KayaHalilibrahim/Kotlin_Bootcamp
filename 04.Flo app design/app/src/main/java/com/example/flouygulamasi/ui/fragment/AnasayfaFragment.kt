package com.example.flouygulamasi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.flouygulamasi.R
import com.example.flouygulamasi.data.Ayakkabilar
import com.example.flouygulamasi.databinding.FragmentAnasayfaBinding
import com.example.flouygulamasi.ui.Adapter.AyakkabiAdapter


class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.rv.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        val ayakkabilarListesi =ArrayList<Ayakkabilar>()

        val A1 = Ayakkabilar("resim_3","kinetix","siyah",41,549.99)
        val A2 = Ayakkabilar("resim_7","Adidas","Beyaz",42,399.99)
        val A3 = Ayakkabilar("resim_1","Puma","Lacivert",31,659.99)
        val A4 = Ayakkabilar("resim_4","Puma","siyah",40,450.99)
        val A5 = Ayakkabilar("resim_5","Defacto","Lacivert",39,339.99)
        val A6 = Ayakkabilar("resim_6","Nike","siyah",42,449.99)

        ayakkabilarListesi.add(A1)
        ayakkabilarListesi.add(A2)
        ayakkabilarListesi.add(A3)
        ayakkabilarListesi.add(A4)
        ayakkabilarListesi.add(A5)
        ayakkabilarListesi.add(A6)

        val adapter=AyakkabiAdapter(requireContext(),ayakkabilarListesi)
        binding.rv.adapter=adapter
        return binding.root
    }
}