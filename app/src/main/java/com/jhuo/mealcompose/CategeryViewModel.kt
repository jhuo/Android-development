package com.jhuo.mealcompose

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jhuo.mealcompose.data.model.Category
import com.jhuo.mealcompose.repository.MealRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    mealRepository: MealRepository
): ViewModel() {

    private val _state = MutableStateFlow((emptyList<Category>()))
    var state: StateFlow<List<Category>> = _state

    init{
        viewModelScope.launch {
            try {
                val list = mealRepository.getCategoryList()
                if(list.categories.isNotEmpty()) {
                    _state.value = list.categories
                }
            } catch(e: Exception) {
                Log.d("JH", "Error: ${e.message}")
                println(e)
            }
        }
    }


}