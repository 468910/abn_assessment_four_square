package abn.assessment.kees.domain.usecase

import abn.assessment.kees.data.repo.IFourSquareRepo
import abn.assessment.kees.domain.models.Venue

/**
 * Could use a interface here but just keeping it simple for assessment purposes.
 */
class GetFourSquareVenueDetail(val IFourSquareRepo: IFourSquareRepo) {

    suspend fun getRevenueDetail(venueId: String): Venue {
        return IFourSquareRepo.getRevenueDetail(venueId = venueId)
    }

}