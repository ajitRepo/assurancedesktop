package donner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class GetVoiture {
    static String matricule;
    static String marque;
    static String model;
    static String usage;
    static int    puissance;
    static String typeCarburant;
    static int    nombrePlaces;
    static String nfcid;
    static String nom;
    static String prenom;
    static String telephone;
    static String proprietaire;

    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        try {
            call_me();
        } catch ( Exception e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void call_me() throws Exception {

        String url = "http://212.71.244.7:8080/assurance/voitures";

        URL obj = new URL( url );
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET

        con.setRequestMethod( "GET" );
        con.setRequestProperty( "Authorization",
                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhaml0IiwiY3JlYXRlZCI6MTU0MjkyNTgxMTgzMywiZXhwIjoxNTQzNTMwNjExfQ.2azTFEau-x3Y8Pe6kKihzCkoze17Xy-uaBgHoA0eB-fK8iDNxrZS9L1t9coKEnOz7eMUdcRxPxvdh6AoXmF2Tw" );
        // add request header

        // con.setAuthenticator( null );
        // con.setRequestProperty( "User-Agent", "Mozilla/5.0" );
        int responseCode = con.getResponseCode();
        System.out.println( "\nSending 'POST' request to URL : " + url );
        System.out.println( "Response Code : " + responseCode );

        BufferedReader in = new BufferedReader(
                new InputStreamReader( con.getInputStream() ) );
        String inputLine;
        ArrayList<String> list = new ArrayList<String>();
        StringBuffer response = new StringBuffer();
        while ( ( inputLine = in.readLine() ) != null ) {
            list.add( inputLine );
            response.append( inputLine );
        }
        in.close();
        // print in String
        System.out.println( response.toString() );

        JSONObject myResponse = new JSONObject( response.toString() );
        System.out.println( myResponse.getString( "message" ) );

        JSONObject user = myResponse.getJSONObject( "values" );
        JSONArray voiture = user.getJSONArray( "Voiture" );

        System.out.println( voiture.length() );
        for ( int i = 0; i < voiture.length(); i++ ) {

            JSONObject tps = voiture.getJSONObject( i );
            JSONObject op = new JSONObject( tps.toString() );
            System.out.println( op.getString( "typeCarburant" ) );

            matricule = op.getString( "matricule" );
            marque = op.getString( "marque" );
            model = op.getString( "model" );
            usage = op.getString( "usage" );
            puissance = op.getInt( "puissance" );
            typeCarburant = op.getString( "typeCarburant" );
            nombrePlaces = op.getInt( "nombrePlaces" );

        }

    }

}
