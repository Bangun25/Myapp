package dota.draftdota2.JSON;


import org.json.JSONObject;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;



/**
 * Created by Aulia on 6/3/2016.
 */
public class JSONParse {

    InputStream is = null;
    JSONObject jobj = null;
    String json ="";

    public JSONObject ambilJSON(String url){
        try {
            DefaultHttpclient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new httpPost(url);
            HttpResponse = httpClient.execute(httpPost);
            HttpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();

        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        } catch (ClientProtocolExeption e ){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine())!=null) {
                sb.append(line);
            }
            is.close();
            json = sb.toString();

        } catch (Exception e){
            Log.e("Buffer error", "Error converting result " + e.toString());
        }

        try {
            jObj = new JSONObject(json);
        } catch (JSONException e){
            Log.e("JSON parser", "Error parsing data " + e.toString());
        }
        return jObj;
    }
}