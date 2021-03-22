package abn.assessment.kees.ui.model

import abn.assessment.kees.domain.models.Venue

data class FourSquareVenueDetailUIModel(
    val titleAndRating: String,
    val address: String?,
    val phoneNumber: String?,
    val imageUrl: String?
) {

    companion object {
        fun map(venue: Venue) : FourSquareVenueDetailUIModel {
            return FourSquareVenueDetailUIModel(
                titleAndRating = venue.name + " - " + venue.rating,
                address = venue.location.address,
                phoneNumber = venue.contact?.formattedPhone,
                imageUrl = venue.bestPhoto?.getImageUrl()
            )
        }
    }
}