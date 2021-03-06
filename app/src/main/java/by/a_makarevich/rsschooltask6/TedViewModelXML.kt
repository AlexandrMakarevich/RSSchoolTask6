package by.a_makarevich.rsschooltask6

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TedViewModelXML : ViewModel() {

    private val _itemsXML = MutableLiveData<List<TedObjectXML>>()
    val itemsXML: LiveData<List<TedObjectXML>> get() = _itemsXML

    init {
        viewModelScope.launch {
            _itemsXML.value = WebAccessXML.getListOfTedsXML()
        }
    }

}