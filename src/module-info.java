module com.example.javaprojects {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    //requires influxdb.client.java;
    //requires influxdb.client.core;
    //requires com.fazecast.jSerialComm;
    //requires org.apache.poi.ooxml;
    requires org.junit.jupiter.api;
    requires java.sql;
    //requires java.datatransfer;

    // Database Programming ORM / JPA:
//    requires mysql.connector.java;
//    requires org.eclipse.persistence.asm;
//    requires org.eclipse.persistence.jpars;
//    requires org.eclipse.persistence.jpa.modelgen.processor;
//    requires jakarta.persistence;
//    requires jakarta.annotation;

    opens PROG2.javaprojects to javafx.fxml;
    exports PROG2.javaprojects;
}