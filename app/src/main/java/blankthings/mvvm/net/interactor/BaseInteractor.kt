package blankthings.mvvm.net.interactor

import blankthings.mvvm.net.api.ApiService

abstract class BaseInteractor {

    val apiService : ApiService = ApiService.create()

}
