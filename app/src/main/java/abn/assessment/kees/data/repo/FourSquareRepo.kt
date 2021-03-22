package abn.assessment.kees.data.repo

import abn.assessment.kees.data.ConnectionFlow
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
    private val connectionFlow: ConnectionFlow
) : IFourSquareRepo {

    override fun searchRevenues(city: String): Flow<List<Venue>> {
        return connectionFlow.getFlow().map { isOnline ->
            var venues = venueDao.findAll(city).map { Venue.mapFrom(it) }
            if (isOnline) {
                try {
                    val retrievedVenues = service.searchRevenues(near = city).response.venues
                    venueDao.insert(retrievedVenues.map { VenueRoomModel.mapFrom(it) })
                    if (retrievedVenues.isNotEmpty()) {
                        venues = retrievedVenues
                    }
                } catch (exception: Exception) {

                }
            }
            return@map venues
        }.catch {

        }
    }

    override suspend fun getRevenueDetail(venueId: String): Flow<Venue> {
        return connectionFlow.getFlow().map { isOnline ->
            var venue = Venue.mapFrom(venueDao.find(venueId))
            if (isOnline) {
                try {
                    val retrievedVenue = service.getRevenueDetail(id = venueId).response.venue
                    venueDao.insert(VenueRoomModel.mapFrom(venue))
                    venue = retrievedVenue
                } catch (exception: Exception) {
                    // 429 prolly if rate reached
                }
            }
            venue
        }.catch {

        }
    }
}