package com.palchukwlod.drshisha.presentation.customMixes.listOfMixes

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shishamixcompouse.util.AppBarState
import com.example.shishamixcompouse.util.RequestState
import com.palchukwlod.drshisha.data.entity.customMix.CustomMix
import com.palchukwlod.drshisha.data.repositories.CustomMixRepository
import com.palchukwlod.drshisha.utils.Constants.EMPTY_STRING
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListOfMixesViewModel @Inject constructor(
    private val customMixRepository: CustomMixRepository
): ViewModel() {

    val appBarState: MutableState<AppBarState> = mutableStateOf(AppBarState.CLOSED)
    val searchTextState: MutableState<String> = mutableStateOf(EMPTY_STRING)

    private val _allCustomMixes =
        MutableStateFlow<RequestState<List<CustomMix>>>(RequestState.Idle)
    val allCustomMixes: StateFlow<RequestState<List<CustomMix>>> = _allCustomMixes

    fun deleteCustomMix(customMix: CustomMix) {
        viewModelScope.launch{
            customMixRepository.deleteCustomMix(customMix)
        }
    }

    fun getAllCustomMixes() {
        _allCustomMixes.value = RequestState.Loading
        try {
            viewModelScope.launch {
                customMixRepository.getAllCustomMixes().collect{
                    _allCustomMixes.value = RequestState.Success(it)
                }
            }
        } catch (e: Exception) {
            _allCustomMixes.value = RequestState.Error(e)
        }
    }

}