package com.gds.brasilnoticias.network

import com.gds.brasilnoticias.util.Constantes.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitInstancia {
    companion object{
        private val retrofit by lazy {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val cliente = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(cliente)
                .build()

        }


        val api by lazy {
            retrofit.create(NoticiasApi::class.java)
        }
    }
}