package com.gralliams.myresume

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResumeViewModel: ViewModel(){
    private val _nameLiveData = MutableLiveData<String>()
    val nameLiveData : LiveData<String> get()  = _nameLiveData

    private val _bioLiveData = MutableLiveData<String>()
    val bioLiveData : LiveData<String> get() = _bioLiveData

    private val _gitLiveData = MutableLiveData<String>()
    val gitLiveData : LiveData<String> get() = _gitLiveData

    private val _slackLiveData = MutableLiveData<String>()
    val slackLiveData : LiveData<String> get() = _slackLiveData

    init {
        _nameLiveData.postValue("Grant Williams")
        _bioLiveData.postValue("Native android developer with expertise in creating innovative and user-friendly apps.\n\nAdept at collaborating with cross-functional teams to deliver cutting-edge, user-friendly apps that meet client and user expectations.\n")
        _slackLiveData.postValue("@Grant Williams")
        _gitLiveData.postValue("@GreatGrant")
    }
    fun setName(name: String){
        _nameLiveData.postValue(name)
    }

    fun setBio(bio: String){
        _bioLiveData.postValue(bio)
    }

    fun setGit(gitUrl: String){
        _gitLiveData.postValue(gitUrl)
    }

    fun setSlack(slackHandle: String){
        _slackLiveData.postValue(slackHandle)
    }
}
