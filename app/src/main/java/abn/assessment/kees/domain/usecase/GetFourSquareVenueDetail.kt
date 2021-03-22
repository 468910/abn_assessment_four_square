package abn.assessment.kees.domain.usecase

import abn.assessment.kees.data.repo.IFourSquareRepo
import abn.assessment.kees.domain.models.Venue
import kotlinx.coroutines.flow.Flow

/**
 * Could use a interface here but just keeping it simple for assessment purposes.
 */
class GetFourSquareVenueDetail(private val iFourSquareRepo: IFourSquareRepo) {

    suspend fun getRevenueDetail(venueId: String): Flow<Venue> {
        return iFourSquareRepo.getRevenueDetail(venueId = venueId)
    }

}