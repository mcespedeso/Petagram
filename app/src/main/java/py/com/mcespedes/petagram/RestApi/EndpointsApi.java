package py.com.mcespedes.petagram.RestApi;

import py.com.mcespedes.petagram.RestApi.model.MascotaResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mcespedes on 19/12/16.
 */

public interface EndpointsApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER_BY_ID)
    Call<MascotaResponse> getRecentMediaUserByID();

    @GET(ConstantesRestApi.URL_GET_USER_DATA_BY_USER_NAME)
    Call<MascotaResponse> getUserDataByUserName();

}
