package com.example.kisileruygulamasi.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kisileruygulamasi.data.entity.CRUDCevap
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.data.entity.KisilerCevap
import com.example.kisileruygulamasi.retrofit.Apiutils
import com.example.kisileruygulamasi.retrofit.KisilerDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KisilerDaoRepository {
    var kisilerListesi:MutableLiveData<List<Kisiler>>

    var kdao:KisilerDao

    init {
        kdao=Apiutils.getKisilerDao()
        kisilerListesi = MutableLiveData()
    }

    fun kisileriGetir() : MutableLiveData<List<Kisiler>> {
        return kisilerListesi
    }

    fun kaydet(kisi_ad:String,kisi_tel:String){
       kdao.kisiEkle(kisi_ad,kisi_tel).enqueue(object : Callback<CRUDCevap>{

           override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {}

           override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {}
       })



    }
    fun guncelle(kisi_id:Int,kisi_ad:String,kisi_tel:String){
        kdao.kisiGuncelle(kisi_id,kisi_ad,kisi_tel).enqueue(object : Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {}
            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {}
        })

    }


    fun ara(aramaKelimesi:String){
        kdao.kisiAra(aramaKelimesi).enqueue(object : Callback<KisilerCevap>{
            override fun onResponse(call: Call<KisilerCevap>, response: Response<KisilerCevap>) {
                val liste = response.body()!!.kisiler
                kisilerListesi.value=liste
            }

            override fun onFailure(call: Call<KisilerCevap>, t: Throwable) {
            }
        })
    }


    fun sil(kisi_id:Int){
        kdao.kisiSil(kisi_id).enqueue(object : Callback<CRUDCevap>{

            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
                kisileriYukle()
            }


            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {}
        })

    }

    fun kisileriYukle(){
        kdao.tumKisiler().enqueue(object : Callback<KisilerCevap>{
            override fun onResponse(call: Call<KisilerCevap>, response: Response<KisilerCevap>) {
              val liste = response.body()!!.kisiler
                kisilerListesi.value=liste
            }

            override fun onFailure(call: Call<KisilerCevap>, t: Throwable) {
            }
        })
    }
}