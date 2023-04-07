package com.example.flouygulamasi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.flouygulamasi.R
import com.example.flouygulamasi.databinding.FragmentAnasayfaBinding
import com.example.flouygulamasi.databinding.FragmentDetayBinding
import com.google.android.material.snackbar.Snackbar


class DetayFragment : Fragment() {

    private lateinit var binding: FragmentDetayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentDetayBinding.inflate(inflater, container, false)


        val bundle: DetayFragmentArgs by navArgs()
        val gelenAyakkabi=bundle.ayakkabi

        binding.toolbarDetay.title=gelenAyakkabi.marka
        binding.ivAyakkabiResim.setImageResource(
            resources.getIdentifier(gelenAyakkabi.adi,"drawable",requireContext().packageName))


        binding.tvFiyat.text ="${gelenAyakkabi.fiyat} Tl"

        binding.buttonSepeteEkle.setOnClickListener {
            Snackbar.make(it,"${gelenAyakkabi.adi} sepete eklendi",Snackbar.LENGTH_LONG).show()
        }



        return binding.root
    }

}