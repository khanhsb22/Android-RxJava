package com.example.rxdemo;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class SomeObservable {
    public static void main(String[] args) {
        /*Maybe<String> maybe = Maybe.just("Single item");
        maybe.subscribe(new MaybeObserver<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(String s) {
                System.out.println("Item received: " + s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                // Sẽ ko được in ra vì có item được emit
                System.out.println("Complete.");
            }
        });*/

        /*Maybe<Integer> emptySource = Maybe.empty();
        emptySource.subscribe(new MaybeObserver<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(Integer integer) {
                System.out.println("Item received from emptySource: " + integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                // Maybe cho phép không có item nào được emit ra, vì thế onComplete()
                // sẽ được gọi khi ko có item nào emit
                System.out.println("Done from EmptySource");
            }
        });*/

        /*Single<Integer> integerSingle = Single.just(3);
        integerSingle.subscribe(new SingleObserver<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            // Phương thức onNext() và onComplete() của Observable đã
            // được kết hợp thành phương thức onSuccess().
            @Override
            public void onSuccess(Integer integer) {
                System.out.println("onSuccess with item: " + integer);
            }

            @Override
            public void onError(Throwable e) {

            }
        });*/

        // Completable đọc thêm tại: https://viblo.asia/p/rxjava-single-maybe-and-completable-gAm5ybzVKdb
    }
}
