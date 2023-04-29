package com.example.bitirmeprojesi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bitirmeprojesi.data.entity.Yemekler
import com.example.bitirmeprojesi.data.repo.YemeklerDaoRepository

class SepetViewmodel: ViewModel()  {
    val krepo =YemeklerDaoRepository()
    var sepetYemekListesi: MutableLiveData<List<Yemekler>>

    init{
       yemekleriYukle()
        sepetYemekListesi= krepo.yemekleriGetir()
    }


    fun sil(yemek_id: String){
        krepo.sil(yemek_id)

    }


    fun yemekleriYukle(){
        krepo.yemekleriYukle()
    }



}