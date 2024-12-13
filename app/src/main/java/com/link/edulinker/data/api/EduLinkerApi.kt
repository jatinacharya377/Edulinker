package com.link.edulinker.data.api

import com.link.edulinker.data.model.DashboardDetails
import retrofit2.Response
import retrofit2.http.GET

interface EduLinkerApi {
    @GET("api/v1/dashboardNew")
    suspend fun fetchDashboardDetails() : Response<DashboardDetails>
}