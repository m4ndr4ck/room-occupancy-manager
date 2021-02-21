module com.smarthost.application {
    requires com.smarthost.domain;
    requires static lombok;
    requires java.validation;
    requires jakarta.inject.api;
    requires jakarta.enterprise.cdi.api;
    requires jakarta.el.api;

    exports com.smarthost.application.usecases;
    exports com.smarthost.application.ports.out;
    exports com.smarthost.application.ports.command;
}