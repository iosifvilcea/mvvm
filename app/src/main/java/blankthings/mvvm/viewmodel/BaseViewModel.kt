package blankthings.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    val loadingLiveData: MutableLiveData<Boolean> = MutableLiveData()

    fun showLoading(show: Boolean) {
        loadingLiveData.value = show
    }

}