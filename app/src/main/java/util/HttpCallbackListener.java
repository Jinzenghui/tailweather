package util;

/**
 * Created by BIAC on 2016/4/25.
 */
public interface HttpCallbackListener {

    void onFinish(String response);

    void onError(Exception e);

}
