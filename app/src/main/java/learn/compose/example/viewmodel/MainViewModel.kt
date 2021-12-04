package learn.compose.example.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    val counterLiveData: LiveData<Int>
        get() = counter

    private val counter = MutableLiveData<Int>()
    private var count = 0

    fun increaseCounter() {
        counter.value = ++count
    }
}