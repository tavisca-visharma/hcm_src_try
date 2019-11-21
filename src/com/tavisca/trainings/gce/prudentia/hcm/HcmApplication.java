package com.tavisca.trainings.gce.prudentia.hcm;

import com.tavisca.trainings.gce.prudentia.hcm.services.MainService;

public class HcmApplication {

    public static void main(String[] args) {
        MainService mainService = new MainService();
        mainService.serve();
    }

}
