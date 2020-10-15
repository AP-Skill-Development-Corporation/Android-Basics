package apssdc.in.indianews;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsService {

    @GET("top-headlines?country=in&apiKey=72348182e6434dee9875f07568b29334")
    Call<String> getNews();
}
