package py.com.mcespedes.petagram.RestApi;

import py.com.mcespedes.petagram.RestApi.model.MascotaResponse;
import py.com.mcespedes.petagram.RestApi.model.UsuarioResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by mcespedes on 19/12/16.
 */

public interface EndpointsApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER_BY_ID)
    Call<MascotaResponse> getRecentMediaUserByID();

    @GET(ConstantesRestApi.URL_GET_USER_DATA_BY_USER_NAME)
    Call<MascotaResponse> getUserDataByUserName();

    @FormUrlEncoded
    @POST(ConstantesRestApi.KEY_POST_HEROKU_ID_TOKEN)
    Call<UsuarioResponse> registrarTokenID(@Field("token") String token);

    @FormUrlEncoded
    @POST(ConstantesRestApi.KEY_POST_USER_INSTAGRAM)
    Call<String> registrarUsuarioInstagram(@Field("token") String token, @Field("user_instagram") String user_instagram);

}