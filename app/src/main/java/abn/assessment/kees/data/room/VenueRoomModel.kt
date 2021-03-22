package abn.assessment.kees.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Venues")
data class VenueRoomModel(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
)