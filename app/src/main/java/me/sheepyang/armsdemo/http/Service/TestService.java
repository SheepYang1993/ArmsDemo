package me.sheepyang.armsdemo.http.Service;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by SheepYang on 2017-06-05.
 */

public interface TestService {
    @GET("http://www.weather.com.cn/data/sk/{cityId}.html")
    Observable<String> getWeather(@Path("cityId") int cityId);
}
