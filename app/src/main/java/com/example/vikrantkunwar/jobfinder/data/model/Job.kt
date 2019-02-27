package com.example.vikrantkunwar.jobfinder.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

 class Job(

    @Expose @SerializedName(value = "company_logo")
    val companyLogo:String?=null,
    @Expose @SerializedName(value = "title",alternate =["position_title"])
    val jobTitle: String,
    @Expose @SerializedName(value = "company",alternate =["organization_name"])
    val companyName: String,
    @Expose @SerializedName(value = "location")
    val location: String? = null,
    @Expose @SerializedName(value = "created_at",alternate =["start_date"])
    val postDate: String,
    @Expose @SerializedName(value = "url")
    val url:String,
    @Expose @SerializedName(value = "locations")
    val locations: List<String>? = null,

    val id:String,
    val type:String,
    val company_url:String,
    val description:String,
    val how_to_apply:String,
    val rate_interval_code:String,
    val minimum:String,
    val maximum:String,
    val end_date:String


    )