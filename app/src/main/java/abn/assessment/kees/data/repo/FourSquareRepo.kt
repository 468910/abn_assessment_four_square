package abn.assessment.kees.data.repo

import abn.assessment.kees.data.ConnectionLiveData
import abn.assessment.kees.data.api.FourSquareService
import abn.assessment.kees.data.room.VenueDao
import abn.assessment.kees.data.room.VenueRoomModel
import abn.assessment.kees.domain.models.Venue
import androidx.lifecycle.asFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class FourSquareRepo(
    private val service: FourSquareService,
    private val venueDao: VenueDao,
    private val connectionLiveData: ConnectionLiveData
) : IFourSquareRepo {

    override fun searchRevenues(near: String?): Flow<List<Venue>> {
        return connectionLiveData.asFlow().map { isOnline ->
            if(!isOnline) {
                val cachedData = venueDao.findAll()
                return@map cachedData.map { Venue.mapFrom(it) }
            } else {
                val revenues = service.searchRevenues(near = near).response.venues
                try {
                    venueDao.insert(revenues.map { VenueRoomModel.mapFrom(it) })
                } catch (exception : Exception) {
                    val x = exception
                }
                revenues
            }
        }.catch {
            print("hey")
            print("hey")
        }
    }

    override suspend fun getRevenueDetail(venueId: String): Flow<Venue> {
        return connectionLiveData.asFlow().map { isOnline ->
            if(!isOnline) {
                val cachedData = venueDao.find(venueId)
                return@map Venue.mapFrom(cachedData)
            } else {
                val venue = service.getRevenueDetail(id = venueId).response.venue
                try {
                    venueDao.insert(VenueRoomModel.mapFrom(venue))
                } catch (exception : Exception) {
                    val x = exception
                }
                venue
            }
        }.catch {
            print("hey")
            print("hey")
        }
    }
}