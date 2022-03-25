package com.example.rxdemo;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SomeOperator {
    public static void main(String[] args) {
        // create
        /*final Task task = new Task("Description of task 1", false, 1);
        Observable<Task> taskObservable = Observable.create(new ObservableOnSubscribe<Task>() {
            @Override
            public void subscribe(ObservableEmitter<Task> emitter) throws Exception {
                if (!emitter.isDisposed()) {
                    emitter.onNext(task);
                    emitter.onComplete();
                }
            }
        }).subscribeOn(Schedulers.io());
        // Nếu làm trên android thì phải thêm: .observeOn(AndroidSchedulers.mainThread())

        taskObservable.subscribe(new Observer<Task>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Task task) {
                System.out.println("onNext: " + task.getDescription() + ", " + task.isComplete());
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Complete task.");
            }
        });*/

        // range
        /*Observable<Integer> integerObservable = Observable.range(0, 9)
                .subscribeOn(Schedulers.io());

        integerObservable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext: " + integer); // Print 0-8
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });*/

        // repeat
        Observable<Integer> observable = Observable.range(0, 3)
                .subscribeOn(Schedulers.io()).repeat(3);

        observable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext: " + integer); // Print x3 times 0,1,2
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
