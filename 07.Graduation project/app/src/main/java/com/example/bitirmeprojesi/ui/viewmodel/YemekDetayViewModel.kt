package com.example.bitirmeprojesi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.bitirmeprojesi.data.repo.YemeklerDaoRepository

class YemekDetayViewModel: ViewModel()  {

    val krepo=YemeklerDaoRepository()



    fun sepeteEkle(yemek_Ad: String, yemek_Fiyat: String,yemek_resim_ad:String,yemek_siparis_adet:String,kulllanici_adi:String){
        krepo.sepeteEkle(yemek_Ad,yemek_Fiyat, yemek_resim_ad,yemek_siparis_adet,kulllanici_adi)
    }
}