package Database;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;

import com.example.schema.Data;
import com.example.schema.Employee;
import com.example.schema.MittSchema;
import com.example.schema.R;
import com.example.schema.ScheduleAdapter;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class GetSchedule extends AsyncTask<Void, Void, Void> {
    public Context context = null;
    public RecyclerView recyclerView = null;
    public Schedules schedulesList = new Schedules();
    public Handler handler;
    protected Void doInBackground(Void... voids){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder().cache(null);
        httpClient.addInterceptor(logging);

        Retrofit retrofitView = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/Anton2/webresources/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .client(httpClient.build())
                .build();
        Api service = retrofitView.create(Api.class);
        Call<Schedules> listSchedule = service.listSchedule();
        try {

            Response<Schedules> result = listSchedule.execute();
            schedulesList = result.body();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(Void result) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Data.data.ResetAll();
                for(int i = 0; i < schedulesList.scheduleTable.size(); i++) {
                    String datum = schedulesList.scheduleTable.get(i).getDatum();
                    String name = schedulesList.scheduleTable.get(i).getNamn();
                    boolean lunch = schedulesList.scheduleTable.get(i).isLunch();
                    boolean middag = schedulesList.scheduleTable.get(i).isMiddag();
                    Integer id = schedulesList.scheduleTable.get(i).getId();
                    if(name.equals("Wolf")) {
                        Data.data.addDates(new Employee(datum, lunch, middag, name, id));
                        System.out.println(name);
                    }

                }

                Data.data.sAdapter=new ScheduleAdapter(context);
                recyclerView.setAdapter(Data.data.sAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            }
        });
    }
}
