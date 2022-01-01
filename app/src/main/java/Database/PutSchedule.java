package Database;

import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PutSchedule extends AsyncTask<Void, Void, Void>{
    public Schedule schedule = new Schedule();
    public Handler handler;
    protected Void doInBackground(Void... voids){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/Anton2/webresources/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        Api service = retrofit.create(Api.class);
        Call<Schedule> call = service.updateSchedule(schedule.getId(), schedule);
        call.enqueue(new Callback<Schedule>() {
            @Override
            public void onResponse(Call<Schedule> call, Response<Schedule> response) {
                int statusCode = response.code();
                Log.d(null, "onResponse: " + statusCode);
            }

            @Override
            public void onFailure(Call<Schedule> call, Throwable t) {
                Log.d(null, "onFailure: " + t.getMessage());
            }
        });

        return null;
    }
}
