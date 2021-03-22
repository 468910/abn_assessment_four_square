package abn.assessment.kees.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface VenueDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pickUpPointRoomModel: List<VenueRoomModel>)

    @Query("SELECT * FROM Venues")
    fun findAllFlow(): Flow<List<VenueRoomModel>>

}