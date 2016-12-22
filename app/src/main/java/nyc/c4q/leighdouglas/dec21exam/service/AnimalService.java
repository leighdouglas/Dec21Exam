package nyc.c4q.leighdouglas.dec21exam.service;

import nyc.c4q.leighdouglas.dec21exam.model.AnimalList;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by leighdouglas on 12/21/16.
 */

public interface AnimalService {
    static String BASE_URL = "http://jsjrobotics.nyc/";

    @GET("cgi-bin/12_21_2016_exam.pl")
    Call<AnimalList> getAnimals();
}
