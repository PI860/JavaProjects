package EMS.telemetryServer;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.annotations.Column;
import com.influxdb.annotations.Measurement;
import com.influxdb.client.QueryApi;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.domain.HealthCheck;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import com.influxdb.exceptions.InfluxException;
import com.influxdb.query.FluxRecord;
import com.influxdb.query.FluxTable;
import com.influxdb.client.DeleteApi;

public class InfluxDBConnectionClass {

    private String token;
    private String bucket;
    private String org;

    private String url;

    public InfluxDBClient buildConnection(String url, String token, String bucket, String org) {
        setToken(token);
        setBucket(bucket);
        setOrg(org);
        setUrl(url);
        return InfluxDBClientFactory.create(getUrl(), getToken().toCharArray(), getOrg(), getBucket());
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean singlePointWrite(InfluxDBClient influxDBClient) {
        boolean flag = false;
        try {
            WriteApiBlocking writeApi = influxDBClient.getWriteApiBlocking();

            Point point = Point.measurement("sensor").addTag("sensor_id", "TLM0100").addField("location", "Main Lobby")
                    .addField("model_number", "TLM89092A")
                    .time(Instant.parse("2021-10-11T15:18:15.117484Z"), WritePrecision.MS);

            writeApi.writePoint(point);
            flag = true;
        } catch (InfluxException e) {
            System.out.println("Exception!!" + e.getMessage());
        }
        return flag;
    }

    @Measurement(name = "sensor")
    private static class Sensor {

        @Column(tag = true)
        String sensor_id;

        @Column
        String location;

        @Column
        String model_number;

        @Column(timestamp = true)
        Instant last_inspected;
    }


    // Send data to influxDB:
    public boolean writeData (InfluxDBClient influxDBClient) {
        boolean flag = false;
        //Dataproducer dp = new Dataproducer();
        try {
            //String data = "mem, host=host3 used_percent=100"; // String data muss noch angepasst werden
            Point point = Point.measurement("Testdata").addField("Value", 140).addTag("Unit","TestUnit").addTag("ID","12345, timedatectl set-local-rtc 1 --adjust-system-clock 22:24 Uhr").addTag("Name","TestName").time(Instant.now(), WritePrecision.NS);
            WriteApiBlocking writeApi = influxDBClient.getWriteApiBlocking();
            //writeApi.writeRecord(bucket, org, WritePrecision.NS, data);
            writeApi.writePoint(bucket, org, point);
            System.out.println("Data written!");
            flag = true;
        } catch (InfluxException e) {
            System.out.println("Exception!!" + e.getMessage());
        }
        return flag;

    }


    public void queryData(InfluxDBClient influxDBClient) {
        String flux = "from(bucket:\"telemetry\") |> range(start:-1h) |> filter(fn: (r) => r[\"_measurement\"] == \"sensor\") |> filter(fn: (r) => r[\"sensor_id\"] == \"TLM0100\"or r[\"sensor_id\"] == \"TLM0101\" or r[\"sensor_id\"] == \"TLM0103\" or r[\"sensor_id\"] == \"TLM0200\") |> sort() |> yield(name: \"sort\")";
        // from(bucket: "myFirstBucket")
        // |> range(start: v.timeRangeStart, stop: v.timeRangeStop)
        // |> filter(fn: (r) => r["_measurement"] == "sensor")
        // |> filter(fn: (r) => r["_field"] == "model_number")
        // |> filter(fn: (r) => r["sensor_id"] == "TLM0100" or r["sensor_id"] ==
        // "TLM0101" or r["sensor_id"] == "TLM0103" or r["sensor_id"] == "TLM0200")
        // |> sort()
        // |> yield(name: "sort")
        CountDownLatch countdown = new CountDownLatch(1);

        QueryApi queryApi = influxDBClient.getQueryApi();

        List<FluxTable> tables = queryApi.query(flux);
        for (FluxTable fluxTable : tables) {
            List<FluxRecord> records = fluxTable.getRecords();
            for (FluxRecord fluxRecord : records) {
                System.out.println(fluxRecord.getValueByKey("sensor_id"));
            }
        }
        try {
            countdown.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteRecord(InfluxDBClient influxDBClient) {
        boolean flag = false;
        DeleteApi deleteApi = influxDBClient.getDeleteApi();

        try {

            OffsetDateTime start = OffsetDateTime.now().minus(72, ChronoUnit.HOURS);
            OffsetDateTime stop = OffsetDateTime.now();
            String predicate = "_measurement=\"sensor\" AND sensor_id = \"TLM0201\"";

            deleteApi.delete(start, stop, predicate, "telemetry", "Einstein_Motorsport");

            flag = true;
        } catch (InfluxException ie) {
            System.out.println("InfluxException: " + ie);
        }
        return flag;
    }
}
