package com.patidar.dinesh.androideatitserver.Remote;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IGeoCoordinates {

    @GET("maps/api/geocode/json")
    Call<String> getGeoCode(@Query("address")String address);

    @GET("maps/api/directions/json") //maps/api/directions/json
    Call<String> getDirections(@Query("origin") String origin, @Query("destination") String destination);

    //https://maps.googleapis.com/maps/api/directions/json
    //&key=AIzaSyB5KGRMlcHpaOyObAZJ2jyWX3WAaZ3xFN0
    // VIDEO -: PART 14 (TIME: 47:02) PROBLEM WITH ME AND I SHOLW LATER - DINESH PATIDAR
    // PROBLEM -: ROOT NOT FOUND ON GOOGLE MAP (USER LOCATION TO RESTORENT LOCATION)
}
