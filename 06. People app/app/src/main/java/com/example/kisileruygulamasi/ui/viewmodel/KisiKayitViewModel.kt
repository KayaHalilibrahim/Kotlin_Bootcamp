package com.example.kisileruygulamasi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.data.repo.KisilerDaoRepository

class KisiKayitViewModel : ViewModel() {
    val krepo = KisilerDaoRepository()

    fun kaydet(kisi_ad:String,kisi_tel:String){
        krepo.kaydet(kisi_ad,kisi_tel)
    }
}