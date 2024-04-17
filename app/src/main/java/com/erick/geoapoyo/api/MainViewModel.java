package com.erick.geoapoyo.api;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {


    MutableLiveData<Integer> mProgressMutableData = new MutableLiveData<>();
    MutableLiveData<String> mLoginResultMutableData = new MutableLiveData<>();
    MainRepository mMainRepository;

    private MutableLiveData<Boolean> mLoginSuccessEvent = new MutableLiveData<>();

    public MainViewModel(){
        mProgressMutableData.postValue(View.INVISIBLE);
        mLoginResultMutableData.postValue("Not logged in");
        mMainRepository = new MainRepository();
    }

    public void login(String correo, String contrasenia){
        mProgressMutableData.postValue(View.VISIBLE);
        mLoginResultMutableData.postValue("Checking");
        mMainRepository.loginRemote(new LoginBody(correo, contrasenia), new MainRepository.ILoginResponse() {
            @Override
            public void onResponse(LoginResponse loginResponse) {
                mProgressMutableData.postValue(View.INVISIBLE);
                mLoginResultMutableData.postValue("Login Success");

                mLoginSuccessEvent.postValue(true);
            }

            @Override
            public void onFailure(Throwable t) {
                mProgressMutableData.postValue(View.INVISIBLE);
                mLoginResultMutableData.postValue("Login failure: " + t.getLocalizedMessage());
            }
        });
    }

    public LiveData<Integer> getProgress(){
        return mProgressMutableData;
    }

    public LiveData<Boolean> getLoginSuccessEvent() {
        return mLoginSuccessEvent;
    }
}
