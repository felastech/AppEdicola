package it.balduzzi.serviceaccess;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import it.balduzzi.appedicola.R;

public class NetworkManager {

    private static final String TAG = "NetworkManager";
    private static final String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJwcm9qZWN0SWQiOiJwcmpfNWRmOGE4NGM4ZWY5YSIsInByb2plY3RQZXJtaXNzaW9uc0JpdG1hc2siOjF9.xNsGH_q3anUNhn64RZ-HX8chuqr5UkOuAFfUndleHK0";
    private static NetworkManager instance = null;
    private RequestQueue requestQueue;
    private Context mContext;

    private NetworkManager(Context context)
    {
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        mContext = context;
    }

    public static synchronized NetworkManager getInstance(Context context)
    {
        if (null == instance)
            instance = new NetworkManager(context);
        return instance;
    }

    public static synchronized NetworkManager getInstance()
    {
        if (null == instance)
        {
            throw new IllegalStateException(NetworkManager.class.getSimpleName() +
                    " errore la classe và instanziata");
        }
        return instance;
    }

    private String GetToken() {
        return  TOKEN;
    }

    public void requestGet(String api, String param, ListenerResponse listenerResponse) {

        String url = "";

        if(param == null || param.isEmpty())
        {
            url = mContext.getResources().getString(R.string.prefixURL) + api;
        }
        else
        {
             url = mContext.getResources().getString(R.string.prefixURL) + api + "/" + param;
        }

        Log.d(TAG + ": ", "URL : " + url);

        StringRequest request = new StringRequest(Request.Method.GET, url,
                response -> {
                    Log.d(TAG + ": ", "Response : " + response.toString());
                    if(null != response.toString())
                        listenerResponse.getResult(response.toString());
                },
                error -> {
                    if (null != error.networkResponse)
                    {
                        Log.d(TAG + ": ", "Error Response: " + error.networkResponse.statusCode);
                        listenerResponse.getResult(false);
                    }
                }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers =  new HashMap<String, String>();
                String credentials = GetToken();
                String encoded = "Bearer " + credentials;
                headers.put("Authorization", encoded);
                return headers;
            }
        };

        requestQueue.add(request);
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }
}
