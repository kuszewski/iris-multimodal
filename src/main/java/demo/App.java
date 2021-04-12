package demo;

import java.io.*;
import java.sql.*;
import java.util.*; 
import java.net.*;

import com.intersystems.jdbc.*;
import com.intersystems.xep.*;

import demo.Participant;
import demo._DummyDataGenerator;

public class App
{
    public App(){}

    public void Step1_CreateDatabaseSchema() throws Exception
    {
        EventPersister xepPersister = GetPersister();
        // Import flat schema - This creates corresponding classes (aka Schema) in IRIS
        xepPersister.importSchema("demo.Participant");
    }

    public void Step3_CreateParticipants( int participantCount ) throws Exception
    {
        EventPersister xepPersister = GetPersister();

        // Create Participants
        Participant[] p = _DummyDataGenerator.generateSampleParticipantData(participantCount);

        // Create and Save Particpants
        Event xepEvent = xepPersister.getEvent("demo.Participant");
        xepEvent.store(p);
        xepEvent.close();

        xepPersister.close();
    }

    // Assign participants randomly to cohorts via the native API
    public void Step4_AssignCohorts() throws Exception
    {
        IRISConnection conn = GetConnection();
        IRIS iris = IRIS.createIRIS(conn);

        iris.classMethodStatusCode("User.CohortAssigner","AssignParticipantsToCohorts");

        iris.close();
        conn.close();
    }


    public void Step5_SimulateTesting(int participantCount) throws Exception
    {
        for (int i=1; i<participantCount; i++) {
            String params = _DummyDataGenerator.generateRandomTestResult(i);
            post("http://localhost:52773/api/docdb/v1/Multimodel/doc/TestResult/", params);    
            if (i%1000==0) {
                System.out.println("  "+i+" documents posted");
            }
        }
    }

    public void Step6_Report() throws Exception
    {
        IRISConnection conn = GetConnection();

        String query = 
            "SELECT c.description, COUNT(p.ID) AS TotalParticipants, COUNT(t.ID) AS TotalTests, COUNT(t.success %AFTERHAVING) AS SuccessfulTests " +
            "FROM demo.participant p, demo.testresult t, demo.cohort c " +
            "WHERE t.participantID = p.ID AND p.cohortID = c.ID " +
            "GROUP BY c.ID " +
            "HAVING t.success > 0 " +
            "ORDER BY c.ID";

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        System.out.println("Reporting which cohorts passed the "+inCyan("50%")+" success criteria...\n");
        while (resultSet.next()) {
            Boolean success = resultSet.getInt(4) > (resultSet.getInt(3) / 2);
            System.out.println(" " + ( (success) ? inGreen("+ "+resultSet.getString(1)) : inRed("- "+resultSet.getString(1))) + " " + inCyan(resultSet.getString(2)) + " participants, " + inCyan(resultSet.getString(4)) + " successful tests");
        }

        resultSet.close();
        statement.close();
        conn.close();
    }

    // Console coloring helpers
    private String inGreen(String msg) {
        return "\033[32m"+msg+"\033[0m";
    }
    private String inRed(String msg) {
        return "\033[31m"+msg+"\033[0m";
    }
    private String inCyan(String msg) {
        return "\033[36m"+msg+"\033[0m";
    }

    public void Step0_DeleteSchema() throws Exception 
    {
        EventPersister xepPersister = GetPersister();

        // Remove old test data, in case you want to run this tests more than once
        xepPersister.deleteExtent("demo.Participant");
    }

    private void post(String uri, String data) throws Exception 
    {
        URL url = new URL(uri);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestProperty("content-type", "application/json");
        connection.setRequestProperty("accept", "application/json");

        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        try(OutputStream os = connection.getOutputStream()) {
            byte[] input = data.getBytes("utf-8");
            os.write(input, 0, input.length);			
        }

        try(BufferedReader br = new BufferedReader(
            new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
//            System.out.println(response.toString());
        }
    }

    // Database connection helpers

    private EventPersister GetPersister() throws Exception
    {
        EventPersister xepPersister = PersisterFactory.createPersister();
        xepPersister.connect(_hostname, _port, _namespace, _user, _password);

        return xepPersister;
    }

    private IRISConnection GetConnection() throws Exception
    {
        Class.forName("com.intersystems.jdbc.IRISDriver");
        return (IRISConnection) DriverManager.getConnection("jdbc:IRIS://"+_hostname+":"+_port+"/"+_namespace,_user,_password);
    }

    // Database connection parameters.
    static public String _hostname = "localhost";
    static public int _port = 51773;
    static public String _namespace = "MULTIMODEL";
    static public String _user = "_SYSTEM";
    static public String _password = "SYS";
}
