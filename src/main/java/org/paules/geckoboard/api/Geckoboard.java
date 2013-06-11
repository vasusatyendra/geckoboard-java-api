package org.paules.geckoboard.api;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.paules.geckoboard.api.gson.GsonFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

public class Geckoboard {
    private final Logger         logger               = LoggerFactory.getLogger( getClass() );

    private static final int     RECOMMENDED_TIME_OUT = 70000;

    private static final String  CONTENT_TYPE         = "Content-Type";

    private static final String  CONTENT_TYPE_VALUE   = "application/json";

    private static final Charset DEFAULT_CHARSET      = Charset.forName( "UTF-8" );

    private static void bestEffortToReleaseHttpWithoutExceptions( final OutputStream httpOutputStream, final InputStream httpInputStream, final HttpURLConnection connection ) {
        IOUtils.closeQuietly( httpOutputStream );
        IOUtils.closeQuietly( httpInputStream );
        if ( connection != null ) {
            connection.disconnect();
        }
    }

    private final String apiKey;

    public Geckoboard( String apiKey ) {
        this.apiKey = apiKey;
    }

    private HttpURLConnection createAndOpenConnection( String widgetKey ) throws IOException {
        final URL url = new URL( "https://push.geckoboard.com/v1/send/" + widgetKey );
        final HttpURLConnection connection = ( HttpURLConnection ) url.openConnection();
        connection.addRequestProperty( CONTENT_TYPE, CONTENT_TYPE_VALUE );
        connection.setDoOutput( true );
        connection.setRequestMethod( "POST" );
        connection.setConnectTimeout( RECOMMENDED_TIME_OUT );
        connection.setReadTimeout( RECOMMENDED_TIME_OUT );
        return connection;
    }

    public void push( Push push ) throws IOException {
        WidgetWrapper wrapper = new WidgetWrapper( push, apiKey );
        Gson gson = GsonFactory.getGson();
        String json = gson.toJson( wrapper );
        HttpURLConnection connection = null;
        OutputStream httpOutputStream = null;
        InputStream httpInputStream = null;
        try {
            connection = createAndOpenConnection( push.getWidgetKey() );
            httpOutputStream = connection.getOutputStream();
            logger.info( "Sending: " + json );
            IOUtils.write( json.getBytes(DEFAULT_CHARSET), httpOutputStream );
            if ( connection.getResponseCode() >= 400 ) {
                logger.error( new String( IOUtils.toByteArray( connection.getErrorStream() ), DEFAULT_CHARSET ) );
                return;
            }
            httpInputStream = connection.getInputStream();
            final byte[] responseXml = IOUtils.toByteArray( httpInputStream );
            logger.info( new String( responseXml, DEFAULT_CHARSET ) );
        }
        finally {
            bestEffortToReleaseHttpWithoutExceptions( httpOutputStream, httpInputStream, connection );
        }
    }
}
