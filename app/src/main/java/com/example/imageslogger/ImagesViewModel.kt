package com.example.imageslogger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imageslogger.model.Photo
import com.example.imageslogger.services.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ImagesViewModel : ViewModel() {
    var repo = Repository()

    var _images = MutableStateFlow<List<Photo>>(listOf())
    var images: StateFlow<List<Photo>> = _images

    val _selectedPhotos = MutableStateFlow<MutableList<String>>(mutableListOf())
    val selectedPhotos : StateFlow<List<String>> = _selectedPhotos


    fun updateSelectedPhoto(index: Int, id: String){
        var myList = _selectedPhotos.value
        myList.add(""+(index+1))
        _selectedPhotos.value = myList
    }
    fun fetchImages() {
        viewModelScope.launch{
            repo.FetchImages(_images)
        }
    }
}