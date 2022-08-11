# Admob-Interstitial-Ads

Dear user that simple library for you can use show admob interstitial ads with dialog and fast ads loading.

> Step 1. Add the JitPack repository to your build file

```gradle
allprojects {
		repositories {
			..
			maven { url 'https://jitpack.io' }
		}
	}
  ```
> Step 2. Add the dependency

```gradle
dependencies {
	        implementation 'com.github.kalathiyavraj:Admob-Interstitial-Ads:1.0'
	}
```

> Step 3. Add this line when you can show ads
```gradle
        AdGoogle.getInstance().showInterDialog(MainActivity.this, MainActivity.this, new AdGoogle.MyCallback() {
                    @Override
                    public void callbackCall() {


                        Toast.makeText(MainActivity.this, "Perform your next code :)", Toast.LENGTH_SHORT).show();
                    }
                });
```
> Step 4. Add this permission

```gradle
    <uses-permission android:name="android.permission.INTERNET"/>
```
> Step 5.    implementation project
```gradle
   implementation project(path: ':Admob Interstitial Ads')
```
