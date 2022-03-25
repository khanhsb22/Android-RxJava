package com.example.rxdemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/*
* Using Observable, Observer, Disposable, DisposableObserver, CompositeDisposable
* */
public class MainActivity extends AppCompatActivity {
    private String greeting = "Hello from RxJava";
    private Observable<String> observable;
    private Observer<String> observer;
    private static final String TAG = "MainActivity";
    private TextView textView;
    private Disposable disposable;
    private DisposableObserver<String> disposableObserver;
    private DisposableObserver<String> disposableObserver2;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        observable = Observable.just(greeting);

        // Using observer
        /*observable.subscribeOn(Schedulers.io());
        observable.observeOn(AndroidSchedulers.mainThread());
        observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "onSubscribe invoked.");
                disposable = d;
            }

            @Override
            public void onNext(String s) {
                textView.setText(s);
                Log.i(TAG, "onNext invoked.");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError invoked.");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete invoked.");
            }
        };

        observable.subscribe(observer);*/

        // Efficient way of coding
        /*observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(observer);

        compositeDisposable.add(
                observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(disposableObserver)
        );*/

        // Using disposable
        disposableObserver = new DisposableObserver<String>() {
            @Override
            public void onNext(String s) {
                textView.setText(s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        compositeDisposable.add(disposableObserver);
        observable.subscribe(disposableObserver);

        disposableObserver2 = new DisposableObserver<String>() {
            @Override
            public void onNext(String s) {
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        compositeDisposable.add(disposableObserver2);
        observable.subscribe(disposableObserver2);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //disposable.dispose();
        //disposableObserver2.dispose();
        compositeDisposable.clear();
    }
}