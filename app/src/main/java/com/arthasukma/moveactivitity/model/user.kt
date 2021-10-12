package com.arthasukma.moveactivitity.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class user (
    val NAME : String,
    val EMAIL : String,
    val AGE : String,
        ) : Parcelable