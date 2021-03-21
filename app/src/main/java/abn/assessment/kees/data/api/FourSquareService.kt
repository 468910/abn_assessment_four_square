package abn.assessment.kees.data.api

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface FourSquareService {

    @GET("venues/search")
    suspend fun searchRevenues(
        @Query("client_secret") client_secret: String,
        @Query("client_id") client_id: String,
        @Query("near") near: String? = null,
        @Query("v") version: Int = 20180323,
        @Query("radius") radius: Int = 1000,
        @Query("limit") limit: Int = 10,
    ): FourSquareApiResponse<FourSquareVenues>


    companion object {
        const val baseUrl = "https://api.foursquare.com/v2/"

        fun create(): FourSquareService {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(OkHttpClient.Builder().build())
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .build()
                .create(FourSquareService::class.java)
        }
    }
}