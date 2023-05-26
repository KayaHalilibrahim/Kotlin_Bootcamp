package com.example.bitirmeprojesi.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.bitirmeprojesi.data.entity.CRUDCevap
import com.example.bitirmeprojesi.data.entity.Yemekler
import com.example.bitirmeprojesi.data.entity.YemeklerCevap
import com.example.bitirmeprojesi.retrofit.ApiUtils
import com.example.bitirmeprojesi.retrofit.YemeklerDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class YemeklerDaoRepository {

    var sepetYemekListesi: MutableLiveData<List<Yemekler>>
    var anasayfaYemekListesi: MutableLiveData<List<Yemekler>>
    var ydao:YemeklerDao

    init {
        ydao=ApiUtils.getYemeklerDao()
        sepetYemekListesi = MutableLiveData()
        anasayfaYemekListesi= MutableLiveData()  // anasayfadaki yemekler  -tum yemekler
    }

    fun yemekleriGetir(): MutableLiveData<List<Yemekler>> {
        return sepetYemekListesi
    }

    fun anasayfayemekleriGetir(): MutableLiveData<List<Yemekler>>{
        return anasayfaYemekListesi
    }

    fun sepeteEkle(yemek_Ad: String, yemek_Fiyat: String,yemek_resim_ad:String,yemek_siparis_adet:String,kulllanici_adi:String){
     /*   ydao.yemekEkle(yemek_Ad,yemek_Fiyat, yemek_resim_ad,yemek_siparis_adet,"halil_ibrahim_kaya")
            .enqueue(object : Callback<CRUDCevap>{
                override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {}

                override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {}

            })

      */

        
    }

    fun ara(arameKelimesi: String) {
        Log.e("Yemek Ara", arameKelimesi)
    }

    fun sil(yemekid: String) {

   /* ydao.yemekSil(kullaici_adi = "halil_ibrahim_kaya",yemekid).enqueue(object : Callback<CRUDCevap>{
        override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
            yemekleriYukle()
        }

        override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {}
    })
        */



      Log.e("Yemek Sil", yemekid.toString())
    }


    fun yemekleriYukle() {


       val liste = ArrayList<Yemekler>()

        val y1 = Yemekler("1","Tavuk ızgara","izgaratavuk","60.00","1","")
        val y2 = Yemekler("2","pizza","pizza","10.00","1","")
        val y3 = Yemekler("8","Kadayıf","kadayif","50.00","1","")
        val y4 = Yemekler("9","Sütlaç","sutlac","60.00","2","")
        val y5 = Yemekler("11","Su","su","10.00","2","")
        val y6 = Yemekler("13","Fanta","fanta","15.00","1","")

       liste.add(y1)
       liste.add(y2)
       liste.add(y3)
       liste.add(y4)
       liste.add(y5)
       liste.add(y6)

       sepetYemekListesi.value = liste


/*

        ydao.sepetYemekler("halil_ibrahim_kaya").enqueue(object : Callback<YemeklerCevap>{
            override fun onResponse(call: Call<YemeklerCevap>, response: Response<YemeklerCevap>) {
                val liste = response.body()!!.yemekler
                sepetYemekListesi.value=liste
            }

            override fun onFailure(call: Call<YemeklerCevap>, t: Throwable) {}
        })



 */

    }





    fun anasayfaYemekYukle(){



    ydao.anasayfaTumYemekler().enqueue(object  : Callback<YemeklerCevap> {
        override fun onResponse(call: Call<YemeklerCevap>, response: Response<YemeklerCevap>) {
            val listt= response.body()!!.yemekler
            anasayfaYemekListesi.value= listt
        }

        override fun onFailure(call: Call<YemeklerCevap>, t: Throwable) {

        }
    })




/*
        val liste2 =ArrayList<Yemekler>()
        val f1 = Yemekler("1","Izgara Somon","izgarasomon","75.00","","")
        val f2 = Yemekler("2","pizza","pizza","10.00","","")
        val f3 = Yemekler("3","Köfte","kofte","80.00","","")
        val f4 = Yemekler("4","lazanya","lazanya","65.00","","")
        val f5 = Yemekler("5","makarna","makarna","10.00","","")
        val f6 = Yemekler("6","Tavuk ızgara","izgaratavuk","60.00","","")
        val f7 = Yemekler("7","Baklava","baklava","140.00","","")
        val f8 = Yemekler("8","Kadayıf","kadayif","50.00","","")
        val f9 = Yemekler("9","Sütlaç","sutlac","30.00","","")
        val f10 = Yemekler("10","Tiramisu","tiramisu","30.00","","")
        val f11 = Yemekler("11","Su","su","5.00","","")
        val f12 = Yemekler("12","Ayran","ayran","10.00","","")
        val f13 = Yemekler("13","Fanta","fanta","15.00","","")
        val f14 = Yemekler("14","Kahve","kahve","20.00","","")


        liste2.add(f1)
        liste2.add(f2)
        liste2.add(f3)
        liste2.add(f4)
        liste2.add(f5)
        liste2.add(f6)
        liste2.add(f7)
        liste2.add(f8)
        liste2.add(f9)
        liste2.add(f10)
        liste2.add(f11)
        liste2.add(f12)
        liste2.add(f13)
        liste2.add(f14)


        anasayfaYemekListesi.value = liste2



 */


    }
}