require 'json'
version = JSON.parse(File.read('package.json'))["version"]

Pod::Spec.new do |s|
  s.name             = 'react-native-aliyun-log'
  s.version          = version
  s.summary          = 'react-native-aliyun-log'
  s.homepage         = 'https://github.com/shimohq/react-native-aliyun-log'
  s.license          = { :type => 'MIT', :file => 'LICENSE' }
  s.author           = { 'lisong' => 'lisong@shimo.im' }
  s.source           = { :git => 'https://github.com/shimohq/react-native-aliyun-log.git', :tag => "v#{s.version}" }

  s.ios.deployment_target = '8.0'

  s.source_files = 'ios/**/*.{h,m,mm}'

  s.dependency 'React'
  s.dependency 'AliyunSlsObjc'
end
