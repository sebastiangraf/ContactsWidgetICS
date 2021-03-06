/**
 * 
 */
package com.gmail.yuyang226.contactswidget.pro.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.CheckBox;

import com.gmail.yuyang226.contactswidget.pro.R;

/**
 * @author Toby Yu(yuyang226@gmail.com)
 *
 */
public class ContactsWidgetStackConfigurationActivity extends
ContactsWidgetDirectDialConfigurationActivity {
	public static final String PREF_LOOPCONTACTS_PREFIX = "loopcontacts_"; //$NON-NLS-1$

	public ContactsWidgetStackConfigurationActivity() {
		super(R.layout.appwidget_configure, R.layout.contact_entry_large);
	}
	
	/* (non-Javadoc)
	 * @see com.gmail.yuyang226.contactswidget.ContactsWidgetConfigurationActivity#savePreferences()
	 */
	@Override
	protected void savePreferences(Context context, int appWidgetId) {
		super.savePreferences(context, appWidgetId);
		CheckBox loopContacts = (CheckBox)findViewById(R.id.loopContacts);
		if (loopContacts != null) {
			saveLoopContacts(context, appWidgetId, loopContacts.isChecked());
		}
	}
	
	@Override
	protected int getImageSizeId() {
		return R.dimen.size_large;
	}
	
    /* (non-Javadoc)
	 * @see com.gmail.yuyang226.contactswidget.pro.ui.ContactsWidgetConfigurationActivity#isStackView()
	 */
	@Override
	protected boolean isStackView() {
		return true;
	}

	static void saveLoopContacts(Context context, int appWidgetId, boolean loopContacts) {
        SharedPreferences.Editor prefs = context.getSharedPreferences(PREF_LOOPCONTACTS_PREFIX, 0).edit();
        prefs.putString(PREF_LOOPCONTACTS_PREFIX + appWidgetId, String.valueOf(loopContacts));
        prefs.commit();
    }

    static boolean loadLoopContacts(Context context, int appWidgetId) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_LOOPCONTACTS_PREFIX, 0);
        String value = prefs.getString(PREF_LOOPCONTACTS_PREFIX + appWidgetId, Boolean.TRUE.toString());
        return Boolean.valueOf(value);
    }
    
}
