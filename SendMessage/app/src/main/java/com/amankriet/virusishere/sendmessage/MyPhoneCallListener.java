package com.amankriet.virusishere.sendmessage;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

public class MyPhoneCallListener extends PhoneStateListener {

    private boolean returningFromOffHook = false;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    public void onCallStateChanged(int state, String incomingNumber) {
        String message = "Phone status";
        switch (state) {
            case TelephonyManager.CALL_STATE_RINGING:
                // Incoming call is ringing
                message = message +
                        "ringing" + incomingNumber;
                Log.i(TAG, message);
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                // Phone call is active -- off the hook
                message = message + "off the hook";
                Log.i(TAG, message);
                returningFromOffHook = true;
                break;
            case TelephonyManager.CALL_STATE_IDLE:
                // Phone is idle before and after phone call.
                // If running on version older than 19 (KitKat),
                // restart activity when phone call ends.
                message = message + "Idle";
                Log.i(TAG, message);
                break;
            default:
                message = message + "Phone off";
                Log.i(TAG, message);
                break;
        }
    }
}
