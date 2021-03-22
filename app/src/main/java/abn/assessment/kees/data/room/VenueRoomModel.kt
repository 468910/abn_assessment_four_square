package abn.assessment.kees.data.room

import abn.assessment.kees.domain.models.BestPhoto
import abn.assessment.kees.domain.models.Venue
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Venues")
data class VenueRoomModel(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val city: String? = null,
    val name: String,
    val rating: String? = null,
    val phone : String? = null,
    val address: String? = null,
    val formattedPhone: String? = null,
    val prefix: String? = null,
    val suffix: String? = null
    ) {
    companion object {
        fun mapFrom(venue: Venue) : VenueRoomModel{
            return VenueRoomModel(
                id = venue.id,
                name = venue.name,
                city = venue.location.city,
                rating = venue.rating,
                address = venue.location.address,
                phone = venue.contact?.formattedPhone,
                prefix = venue.bestPhoto?.prefix,
                suffix = venue.bestPhoto?.suffix
            )
        }
    }
}