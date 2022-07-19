package com.melfouly.shoestore.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(var name: String? = "", var size: Double? = 36.0, var company: String? = "", var description: String? = "",
                val images: List<String>? = mutableListOf()) : Parcelable