package nyc.c4q.leighdouglas.dec21exam;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;

import nyc.c4q.leighdouglas.dec21exam.model.AnimalList;
import nyc.c4q.leighdouglas.dec21exam.recyclerview.AnimalAdapter;
import nyc.c4q.leighdouglas.dec21exam.service.AnimalService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by leighdouglas on 12/21/16.
 */

public class AnimalFragment extends Fragment {

    private AnimalAdapter adapter;
    private RecyclerView recyclerView;


    private static String TAG = "Retrofit";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.animal_fragment, container, false);
        adapter = new AnimalAdapter();
        recyclerView = (RecyclerView) view.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        runRetrofitCall();
    }

    private void runRetrofitCall() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AnimalService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AnimalService service = retrofit.create(AnimalService.class);
        Call<AnimalList> call = service.getAnimals();

        call.enqueue(new Callback<AnimalList>() {
            @Override
            public void onResponse(Call<AnimalList> call, Response<AnimalList> response) {
                try {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "Success");
                        adapter.setmAnimalList(response.body().getAnimals());
                    } else {
                        Log.d(TAG, "Error" + response.errorBody().string());
                    }
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<AnimalList> call, Throwable t) {
                // Something went completely wrong (like no internet connection)
                Log.d("Error", t.getMessage());
            }
        });

    }
}
