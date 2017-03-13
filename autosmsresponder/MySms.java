package com.example.autosmsresponder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MySms extends BroadcastReceiver {

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		String senderaddress = null,message = null;
		try {
			Bundle b = arg1.getExtras();
			Object[] pdus = (Object[]) b.get("pdus");
			for(int i = 0 ; i < pdus.length; i++){
				SmsMessage sms = SmsMessage.createFromPdu((byte[])pdus[i]);
				senderaddress = sms.getOriginatingAddress();
				message = sms.getMessageBody();
				
				Toast.makeText(arg0, "Sender : "+senderaddress+"Message: "+message,Toast.LENGTH_LONG).show();
			}
			SmsManager sms = SmsManager.getDefault();
			sms.sendTextMessage(senderaddress, null, "O lage ma uli nako taod2", null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

