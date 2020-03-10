package it.balduzzi.DA;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import it.balduzzi.Model.OutputPublications;

public class VolleyRest {

    private static final String TAG = "VolleyRest";

    OutputPublications GetResponse()
    {


        return null;
    }

    public void GetPublications(RequestQueue queue)
    {
   // RequestQueue queue = Volley.newRequestQueue(this);

    String url ="https://api-ne.paperlit.com/v8/projects/prj_5df8a84c8ef9a/publications";



    // Request a string response from the provided URL.
    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    Log.v(TAG, "Risposta API OK");

                    Gson gson = new Gson();
                    OutputPublications publication = gson.fromJson(response, OutputPublications.class);

                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

            Log.v(TAG, "Risposta API KO");
        }
    }) {
        @Override
        public Map<String, String> getHeaders() throws AuthFailureError {
            Map<String, String> headers =  new HashMap<String, String>();
            String credentials = GetToken();
            String encoded = "Bearer " + credentials;
            headers.put("Authorization", encoded);
            return headers;
        }
    };

        queue.add(stringRequest);
    }

    private String GetToken() {
        return  "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJwcm9qZWN0SWQiOiJwcmpfNWRmOGE4NGM4ZWY5YSIsInByb2plY3RQZXJtaXNzaW9uc0JpdG1hc2siOjF9.xNsGH_q3anUNhn64RZ-HX8chuqr5UkOuAFfUndleHK0";
    }
}
