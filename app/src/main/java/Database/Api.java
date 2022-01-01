package Database;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Api {
    @Headers({
            "Accept: application/xml"
    })
    @GET("se.miun.enities.schedule")
    Call<Schedules> listSchedule();

    @Headers({"Content-Type: application/json"})
    @PUT("se.miun.enities.schedule/{id}")
    Call<Schedule> updateSchedule(@Path("id") int id, @Body Schedule body);
}
