package blankthings.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore

abstract class BaseViewModel : ViewModel() {

    val database = FirebaseFirestore.getInstance()
    val loadingLiveData: MutableLiveData<Boolean> = MutableLiveData()

    fun showLoading(show: Boolean) {
        loadingLiveData.value = show
    }

}