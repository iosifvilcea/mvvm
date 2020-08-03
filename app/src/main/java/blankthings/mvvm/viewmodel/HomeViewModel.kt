package blankthings.mvvm.viewmodel

import android.util.Log
import blankthings.mvvm.net.data.Data
import blankthings.mvvm.viewmodel.BaseViewModel

class HomeViewModel : BaseViewModel() {

    fun setupDb() {
        database.collection("coins")
            .get()
            .addOnSuccessListener { documentRef ->
                for (document in documentRef) {
                    Log.e("TAGG", "Doc data -> " + document.data)
                }
            }
            .addOnFailureListener { exception ->
                Log.e("TAGG", "Error getting documents.", exception)
            }
    }

}
