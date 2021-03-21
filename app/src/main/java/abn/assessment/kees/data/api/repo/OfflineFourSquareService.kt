package abn.assessment.kees.data.api.repo

import abn.assessment.kees.domain.models.Venue
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject


/**
 * Using shared preferences as this is an Assessment could/would use Room/Realm
 */
class OfflineFourSquareService(val sharedPreferences: SharedPreferences) {
    fun searchRevenues(near: String?): List<Venue> {
        return retrieve()[near]!!
    }

    suspend fun getRevenueDetail(venueId: String): Venue {
        val venues = retrieveListOfVenueForLocation()
        /*venues.values.forEach {

        }*/
    }


    fun storeListOfVenueForLocation(location: String, venues: List<Venue>) {
        val map = retrieveListOfVenueForLocation()
        map[location] = venues
        val jsonString: String  = Gson().toJson(map)
        sharedPreferences.edit().putString("KEY_MAP_SAVE", jsonString).apply()

    }

    fun retrieveListOfVenueForLocation() : MutableMap<String, List<Venue>> {
        val jsonString: String = sharedPreferences.getString("KEY_MAP_SAVE", JSONObject().toString())!!
        val listType = object : TypeToken<Map<String, List<Venue>>>() {}.type
        return Gson().fromJson(jsonString, listType)
    }
}