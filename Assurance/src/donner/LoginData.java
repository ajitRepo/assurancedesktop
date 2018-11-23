package donner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginData {

    public static void POSTRequest() throws IOException, JSONException {

        // {"login":"ajit", "password":"ajit@2018"}
        final String POST_PARAMS = "{" + "\"login\":\"ajit\" ,\r\n" + "\"password\":\"ajit@2018\"" + "}";

        System.out.println( POST_PARAMS );

        URL obj = new URL( "http://212.71.244.7:8080/assurance/login" );

        HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();

        postConnection.setRequestMethod( "POST" );
        postConnection.setRequestProperty( "login", "ajit" );
        postConnection.setRequestProperty( "password", "ajit@2018" );
        postConnection.setRequestProperty( "Content-Type", "application/json" );

        postConnection.setDoOutput( true );

        OutputStream os = postConnection.getOutputStream();

        os.write( POST_PARAMS.getBytes() );

        os.flush();

        os.close();

        int responseCode = postConnection.getResponseCode();

        System.out.println( "POST Response Code :  " + responseCode );

        System.out.println( "POST Response Message : " + postConnection.getResponseMessage() );

        BufferedReader in = new BufferedReader( new InputStreamReader(

                postConnection.getInputStream() ) );

        String inputLine;

        StringBuffer response = new StringBuffer();

        while ( ( inputLine = in.readLine() ) != null ) {

            response.append( inputLine );

        }
        in.close();

        // print result

        System.out.println( response.toString() );

        JSONObject myResponse = new JSONObject( response.toString() );
        System.out.println( myResponse.getString( "message" ) );

        JSONObject user = myResponse.getJSONObject( "values" );

        System.out.println( user.getString( "expiration" ) );
        System.out.println( user.getString( "token" ) );

    }
}
