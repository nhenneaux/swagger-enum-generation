package nhenneaux.test.endpoint.model;

import io.swagger.annotations.ApiModelProperty;

public class User {

    private String name = "unknown";
    private SynchronizationStatus ldap1 = SynchronizationStatus.UNKNOWN;
    private SynchronizationStatus ldap2 = SynchronizationStatus.OFFLINE;

    @ApiModelProperty(value = "The user name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ApiModelProperty(value = "The synchronization status with the LDAP1", reference = "#/definitions/SynchronizationStatus")
    public SynchronizationStatus getLdap1() {
        return ldap1;
    }

    public void setLdap1(SynchronizationStatus ldap1) {
        this.ldap1 = ldap1;
    }

    @ApiModelProperty(reference = "#/definitions/SynchronizationStatus")
    public SynchronizationStatus getLdap2() {
        return ldap2;
    }

    public void setLdap2(SynchronizationStatus ldap2) {
        this.ldap2 = ldap2;
    }
}
