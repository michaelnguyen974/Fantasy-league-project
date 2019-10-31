package FantasyAPITest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import Fantasy.FantasyAPI;


public class FantasyAPITest {
    private static final int HTTPREQUEST200 = 200;

    @Test
    public void testValidHTTPRequestToFantasyAPI() throws ClientProtocolException, IOException {

        // Given
        HttpUriRequest request = new HttpGet("https://fantasy.premierleague.com/api/entry/2515433/history/");

        // When
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        // Then
        assertEquals(httpResponse.getStatusLine().getStatusCode(), HTTPREQUEST200);
    }

    @Test
    public void testFantasyApiAPICall() throws ClientProtocolException, IOException {

        // Given
        
        // When

        // Then
    }
}
