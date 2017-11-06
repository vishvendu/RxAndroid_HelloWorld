package com.example.vishvendu.rxandroid_helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    Observable<String> integerObservable;
    Observer<String> integerObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CreateObservable();
        CreateObserver();
    }

    private void CreateObserver() {

        integerObserver = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("", "onSubscribe: ");
            }

            @Override
            public void onNext(String value) {
                Log.e("", "onNext: " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("", "onError: ");
            }

            @Override
            public void onComplete() {
                Log.e("", "onComplete: ");
            }
        } ;

        //Create our subscription//
        integerObservable.subscribe(integerObserver);

    }

    private void CreateObservable() {

         integerObservable = Observable.just("Hello World!");



    }
}
