package com.example.vikrantkunwar.jobfinder.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.vikrantkunwar.jobfinder.data.model.Job
import com.example.vikrantkunwar.jobfinder.data.remote.ApiEndPoint
import com.example.vikrantkunwar.jobfinder.data.remote.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(



    private  var apiService: ApiService,
    private  var disposable: CompositeDisposable
) : ViewModel() {


    private val jobSearchGithub = MutableLiveData<List<Job>>()
    private val jobSearched = MutableLiveData<List<Job>>()
    private val loadingError = MutableLiveData<String>()
    private val loading = MutableLiveData<Boolean>()

    init {

        fetchRepos(ApiEndPoint.GITHUB_PROVIDER,"","","","")
    }


    internal fun getJobSearches(): LiveData<List<Job>> {
        return jobSearchGithub
    }
    internal fun getJobSearched(provider:String, query:String,description: String, location: String, position:String): LiveData<List<Job>> {
        var providerUrl =""
        when(provider){
            "Github" -> providerUrl = ApiEndPoint.GITHUB_PROVIDER
            "Search.GOV" -> providerUrl = ApiEndPoint.SEARCH_GOV_PROVIDER
        }
        fetchRepod(providerUrl,description,location,query,position)
        return jobSearched
    }

    internal fun getError(): LiveData<String> {
        return loadingError
    }

    internal fun getLoading(): LiveData<Boolean> {
        return loading
    }

    private fun fetchRepos(
        url: String,
        searchDescription: String,
        location: String,
        query: String,
        position: String
    ) {

        loading.value = true



        disposable.add(    apiService.jobs(url,query,searchDescription,location,position)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        jobSearchGithub.value =it

                    },{
                        loadingError.value = it.message
                    }
                ))



    }

    private fun fetchRepod(
        url: String,
        searchDescription: String,
        location: String,
        query: String,
        position: String
    ) {
        loading.value = true
        disposable.add(    apiService.jobs(url,query,searchDescription,location,position)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    jobSearched.value =it
                    loading.value = false

                },{
                    loadingError.value = it.message
                    loading.value = false
                }
            ))



    }


}


