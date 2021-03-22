package abn.assessment.kees.data.room

import abn.assessment.kees.domain.models.Venue
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Venues")
data class VenueRoomModel(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
    val rating: String? = null,
    val phone : String? = null,
    val address: String? = null,
    val formattedPhone: String? = null
    ) {
    companion object {
        fun mapFrom(venue: Venue) : VenueRoomModel{
            return VenueRoomModel(
                id = venue.id,
                name = venue.name,
            )
        }
    }
}