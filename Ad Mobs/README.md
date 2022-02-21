1. add this dependency in gradle : implementation'com.google.android.gms:play-services-ads:20.4.0'
2. add this in manifest 
3. meta-data
 android:name="com.google.android.gms.ads.AD_MANAGER_APP"
  android:value="true"
  
4. Add this in your main activity
5. MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
6. go to https://developers.google.com/admob/android/quick-start here you will find all the add and its code which you can use

7. to get the add unit
8. select what kind of add
9. give it a name
10. get 2 id and click done
11. it will take you to the add unit and give you the id. 
12. use the id when you are going to upload the app in play store . 
13. Use the id in your xml file
       

            
      
