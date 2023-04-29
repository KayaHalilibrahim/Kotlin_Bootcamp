package com.example.bitirmeprojesi.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import com.example.bitirmeprojesi.R
import com.example.bitirmeprojesi.databinding.FragmentAnasayfaBinding
import com.example.bitirmeprojesi.ui.adapter.FoodsAdapter
import com.example.bitirmeprojesi.ui.viewmodel.AnasayfaViewModel


class AnasayfaFragment : Fragment() ,SearchView.OnQueryTextListener {
    private lateinit var binding:FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa, container, false)

        binding.ansayfaFragment=this

          binding.toolbarAnasayfaBaslik="Yemekler Ve İçecekler"

       // binding.rvAnasayfa.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

      viewModel.anasayfaYemekListesi.observe(viewLifecycleOwner){
          val adapter = FoodsAdapter(requireContext(),it,viewModel)
          binding.ansayfaAdapter=adapter
      }

        
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarAnasayfa)

        requireActivity().addMenuProvider(object : MenuProvider  {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu)

                val item = menu.findItem(R.id.action_ara)
                val searchView= item.actionView as SearchView
                searchView.setOnQueryTextListener(this@AnasayfaFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }

        },viewLifecycleOwner,Lifecycle.State.RESUMED )

binding.fabAnasayfaSepet.setOnClickListener {
    Navigation.findNavController(it).navigate(R.id.anasayfaSepet)
}


        return binding.root
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels ()
        viewModel=tempViewModel
    }



    override fun onQueryTextSubmit(query: String): Boolean {  // arama butonuna basıldığında çalışır
        ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {  // harf girdikçe ve sildikçe çalışır
        ara(newText)
        return true
    }

    fun ara(arameKelimesi:String){
        viewModel.ara(arameKelimesi)
    }

    override fun onResume() {
        super.onResume()
        viewModel.anasayfaYemekYukle()
    }

}