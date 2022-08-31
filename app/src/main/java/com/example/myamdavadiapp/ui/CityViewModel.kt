package com.example.myamdavadiapp.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CityViewModel: ViewModel() {

    private val _selectedCategoryId = MutableStateFlow(0)
    val selectedCategoryId: StateFlow<Int> = _selectedCategoryId.asStateFlow()

    fun setCategoryId(categoryId: Int){
        _selectedCategoryId.value = categoryId
    }

    private val _selectedOptionId = MutableStateFlow(0)
    val selectedOptionId: StateFlow<Int> = _selectedOptionId.asStateFlow()

    fun setOptionId(optionId: Int){
        _selectedOptionId.value = optionId
    }
}
