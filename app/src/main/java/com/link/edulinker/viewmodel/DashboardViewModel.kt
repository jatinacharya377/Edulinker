package com.link.edulinker.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.link.edulinker.data.model.DashboardDetails
import com.link.edulinker.data.model.Link
import com.link.edulinker.data.repository.DashboardRepository
import com.link.edulinker.utils.UiData

class DashboardViewModel(application: Application) : ViewModelBase(application) {

    private val _dashboardDetails = MutableLiveData<UiData<DashboardDetails>>()
    val dashboardDetails: LiveData<UiData<DashboardDetails>>
        get() = _dashboardDetails
    private val repository by lazy { getRepository(DashboardRepository::class.java) }

    val recentLinks = ArrayList<Link>()
    var selectedLink = 1
    val topLinks = ArrayList<Link>()
    var whatsAppNo = ""

    init {
        fetchDashboardDetails()
    }

    private fun fetchDashboardDetails() {
        launchCoroutineScope {
            clearErrorCallback()
            _dashboardDetails.postValue(UiData.Loading())
            val response = repository.fetchDashboardDetails()
            if (response.isSuccessful) {
                response.body()?.let { data ->
                    _dashboardDetails.postValue(UiData.Success(data))
                }
            }
        }
    }

    override fun onCreate() {}
}