package blankthings.mvvm.net.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import blankthings.mvvm.net.data.Data

@Database(entities = [Data::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        private const val DB_NAME = "app.db"
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context) : AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        DB_NAME).build()
            }

            return instance!!
        }
    }


    abstract fun dataDao() : DataDao

}