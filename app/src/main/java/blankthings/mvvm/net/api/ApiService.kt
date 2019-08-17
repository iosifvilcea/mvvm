package blankthings.mvvm.net.api

import blankthings.mvvm.BuildConfig
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    companion object {

        private const val SANDBOX_URL = "sandbox.coinmarketcap.com"
        private const val PROD_URL = "pro.coinmarketcap.com"

        fun create() : ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(SANDBOX_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }

    @Headers("X-CMC_PRO_API_KEY", BuildConfig.CMC_KEY)
    @GET("/v1/cryptocurrency/listings/latest")
    suspend fun getListings(): Response<String>

}