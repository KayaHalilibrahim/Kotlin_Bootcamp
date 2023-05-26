package com.example.kisileruygulamasi.retrofit

class Apiutils {

    companion object{
        val BASE_URL="http://kasimadalan.pe.hu/"

        fun getKisilerDao(): KisilerDao{
            return RetrofitClient.getClient(BASE_URL).create(KisilerDao::class.java)
        }
    }
}