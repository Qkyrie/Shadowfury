package com.deswaef.shadowfury.battlenet.api.dataresources;

import com.deswaef.shadowfury.battlenet.api.dataresources.api.ClassesResponse;
import com.deswaef.shadowfury.battlenet.api.dataresources.api.RacesResponse;
import retrofit.RestAdapter;

public class DataResourcesResource {
    private DataResourcesService dataResourcesService;

    public RacesResponse races() {
        return dataResourcesService.races();
    }

    public ClassesResponse classes() {
        return dataResourcesService.classes();
    }

    public DataResourcesResource url(RestAdapter restAdapter) {
        this.dataResourcesService = restAdapter.create(DataResourcesService.class);
        return this;
    }
}
