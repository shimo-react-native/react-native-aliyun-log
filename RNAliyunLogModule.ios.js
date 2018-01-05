/**
 * @providesModule RNAliyunLogModule
 * @flow
 */
'use strict';

var NativeRNAliyunLogModule = require('NativeModules').RNAliyunLogModule;

/**
 * High-level docs for the RNAliyunLogModule iOS API can be written here.
 */

var RNAliyunLogModule = {
  test: function() {
    NativeRNAliyunLogModule.test();
  }
};

module.exports = RNAliyunLogModule;
