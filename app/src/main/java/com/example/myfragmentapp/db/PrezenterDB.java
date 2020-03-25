package com.example.myfragmentapp.db;

import com.example.myfragmentapp.model.Fishing;
import com.example.myfragmentapp.model.LureModel;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposable;


public class PrezenterDB implements RxRepositiriDb {
    @Override
    public Observable<List<Fishing>> getFisingList() {
        Observable<List<Fishing>> listObservable = Observable.fromArray(Fishing.listAll(Fishing.class));
        return listObservable;

    }

    @Override
    public Observable<Fishing> getItemFishing(long key) {
        Observable<Fishing> fishingObservable = Observable.just(Fishing.findById(Fishing.class, key));
        return fishingObservable;
    }

    @Override
    public Single<Fishing> getItemFishingInDB(final long key) {
        final Fishing fishing = Fishing.findById(Fishing.class, key);
        return Single.create(emitter -> {
            if (!emitter.isDisposed()) {
                emitter.onSuccess(fishing);

            }
        });
    }

    @Override
    public Observable<List<LureModel>> getListLureModelDB() {
        return Observable.fromArray(LureModel.listAll(LureModel.class));
    }


    public Completable myComplit(final Fishing fishing) {
        return Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(CompletableEmitter emitter) throws Exception {
                fishing.save();
                emitter.onComplete();

            }
        });
    }


}
