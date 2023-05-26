package com.example.bitirmeprojesi.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.bitirmeprojesi.R
import com.example.bitirmeprojesi.data.entity.Yemekler
import com.example.bitirmeprojesi.databinding.FragmentSepetBinding
import com.example.bitirmeprojesi.ui.adapter.FoodsAdapter
import com.example.bitirmeprojesi.ui.adapter.YemeklerAdapter
import com.example.bitirmeprojesi.ui.viewmodel.AnasayfaViewModel



import com.example.bitirmeprojesi.ui.viewmodel.SepetViewmodel

//anasayfa gibi davranacak


class SepetFragment : Fragment() {
    private lateinit var binding:FragmentSepetBinding
    private lateinit var viewModel:SepetViewmodel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_sepet, container, false)


        binding.sepetFragment=this

        binding.sepetToolbarBaslik="Sepetim"

        //  binding.rvSepet.layoutManager= LinearLayoutManager(requireContext())


    /*    val yemekListesi = ArrayList<Yemekler>()
        val y1 = Yemekler(1,"ayran","Ayran","10.00")
        val y2 = Yemekler(2,"baklava","Baklava","50.00")
        val y3 = Yemekler(3,"fanta","Fanta","10.00")
        val y4 = Yemekler(4,"izgarasomon","Somon Izgara","60.00")

        yemekListesi.add(y1)
        yemekListesi.add(y2)
        yemekListesi.add(y3)
        yemekListesi.add(y4)
*/

        viewModel.sepetYemekListesi.observe(viewLifecycleOwner){
            val adapter =YemeklerAdapter(requireContext(),it,viewModel)
            binding.yemeklerAdapter=adapter
        }




        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel :SepetViewmodel by viewModels()
        viewModel=tempViewModel
    }

   override fun onResume() {
        super.onResume()
        viewModel.yemekleriYukle()
    }

}