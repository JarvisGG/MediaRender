package com.geniusgithub.mediarender.util;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.framed.Header;

/**
 * 判断投屏请求媒体文件类型
 * Created by Jarvis on 2016/6/29.
 */
public class MediaTypeJudgeUtil {

    private String mUrl;
    private OkHttpClient client = new OkHttpClient();
    private static int MediaType;
    private static MediaTypeJudgeUtil Instance = null;

    public MediaTypeJudgeUtil() {
    }

    public static MediaTypeJudgeUtil getInstance() {
        if (Instance == null) {
            Instance = new MediaTypeJudgeUtil();

        }
        return Instance;
    }

    /**
     * 获取请求头
     * @param uri
     */

    public void getRequestHeader(String uri) throws Exception {
        Request request = new Request.Builder()
                .url(uri)
                .build();


        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Headers header = response.headers();
                for (int i = 0; i < header.size(); i++) {
                    Log.e("responseHeader", header.name(i) + ": " + header.value(i));
                    if (header.name(i).equals(MediaTypeContants.CONTENT_TYPE)) {
                        MediaType = MediaTypeContants.AnalysisMediaType(header.value(i));
                    }
                }
            }
        });
    }

    public int getMediaTyle() {
        return MediaType;
    }

}
