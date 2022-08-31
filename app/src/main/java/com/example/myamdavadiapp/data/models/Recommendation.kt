package com.example.myamdavadiapp.data.models

data class Recommendation(
    val optionId: Int,
    val categoryId: Int,
    val optionName: String,
    val optionImage: Int,
    val optionLocation: String,
    val optionTimings: String,
    val optionPhoneNumber: String
)
