package abn.assessment.kees.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [
        VenueRoomModel::class,
    ],
    version = 1,
    exportSchema = true)
@TypeConverters(Converters::class)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun venueDao(): VenueDao
}

