package com.example.filmleruygulamasi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.filmleruygulamasi.R
import com.example.filmleruygulamasi.databinding.FragmentAnasayfaBinding
import com.example.filmleruygulamasi.databinding.FragmentDetayBinding
import com.google.android.material.snackbar.Snackbar


class DetayFragment : Fragment() {

private lateinit var binding: FragmentDetayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentDetayBinding.inflate(inflater,container,false)

        val bundle:DetayFragmentArgs by navArgs()
        val gelenFilm = bundle.film

        binding.toolbarDetay.title= gelenFilm.adi

        binding.ivFilmResim.setImageResource(resources.getIdentifier(gelenFilm.resim_adi,"drawable",requireContext().packageName))

        binding.tvFilmYNetmen.text= gelenFilm.yonetmen
        binding.tvFilmYil.text=gelenFilm.yil.toString()
        binding.tvFilmFiyat.text="${gelenFilm.fiyat}"

        binding.btnSepeteEkle.setOnClickListener {
            Snackbar.make(it,"${gelenFilm.adi} sepete eklendi",Snackbar.LENGTH_LONG).show()
        }

        return binding.root
    }
}
