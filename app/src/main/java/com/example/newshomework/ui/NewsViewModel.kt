package com.example.newshomework.ui

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newshomework.R
import com.example.newshomework.data.models.NewsArticlesResponse
import com.example.newshomework.data.source.UserDataSource
import com.example.newshomework.domain.NewsData
import com.example.newshomework.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _newsLiveData = MutableLiveData<List<NewsData>>()
    val newsLiveData: LiveData<List<NewsData>> get() = _newsLiveData

    private val _errorLiveData = MutableLiveData<Int>()
    val errorLiveData: LiveData<Int> get() = _errorLiveData

    private val _loadingLiveData = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean> get() = _loadingLiveData


    private val exceptionHandler = CoroutineExceptionHandler { _, _ ->
        _loadingLiveData.value = true
        viewModelScope.launch {
            _newsLiveData.value = repository.getNews(false)
            _loadingLiveData.value = false
        }
    }

    fun getNews() {
        _loadingLiveData.value = true
        viewModelScope.launch(exceptionHandler) {
            _newsLiveData.value = repository.getNews(true)
            _loadingLiveData.value = false
        }
    }

    fun setUserToken() {
        repository.setUserToken(USER_TOKEN)
    }

    companion object {
        private const val USER_TOKEN = "6e2215d6c8824752abea6defbc421007"
    }
}