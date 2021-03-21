package abn.assessment.kees.data.api

import abn.assessment.kees.data.models.Venue

data class FourSquareApiResponse<T>(
    val meta : Meta,
    val response: T
)

data class FourSquareVenues(
    val venues: List<Venue>
)

data class Meta(
    val code: Int,
    val requestId: String
)
