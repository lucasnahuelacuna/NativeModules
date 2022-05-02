package com.nativemodules;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.util.Map;
import java.util.HashMap;
import android.util.Log;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.modules.core.DeviceEventManagerModule;

public class CalendarModule extends ReactContextBaseJavaModule {
    private int eventCount = 0;

    CalendarModule(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return "CalendarModule";
    }

    @ReactMethod
    public void createCalendarEvent(Callback callback) {
        Log.d("Calendar Module", "Logged from our calendar module");
        callback.invoke("Data returned from Native Calendar Module");
    }

    @ReactMethod
    public void createCalendarPromise(Promise promise) {
        try {
            promise.resolve("Data returned from promise");
            eventCount += 1;
            sendEvent(getReactApplicationContext(), "EventCount", eventCount);
        } catch(Exception e) {
            promise.reject("Error returned from promise", e);
        }
    }

    private void sendEvent(ReactContext reactContext,
                           String eventName,
                           int params) {
        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);
    }
}

