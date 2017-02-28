package com.tongjin.frames.Net;

import com.itheima.retrofitutils.ItheimaHttp;
import com.itheima.retrofitutils.Request;
import com.itheima.retrofitutils.RequestMethod;
import com.itheima.retrofitutils.listener.HttpResponseListener;
import com.itheima.retrofitutils.listener.UploadListener;
import com.tongjin.frames.Bean.Bean;

import java.io.File;
import java.util.Map;

import okhttp3.MediaType;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by songyq on 2017/2/27.
 */
public class NetRequest {

    private static NetRequest ourInstance = new NetRequest();

    public static NetRequest getInstance() {
        return ourInstance;
    }

    private NetRequest() {
    }

    // 参数是String的Get请求
    public void getString(String deviceId, String bt_id, String page_size, String cat_id, String access_token, String page_no, String act_id, HttpResponseListener<String> listener) {
        Request request = ItheimaHttp.newGetRequest(NetUrl.COMMON_URL);
        // request.putHeader(key,value); 添加请求头
        request.putParams("deviceId", deviceId);
        request.putParams("bt_id", bt_id);
        request.putParams("page_size",page_size);
        request.putParams("cat_id",cat_id);
        request.putParams("access_token", access_token);
        request.putParams("page_no",page_no);
        request.putParams("act_id",act_id);
        ItheimaHttp.send(request, listener);
    }

    // 参数是Bean的Get请求
    public void getBean(Map<String, Object> params, HttpResponseListener<Bean> listener) {
        Request request = ItheimaHttp.newGetRequest(NetUrl.COMMON_URL);
        request.putParamsMap(params);
        ItheimaHttp.send(request,listener);
    }

    // 上传文件
    public void upLoad(String url, File uploadFile, UploadListener listener) {

        Request request = ItheimaHttp.newUploadRequest(url, RequestMethod.POST);

        request.putUploadFile(uploadFile)
                .putMediaType(MediaType.parse("multipart/form-data"));
        ItheimaHttp.upload(request, listener);
    }
}
