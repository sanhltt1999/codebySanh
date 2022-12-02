### ■ [ktlint](https://github.com/pinterest/ktlint)

Once you executed `./gradlew addKtlintFormatGitPreCommitHook` , it enables to run `./gradlew ktlintFormat` on each git commit.
Basically, standard and experimental rules are applied on ktlintFormat. If you want to add extra rules, you can edit `ktlint.gradle` or `.editorconfig` .

By [enabling experimental rules](https://lab.nitrotech.asia/nta-app/AndroidBaseKotlinMVVM/-/blob/master/ktlint.gradle#L39), code formatting on `.editorconfig` will be valid.

#### ■ [BuildType](https://developer.android.com/studio/build/build-variants)
We have `debug` and `release` as specified on [app/build.gradle](https://lab.nitrotech.asia/nta-app/AndroidBaseKotlinMVVM/-/blob/master/app/build.gradle).

These buildTypes are appended on each flavor names like `stgDebug` and `stgRelease` which can be used as a build variant on Android Studio, bitrise.

For more detail: https://developer.android.com/studio/build/build-variants


#### ■ [Fastlane](https://fastlane.tools/)
* Official website: https://fastlane.tools/
* Doc: https://docs.fastlane.tools/getting-started/android/setup/

install fastlane

* macOS:
    - install ruby
    - install fastlane : `brew install fastlane` or `sudo gem install fastlane`
    - open terminal: `fastlane`
    - output apk location: `rootProject/app/build/outputs/apk`

* Windows & linux: TODO

