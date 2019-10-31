package Fantasy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FantasyAPI {

    public static void main(String[] args) throws IOException {
        FantasyAPI fApi = new FantasyAPI();
        fApi.run();
    }

    public void run() {
        try {

            URL url = new URL("https://fantasy.premierleague.com/api/entry/2515433/history/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) { // throws error if status code is not 200!
                throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
            }

            BufferedReader bufferReader = new BufferedReader( new InputStreamReader(connection.getInputStream()));

            String JSONoutput;
            System.out.println("Json response: ");
            while ((JSONoutput = bufferReader.readLine()) != null) {

                System.out.println(JSONoutput);
            }

            connection.disconnect();
        }

        catch(MalformedURLException e) {
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();

        }
    }


    // Refactor code into a method called "run"
    // Next is to write a test for and mock the response from the fantasy league API

}
