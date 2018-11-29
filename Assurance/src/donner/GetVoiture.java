package donner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class GetVoiture {
    static String        marque;
    static String        model;
    static String        usage;
    static int           puissance;
    static String        typeCarburant;
    static int           nombrePlaces;
    static Object        nfcid;
    static String        nom;
    static String        prenom;
    static String        telephone;
    public int           taille;
    static String        matricule;

    static boolean       proprietaire;
    public List<String>  listmarque        = new ArrayList<String>();
    public List<String>  listmatricule     = new ArrayList<String>();

    public List<String>  listmodel         = new ArrayList<String>();
    public List<String>  listusage         = new ArrayList<String>();
    public List<String>  listtypeCarburant = new ArrayList<String>();
    public List<String>  listnom           = new ArrayList<String>();
    public List<String>  listprenom        = new ArrayList<String>();

    public List<Integer> listpuissance     = new ArrayList<Integer>();
    public List<Integer> listnombrePlaces  = new ArrayList<Integer>();

    public List<String>  listtelephone     = new ArrayList<String>();
    public List<Object>  listnfcid         = new ArrayList<Object>();
    public List<Boolean> listproprietaire  = new ArrayList<Boolean>();

    /*
     * public static void main( String[] args ) throws Exception { call_me();
     * 
     * }
     */

    public void call_me() throws Exception {

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

        // liste voiture
        JSONObject user = myResponse.getJSONObject( "values" );

        JSONArray voiture = user.getJSONArray( "Voiture" );
        taille = voiture.length();
        System.out.println( voiture.length() );
        for ( int i = 0; i < voiture.length(); i++ ) {

            JSONObject tps = voiture.getJSONObject( i );
            JSONObject op = new JSONObject( tps.toString() );

            JSONObject chauff = op.getJSONObject( "chauffeur" );

            matricule = op.getString( "matricule" );

            marque = op.getString( "marque" );
            model = op.getString( "model" );
            usage = op.getString( "usage" );
            puissance = op.getInt( "puissance" );
            typeCarburant = op.getString( "typeCarburant" );
            nombrePlaces = op.getInt( "nombrePlaces" );
            nfcid = chauff.get( "nfcid" );
            nom = chauff.getString( "nom" );
            prenom = chauff.getString( "prenom" );
            telephone = chauff.getString( "telephone" );
            proprietaire = chauff.getBoolean( "proprietaire" );

            listmarque.add( marque );
            listproprietaire.add( proprietaire );
            listmodel.add( model );
            listusage.add( usage );
            listpuissance.add( puissance );
            listtypeCarburant.add( typeCarburant );
            listnfcid.add( nfcid );
            listnom.add( nom );
            listprenom.add( prenom );
            listtelephone.add( telephone );
            listmatricule.add( matricule );
            listnombrePlaces.add( nombrePlaces );
            listprenom.get( i );

            ;

        }

    }

}
