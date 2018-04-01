package com.meetme.data.remote;

import com.meetme.data.model.api.LoginRequest;
import com.meetme.data.model.api.LoginResponse;
import com.meetme.data.model.api.LogoutResponse;

import io.reactivex.Single;

public interface ApiHelper {

    Single<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request);

    Single<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request);

    Single<LogoutResponse> doLogoutApiCall();

    Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    ApiHeader getApiHeader();
}