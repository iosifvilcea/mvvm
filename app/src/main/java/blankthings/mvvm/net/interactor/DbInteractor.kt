package blankthings.mvvm.net.interactor

import android.content.Context
import blankthings.mvvm.net.db.AppDatabase
import blankthings.mvvm.net.db.DataDao

class DbInteractor(context: Context) {
    private val db = AppDatabase.getInstance(context)
    fun getDataDao() : DataDao = db.dataDao()
}