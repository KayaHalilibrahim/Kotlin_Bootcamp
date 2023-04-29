package com.example.bitirmeprojesi.retrofit

import com.example.bitirmeprojesi.data.entity.CRUDCevap
import com.example.bitirmeprojesi.data.entity.YemeklerCevap
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface YemeklerDao {
    //http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php
    //http://kasimadalan.pe.hu/  -> BASE URl
    //yemekler/tumYemekleriGetir.php
    //http://kasimadalan.pe.hu/yemekler/sepeteYemekEkle.php

    @GET("yemekler/tumYemekleriGetir.php")
    fun anasayfaTumYemekler() : Call<YemeklerCevap>


   @POST("yemekler/sepettekiYemekleriGetir.php")
    fun sepetYemekler(@Field ("kullanici_adi") kullanici_adi: String): Call<YemeklerCevap>



//http://kasimadalan.pe.hu/yemekler/sepettekiYemekleriGetir.php



    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    fun yemekEkle(
        @Field("yemek_adi") yemek_adi: String,
       @Field("yemek_resim_adi") yemek_resim_adi: String,
        @Field("yemek_fiyat") yemek_fiyat: String,
        @Field("yemek_siparis_adet") yemek_siparis_adet: String,
        @Field("kullanici-adi") kullanici: String,
    ): Call<CRUDCevap>


    //http://kasimadalan.pe.hu/yemekler/sepettenYemekSil.php

    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
   fun yemekSil(@Field("kullaici_adi") kullaici_adi: String,
                @Field("yemek_id")  yemek_id: String
    ): Call<CRUDCevap>





}