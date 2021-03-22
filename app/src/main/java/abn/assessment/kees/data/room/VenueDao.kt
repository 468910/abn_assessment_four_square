package abn.assessment.kees.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface VenueDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pickUpPointRoomModel: List<VenueRoomModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pickUpPointRoomModel: VenueRoomModel)

    @Query("SELECT * FROM Venues WHERE city = :city")
    suspend fun findAll(city: String): List<VenueRoomModel>

    @Query("SELECT * FROM Venues WHERE id = :venueId")
    suspend fun find(venueId: String): VenueRoomModel

}