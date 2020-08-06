package by.a_makarevich.rsschooltask6

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TedViewModel : ViewModel() {
    private val _items = MutableLiveData<List<TedObject>>()
    val items: LiveData<List<TedObject>> get() = _items

    init {

        viewModelScope.launch {
            _items.value = WebAccess.getListOfTeds()
        }
    }
}