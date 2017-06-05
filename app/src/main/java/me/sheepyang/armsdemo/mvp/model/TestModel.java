package me.sheepyang.armsdemo.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import javax.inject.Inject;

import io.reactivex.Observable;
import me.sheepyang.armsdemo.http.Service.TestService;
import me.sheepyang.armsdemo.mvp.contract.TestContract;


@ActivityScope
public class TestModel extends BaseModel implements TestContract.Model {
    private Gson mGson;
    private Application mApplication;

    @Inject
    public TestModel(IRepositoryManager repositoryManager, Gson gson, Application application) {
        super(repositoryManager);
        this.mGson = gson;
        this.mApplication = application;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<String> getWeather(int cityId) {
        return mRepositoryManager.obtainRetrofitService(TestService.class)
                .getWeather(cityId);
    }
}