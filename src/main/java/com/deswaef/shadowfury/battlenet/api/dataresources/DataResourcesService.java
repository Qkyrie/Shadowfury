package com.deswaef.shadowfury.battlenet.api.dataresources;

import com.deswaef.shadowfury.battlenet.api.dataresources.api.ClassesResponse;
import com.deswaef.shadowfury.battlenet.api.dataresources.api.RacesResponse;
import com.deswaef.shadowfury.battlenet.api.dataresources.api.RealmsResponse;
import retrofit.http.GET;

public interface DataResourcesService {

    @GET("/wow/data/character/races")
    RacesResponse races();

    @GET("/wow/data/character/classes")
    ClassesResponse classes();

    @GET("/wow/realm/status")
    RealmsResponse realms();
}
