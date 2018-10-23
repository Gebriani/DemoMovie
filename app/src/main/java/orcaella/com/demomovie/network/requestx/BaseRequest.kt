package orcaella.com.demomovie.network.requestx

import orcaella.com.demomovie.network.RestClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class BaseRequest<T> {
    private var client = RestClient.getClient()
    private var callBack: RequestCallBack<T>? = null
    private var isViewAdded = false

    fun addView() {
        isViewAdded = true
    }

    fun addCallBack(requestCallBack: RequestCallBack<T>) {
        this.callBack = requestCallBack
    }

    fun removeView() {
        isViewAdded = false
    }

    fun isViewAdded(): Boolean {
        return isViewAdded
    }

    abstract fun requestApi()

    protected fun getClient(): RestClient.ApiService {
        return client
    }

    protected fun sendRequest(call: Call<T>) {
        call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.isSuccessful && isViewAdded) {
                    callBack!!.onRequestSuccess(response.body())
                } else if (!response.isSuccessful && isViewAdded()) {
                    callBack!!.onRequestError("An Error Has Occurred")
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                if (isViewAdded()) {
                    callBack!!.onRequestError("Connection fail, Please Try Again")
                }
            }
        })
    }
}