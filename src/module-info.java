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
    requires jakarta.persistence;
    //requires java.datatransfer;

    opens PROG2.javaprojects to javafx.fxml;
    exports PROG2.javaprojects;
}