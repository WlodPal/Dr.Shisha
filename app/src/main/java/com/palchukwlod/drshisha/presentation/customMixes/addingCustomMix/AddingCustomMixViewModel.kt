package com.palchukwlod.drshisha.presentation.customMixes.addingCustomMix


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.palchukwlod.drshisha.data.entity.customMix.CustomMix
import com.palchukwlod.drshisha.data.entity.customMix.FlavorType
import com.palchukwlod.drshisha.data.entity.customMix.LevelOfStrong
import com.palchukwlod.drshisha.data.entity.customMix.PartOfCustomMix
import com.palchukwlod.drshisha.data.repositories.CustomMixRepository
import com.palchukwlod.drshisha.data.repositories.PartOfCustomMixRepository
import com.palchukwlod.drshisha.utils.Constants.EMPTY_STRING
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddingCustomMixViewModel @Inject constructor(
    private val repository: PartOfCustomMixRepository,
    private val customMixRepo: CustomMixRepository
) : ViewModel() {

    //Full Mix
    val brandMame: MutableState<String> = mutableStateOf(EMPTY_STRING)
    val flavour: MutableState<String> = mutableStateOf(EMPTY_STRING)

    //Part Of Mix
    val customMixId: MutableState<Int> = mutableIntStateOf(0)
    val mixName: MutableState<String> = mutableStateOf(EMPTY_STRING)
    val description: MutableState<String> = mutableStateOf(EMPTY_STRING)
    val levelOfStrong: MutableState<LevelOfStrong> = mutableStateOf(LevelOfStrong.STRONG)
    val percentage: MutableState<Int> = mutableIntStateOf(0)
    val flavorType: MutableState<FlavorType> = mutableStateOf(FlavorType.MINT)

    private val _allPartOfMix = MutableStateFlow<List<PartOfCustomMix>>(emptyList())
    val allPartOfMix: StateFlow<List<PartOfCustomMix>> = _allPartOfMix

    fun addPartOfMix(customMix: CustomMix) {
        viewModelScope.launch {
            repository.insertPartOfCustomMix(
                PartOfCustomMix(
                    brandName = brandMame.value,
                    flavour = flavour.value,
                    percentage = percentage.value,
                    customMixId = customMix.customMixId
                )
            )
        }
    }

    fun addCustomMix(){
        viewModelScope.launch {
            val customMix = CustomMix(
                mixName = mixName.value,
                description = description.value,
                levelOfStrong = levelOfStrong.value,
                percentage = percentage.value,
                flavorType = listOf()
            )
            customMixRepo.insertCustomMix(customMix)
        }
    }

    fun deletePartOfCustomMix(partOfCustomMix: PartOfCustomMix){
        viewModelScope.launch {
            repository.deletePartOfCustomMix(partOfCustomMix = partOfCustomMix)
        }
    }

}