package com.example.bitirmeprojesi.retrofit

import retrofit2.create

class ApiUtils {
    companion object{
        val BASE_URl ="http://kasimadalan.pe.hu/"

        fun getYemeklerDao():YemeklerDao{
            return RetrofitClient.getClient(BASE_URl).create(YemeklerDao::class.java)
        }

    }
}