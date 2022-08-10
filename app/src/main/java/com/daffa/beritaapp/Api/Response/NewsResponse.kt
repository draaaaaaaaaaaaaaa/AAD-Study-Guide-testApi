package com.daffa.beritaapp.Api.Response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsResponse(
	val newsResponse: List<NewsResponseItem?>? = null
) : Parcelable

@Parcelize
data class NewsResponseItem(
	val thumb: String? = null,
	val author: String? = null,
	val tag: String? = null,
	val time: String? = null,
	val title: String? = null,
	val key: String? = null,
	val desc: String? = null
) : Parcelable
