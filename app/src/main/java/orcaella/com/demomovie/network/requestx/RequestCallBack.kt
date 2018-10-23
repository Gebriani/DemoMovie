package orcaella.com.demomovie.network.requestx

interface RequestCallBack<T> {
    fun onRequestSuccess(response: T)

    fun onRequestError(message: String)
}