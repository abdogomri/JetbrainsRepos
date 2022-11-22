package com.ob.jetbrainsrepos.features.repos_feature.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RepoInfoDetails(
    @SerializedName("fullName") var fullName: String? = null,
    @SerializedName("description") var description: String? = null
): Parcelable
