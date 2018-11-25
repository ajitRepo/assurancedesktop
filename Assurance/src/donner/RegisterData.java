package donner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class RegisterData {

    public void enregistre( String matricule, String marque, String model, String usage,
            String puissance, String typeCarburant, String nombrePlaces, String nfcid, String nom, String prenom,
            String telephone, String proprietaire ) throws IOException {

        final String POST_PARAMS = "{" + "\r\n" +
                "\"matricule\"" + ":\"" + matricule + "\",\r\n" +
                "\"marque\"" + ":\"" + marque + "\",\r\n" +
                "\"model\"" + ":\"" + model + "\",\r\n" +
                "\"usage\"" + ":\"" + usage + "\",\r\n" +
                "\"puissance\"" + ":" + puissance + ",\r\n" +
                "\"typeCarburant\"" + ":\"" + typeCarburant + "\",\r\n" +
                "\"nombrePlaces\"" + ":" + nombrePlaces + ",\r\n" +
                "\"chauffeur\"" + ":" + "{" + "\"nfcid\"" + ":\"" + nfcid + "\",\r\n" +
                "\"nom\"" + ":\"" + nom + "\",\r\n" +
                "\"prenom\"" + ":\"" + prenom + "\",\r\n" +
                "\"telephone\"" + ":\"" + telephone + "\",\r\n" +
                "\"proprietaire\"" + ":\"" + proprietaire + "\"\r\n" +
                "}" + "\r\n" +
                "}";

        System.out.println( POST_PARAMS );

        URL obj = new URL( "http://212.71.244.7:8080/assurance/savevoiture" );

        HttpURLConnection GetConnection = (HttpURLConnection) obj.openConnection();

        GetConnection.setRequestMethod( "POST" );
        GetConnection.setRequestProperty( "Authorization",
                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhaml0IiwiY3JlYXRlZCI6MTU0MjkyNTgxMTgzMywiZXhwIjoxNTQzNTMwNjExfQ.2azTFEau-x3Y8Pe6kKihzCkoze17Xy-uaBgHoA0eB-fK8iDNxrZS9L1t9coKEnOz7eMUdcRxPxvdh6AoXmF2Tw" );
        GetConnection.setRequestProperty( "Content-Type", "application/json" );

        GetConnection.setDoOutput( true );

        OutputStream os = GetConnection.getOutputStream();

        os.write( POST_PARAMS.getBytes() );

        os.flush();

        os.close();

        int responseCode = GetConnection.getResponseCode();

        System.out.println( "POST Response Code :  " + responseCode );

        System.out.println( "POST Response Message : " + GetConnection.getResponseMessage() );

        if ( responseCode == 200 ) {
            Alert errorAlert = new Alert( AlertType.ERROR );
            errorAlert.setHeaderText( "Operation succes" );
            errorAlert.setContentText( GetConnection.getResponseMessage() );
            errorAlert.showAndWait();
        } else {
            Alert errorAlert = new Alert( AlertType.ERROR );
            errorAlert.setHeaderText( "Operation Echouer" );
            errorAlert.setContentText( GetConnection.getResponseMessage() );
            errorAlert.showAndWait();
        }

        BufferedReader in = new BufferedReader( new InputStreamReader(

                GetConnection.getInputStream() ) );

        String inputLine;

        StringBuffer response = new StringBuffer();

        while ( ( inputLine = in.readLine() ) != null ) {

            response.append( inputLine );

        }
        in.close();

    }
}
