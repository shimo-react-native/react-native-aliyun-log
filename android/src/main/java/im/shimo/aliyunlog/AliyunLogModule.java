package im.shimo.aliyunlog;

import com.aliyun.sls.android.sdk.ClientConfiguration;
import com.aliyun.sls.android.sdk.LOGClient;
import com.aliyun.sls.android.sdk.core.auth.StsTokenCredentialProvider;
import com.aliyun.sls.android.sdk.model.Log;
import com.aliyun.sls.android.sdk.model.LogGroup;
import com.aliyun.sls.android.sdk.request.PostLogRequest;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

/**
 * Created by bell on 2018/1/5.
 */

public class AliyunLogModule extends ReactContextBaseJavaModule {

    private String mProject;
    private LOGClient mlogClient;

    public AliyunLogModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "AliyunLog";
    }

    @ReactMethod
    public void initAliyunLog(String endPoint, String accessKeyId, String accessKeySecret, String securityToken, String project) {
        mProject = project;
        StsTokenCredentialProvider credentialProvider =
                new StsTokenCredentialProvider(accessKeyId, accessKeySecret, securityToken != null ? securityToken : "" );
        ClientConfiguration conf = new ClientConfiguration();
        mlogClient = new LOGClient(endPoint, credentialProvider, conf);
    }

    @ReactMethod
    public void postAliyunLog(String logStore, String topic, String source, ReadableArray keyContents) {
        LogGroup logGroup = new LogGroup(topic, source);

        Log log = new Log();
        for (int index = 0; index < keyContents.size(); index++) {
            ReadableMap keyContent = keyContents.getMap(index);
            log.PutContent(keyContent.getString("key"), keyContent.getString("content"));
        }
        logGroup.PutLog(log);

        try {
            PostLogRequest request = new PostLogRequest(mProject, logStore, logGroup);
            if(mlogClient == null) {
                return;
            }
            mlogClient.asyncPostLog(request, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
