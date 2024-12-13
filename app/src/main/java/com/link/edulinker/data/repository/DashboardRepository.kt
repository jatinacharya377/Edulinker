package com.link.edulinker.data.repository

import com.link.edulinker.data.model.DashboardDetails
import retrofit2.Response

class DashboardRepository : RepositoryBase() {

    suspend fun fetchDashboardDetails() : Response<DashboardDetails> {
        return makeApiCall { it.fetchDashboardDetails() }
    }
}