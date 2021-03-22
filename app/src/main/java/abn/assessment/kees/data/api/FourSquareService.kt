package abn.assessment.kees.data.api

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FourSquareService {

    @GET("venues/search")
    suspend fun searchRevenues(
        @Query("client_secret") client_secret: String = FourSquareService.client_secret,
        @Query("client_id") client_id: String = FourSquareService.client_id,
        @Query("near") near: String? = null,
        @Query("v") version: Int = 20180323,
        @Query("radius") radius: Int = 1000,
        @Query("limit") limit: Int = 10,
    ): FourSquareApiResponse<FourSquareVenues>

    @GET("venues/{VENUE_ID}")
    suspend fun getRevenueDetail(
        @Path("VENUE_ID") id: String,
        @Query("client_secret") client_secret: String = FourSquareService.client_secret,
        @Query("client_id") client_id: String = FourSquareService.client_id,
        @Query("v") version: Int = 20180323,
    ): FourSquareApiResponse<FourSquareVenueDetail>


    companion object {
        const val baseUrl = "https://api.foursquare.com/v2/"
        /**
         * I dont care about these credentials but if you would want to hide them add a C++ module
         * or Proxy server
         */
        const val client_id = "SG32E3FM4BXEKGYWKKP1VTN4OYHJRIDN0ZBTHEJLLN0PF533"
        const val client_secret = "VLF2RKWPMME1CWIRRKJOONNQXH5SEBFFHXFCVEUV1DCTZH01"

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