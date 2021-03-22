package abn.assessment.kees

import abn.assessment.kees.data.ConnectionFlow
import abn.assessment.kees.data.api.*
import abn.assessment.kees.data.repo.FourSquareRepo
import abn.assessment.kees.data.room.VenueDao
import abn.assessment.kees.data.room.VenueRoomModel
import abn.assessment.kees.domain.models.Location
import abn.assessment.kees.domain.models.Venue
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test


class FourSquareExampleTestForAssessment {


    val fakeVenue = Venue(id = "", name = "", location = Location(
        address = "",
        lat = 0.0,
        lng = 0.0,
        cc = "",
        country = "",
        formattedAddress = emptyList()
    ), categories = emptyList(), rating = null)

    val fakeConnectionFlow = object : ConnectionFlow {
        override fun getFlow(): Flow<Boolean> = MutableStateFlow(false)
    }

    /***
     * Example if faking -> could also mock no idea what you do at AbnAmro
     */
    val repo = FourSquareRepo(
        service =  object : FourSquareService {
            override suspend fun searchRevenues(
                client_secret: String,
                client_id: String,
                near: String?,
                version: Int,
                radius: Int,
                limit: Int
            ): FourSquareApiResponse<FourSquareVenues> {
                return FourSquareApiResponse(meta = Meta(0, "AAAA"), response = FourSquareVenues(
                    emptyList())
                )
            }

            override suspend fun getRevenueDetail(
                id: String,
                client_secret: String,
                client_id: String,
                version: Int
            ): FourSquareApiResponse<FourSquareVenueDetail> {
                return FourSquareApiResponse(meta = Meta(0, "AAAA"), response = FourSquareVenueDetail(
                  venue = fakeVenue
                ))
            }
        },

        venueDao = object : VenueDao {
            override suspend fun insert(pickUpPointRoomModel: List<VenueRoomModel>) {
            }

            override suspend fun insert(pickUpPointRoomModel: VenueRoomModel) {
            }

            override suspend fun findAll(city: String): List<VenueRoomModel> {
                return emptyList()
            }

            override suspend fun find(venueId: String): VenueRoomModel {
                return VenueRoomModel.mapFrom(fakeVenue)
            }

        },

        connectionFlow = fakeConnectionFlow

    )

    @Test
    fun `When Repo is empty, and no available connection, then return empty list` () = runBlocking {
            val result = repo.searchRevenues("").first()
            assert(result.isEmpty())
        }
}