package com.wani.workreport.report.domain;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Company {

    private String title;
    private String workPlaceName;

    private String workerName;
    private String workerPhoneNumber;

    @Embedded
    private WorkerDevice workerDevice;


}
