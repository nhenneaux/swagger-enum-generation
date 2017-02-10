package nhenneaux.test.endpoint.model;


import io.swagger.annotations.ApiModel;

@ApiModel("The synchronization status with LDAP instance.")
public enum SynchronizationStatus {

    UNKNOWN,
    SYNC,
    OFFLINE,
    CONFLICT
}
