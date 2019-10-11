package Fantasy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FantasyAPI {
    // http://localhost:8080/RESTfulExample/json/product/get
    public static void main(String[] args) throws IOException {
        try {

            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
            }

            BufferedReader bufferReader = new BufferedReader( new InputStreamReader(connection.getInputStream()));

            String output;
            System.out.println("Json response: ");
            while ((output = bufferReader.readLine()) != null) {
                System.out.println(output);
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

}
