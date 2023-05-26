package com.example.bitirmeprojesi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bitirmeprojesi.data.entity.Yemekler
import com.example.bitirmeprojesi.data.repo.YemeklerDaoRepository

class AnasayfaViewModel:ViewModel() {
    val krepo = YemeklerDaoRepository()
    var anasayfaYemekListesi: MutableLiveData<List<Yemekler>>

    init {
        anasayfaYemekYukle()
        anasayfaYemekListesi= krepo.anasayfayemekleriGetir()  // anasayfadaki yemekler  -tum yemekler
    }


    fun ara(arameKelimesi:String){
        krepo.ara(arameKelimesi)
    }

    fun anasayfaYemekYukle(){
        krepo.anasayfaYemekYukle()

    }



}