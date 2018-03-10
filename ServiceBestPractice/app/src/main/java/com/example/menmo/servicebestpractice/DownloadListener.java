package com.example.menmo.servicebestpractice;

/**
 * Created by Administrator on 2018/3/10 0010.
 */

public interface DownloadListener {
    void onProgress(int progress);

    void onSuccess();

    void onFailed();

    void onPaused();

    void onCanceled();
}
