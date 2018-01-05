# react-native-aliyun-log

阿里云日志服务 react native SDK

集成 [AliyunLogObjc](https://github.com/lujiajing1126/AliyunLogObjc) 和 [aliyun-log-android-sdk](https://github.com/aliyun/aliyun-log-android-sdk)

## 安装

```sh
npm i --save react-native-aliyun-log
react-native link react-native-aliyun-log
```

## 使用

### iOS

在工程中参考 [AliyunLogObjc](https://github.com/lujiajing1126/AliyunLogObjc)，使用 Carthage 方式集成

```sh
github "lujiajing1126/AliyunLogObjc"
```

### Android

参考 [aliyun-log-android-sdk](https://github.com/aliyun/aliyun-log-android-sdk/blob/master/app/src/main/java/com/aliyun/sls/MainActivity.java)

## 例子

```js
import AliyunLog from 'react-native-aliyun-log';

AliyunLog.init('endPoint', 'accessKeyId', 'accessKeySecret', null, 'project');
AliyunLog.post('app', 'topic', 'source', [{ key: 'key1', content: 'content1' }, { key: 'key2', content: 'content2' }]);
```
