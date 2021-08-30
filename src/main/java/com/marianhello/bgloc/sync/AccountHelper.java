package com.marianhello.bgloc.sync;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.util.Log;

/**
 * Created by finch on 19/07/16.
 */
public class AccountHelper {
    /**
     * Create a new dummy account for the sync adapter
     *
     * @param context The application context
     */

    private static final String TAG = AccountHelper.class.getSimpleName();

    public static android.accounts.Account CreateSyncAccount(Context context, String accountName, String accountType) {
        Account account = new Account(accountName, accountType);
        Log.e(TAG, "*********************************************************");
        if (account != null) {
            Log.e(TAG, account.toString());
        }
        // Get an instance of the Android account manager
        AccountManager accountManager =  (AccountManager) context.getSystemService(Context.ACCOUNT_SERVICE);
        /*
         * Add the account and account type, no password or user data
         * If successful, return the Account object, otherwise report an error.
         */

        if (accountManager.addAccountExplicitly(account, null, null)) {
            /*
             * If you don't set android:syncable="true" in
             * in your <provider> element in the manifest,
             * then call context.setIsSyncable(account, AUTHORITY, 1)
             * here.
             */
        } else {
            /*
             * The account exists or some other error occurred. Log this, report it,
             * or handle it internally.
             */
            Log.e(TAG, "Adding account explicitly failed!");
        }
        return account;
    }
}
