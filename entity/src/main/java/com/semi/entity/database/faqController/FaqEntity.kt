package com.semi.entity.database.faqController

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class FaqEntity(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val answer: String? = "",
    val question: String? = ""
) : Parcelable
