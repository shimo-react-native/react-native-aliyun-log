/**
 * @providesModule RNAliyunLogModule
 * @flow
 */

import { NativeModules, Platform } from 'react-native';
const AliyunLog = Platform.OS === 'ios' ?  NativeModules.RNAliyunLogModule : NativeModules.AliyunLog;

/**
 * 初始化日志服务
 *
 * @param endPoint
 * @param accessKeyId
 * @param accessKeySecret
 * @param securityToken
 * @param project
 * @returns {*}
 */
function init(endPoint, accessKeyId, accessKeySecret, securityToken = null, project) {
  return AliyunLog && AliyunLog.initAliyunLog && AliyunLog.initAliyunLog(endPoint, accessKeyId, accessKeySecret, securityToken, project);
}

/**
 * 发送日志
 *
 * @param logStore
 * @param topic
 * @param source
 * @param keyContents eg: [{ key: 'key1', content: 'content1' }, { key: 'key2', content: 'content2' }]
 * @returns {*}
 */
function post(logStore, topic, source, keyContents) {
  return AliyunLog && AliyunLog.postAliyunLog && AliyunLog.postAliyunLog(logStore, topic, source, keyContents);
}

export default {
  init,
  post
};
