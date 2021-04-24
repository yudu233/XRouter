package com.rain.arouterdemo.arouter.callback;

import android.content.Intent;

import androidx.annotation.NonNull;

public abstract class RouteCallback<T>{

    public void onResponse(int requestCode, int resultCode, Intent data){
        if(data != null){
            try{
                T parseData = parseData(requestCode, resultCode, data);
                if(parseData != null){
                    onResponse(parseData);
                }else{
                    onError(new RuntimeException("no data parsed"));
                }
            }catch(Exception e){
                onError(new RuntimeException("an exception been catched when parsing data", e));
            }
        }else{
            onCancel();
        }
    }


    public abstract T parseData(int requestCode, int resultCode, @NonNull Intent data);

    /** Invoked when parsing not null data by {@link #parseData(int, int, Intent)} */
    public abstract void onResponse(@NonNull T data);

    /**
     * Invoked when the intent is null
     * @see #onResponse(int, int, Intent)
     */
    public void onCancel(){}

    /** Invoked when no data parsed by {@link #parseData(int, int, Intent)} or exception throws */
    public void onError(Throwable throwable){}

}
