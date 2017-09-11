package test.ban.com.rxjava_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getRxjava();
    }

    private void getRxjava() {
            Observable<Integer> observable=Observable.create(new ObservableOnSubscribe<Integer>() {
                @Override
                public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                    e.onNext(1);
                    e.onNext(2);
                    e.onNext(3);
                    e.onComplete();
//                    e.onError(new IndexOutOfBoundsException("超限"));
                }
            });

        Observer<Integer> observer=new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(Integer value) {
                Log.i(TAG, "onNext: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError: ");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete: ");
            }
        };
        observable.subscribe(observer);


    }
}
