package com.example.bitirmeprojesi.ui.fragment

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.bitirmeprojesi.R
import com.example.bitirmeprojesi.data.entity.Yemekler
import com.example.bitirmeprojesi.databinding.FragmentDetayBinding
import com.example.bitirmeprojesi.ui.viewmodel.YemekDetayViewModel
import com.google.android.material.snackbar.Snackbar


//kayıt gibi davranacak


class DetayFragment : Fragment() {
    private lateinit var binding: FragmentDetayBinding
    private lateinit var viewModel: YemekDetayViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_detay, container, false)

        binding.detayFragment=this

        //  ------------yemek resmi için ----------------
        val bundle :DetayFragmentArgs by navArgs()
        val gelenYemek = bundle.yemek


        binding.detayToolbarBaslik=gelenYemek.yemek_adi

     //   binding.yemekNesnesi=gelenYemek

        binding.tvYemekAdi.text=gelenYemek.yemek_adi
        binding.tvFiyat.text="${gelenYemek.yemek_fiyat} ₺"

        binding.ivDetayResim.setImageResource(
           resources.getIdentifier(gelenYemek.yemek_resim_adi,"drawable",requireContext().packageName))


      binding.fabFavo.setOnClickListener{
           Snackbar.make(it,"${gelenYemek.yemek_adi} favorileri eklendi",Snackbar.LENGTH_LONG ).show()
        }

        binding.buttonSepeteEkle.setOnClickListener {
            Snackbar.make(it,"${gelenYemek.yemek_adi} sepete eklendi",Snackbar.LENGTH_LONG).show()
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:YemekDetayViewModel by viewModels ()
        viewModel=tempViewModel
    }


    fun sepeteEkle(yemek_Ad: String, yemek_Fiyat: String,yemek_resim_ad:String,yemek_siparis_adet:String,kulllanici_adi:String){
        viewModel.sepeteEkle(yemek_Ad,yemek_Fiyat, yemek_resim_ad,yemek_siparis_adet,"halil_ibrahim_kaya")
    }


        fun fabSepeteDetay(it: View) {
            Navigation.findNavController(it).navigate(R.id.detaySepetGecis)
        }



}