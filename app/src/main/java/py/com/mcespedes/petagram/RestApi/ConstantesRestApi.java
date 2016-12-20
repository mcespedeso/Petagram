package py.com.mcespedes.petagram.RestApi;

import android.content.SharedPreferences;

import py.com.mcespedes.petagram.RestApi.model.JsonKeys;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by mcespedes on 19/12/16.
 */

public final class ConstantesRestApi {

    //https://api.instagram.com/v1/users/self/media/recent/?access_token=ACCESS-TOKEN

    public static final String VERSION = "/v1/";

    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;

    public static final String ACCESS_TOKEN = "4269478833.3adcc63.93d395e4a6624137b12e38259777a9b4";

    public static final String KEY_ACCESS_TOKEN = "?access_token=";

    public static final String KEY_GET_RECENT_MEDIA_USER_SELF = "users/self/media/recent/";

    public static final String URL_GET_RECENT_MEDIA_USER_SELF = KEY_GET_RECENT_MEDIA_USER_SELF + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    public static  final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER_SELF + KEY_ACCESS_TOKEN + ACCESS_TOKEN;


    //access to user media recent by ID
    //https://api.instagram.com/v1/users/{user-id}/media/recent/?access_token=ACCESS-TOKEN

    //JAIME ID
    public static final String KEY_JAFERR_91_ID = "2294207961";

    public static final String KEY_GET_RECENT_MEDIA_USER_BY_ID = "users/"+KEY_JAFERR_91_ID+"/media/recent";

    public static final String URL_GET_RECENT_MEDIA_USER_BY_ID = KEY_GET_RECENT_MEDIA_USER_BY_ID + KEY_ACCESS_TOKEN + ACCESS_TOKEN;


}