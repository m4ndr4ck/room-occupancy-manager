module com.smarthost.framework {

    requires com.smarthost.application;
    requires java.ws.rs;
    requires jakarta.inject.api;
    requires jakarta.enterprise.cdi.api;
    requires com.smarthost.domain;
    requires quarkus.jackson;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.jaxrs.json;

    requires microprofile.openapi.api;
}