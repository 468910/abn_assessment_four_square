package abn.assessment.kees.data.api.repo

import abn.assessment.kees.data.api.FourSquareService
import abn.assessment.kees.domain.models.Venue
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FourSquareRepo(val service: FourSquareService, val offlineFourSquareService: OfflineFourSquareService) : IFourSquareRepo {

    override fun searchRevenues(near: String?): Flow<List<Venue>> {
        return flow {
            val revenues = service.searchRevenues(near = near).response.venues
            emit(revenues)
        }
    }

    override suspend fun getRevenueDetail(venueId: String): Venue {
        return service.getRevenueDetail(id = venueId).response.venue
    }
}