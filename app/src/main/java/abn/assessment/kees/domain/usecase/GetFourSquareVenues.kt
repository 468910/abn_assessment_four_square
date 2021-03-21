package abn.assessment.kees.domain.usecase

import abn.assessment.kees.data.api.repo.IFourSquareRepo
import abn.assessment.kees.domain.models.Venue
import kotlinx.coroutines.flow.Flow

/**
 * Could use a interface here but just keeping it simple for assessment purposes.
 */
class GetFourSquareVenues(private val IFourSquareRepo: IFourSquareRepo) {

    fun searchRevenues(
        near: String? = null,
    ): Flow<List<Venue>> {
        return IFourSquareRepo.searchRevenues(near)
    }
}