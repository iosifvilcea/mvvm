package blankthings.mvvm.net.db

import androidx.room.Dao
import androidx.room.Query
import blankthings.mvvm.net.data.Data

@Dao
interface DataDao {

    @Query("SELECT * FROM data")
    fun getAll(): List<Data>

}