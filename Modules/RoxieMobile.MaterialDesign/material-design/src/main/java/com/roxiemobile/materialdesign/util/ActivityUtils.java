package com.roxiemobile.materialdesign.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.roxiemobile.androidcommons.diagnostics.Guard;
import com.roxiemobile.androidcommons.logging.Logger;
import com.roxiemobile.androidcommons.logging.Logger.LogLevel;

public final class ActivityUtils
{
// MARK: - Construction

    private ActivityUtils() {
        // Do nothing
    }

// MARK: - Methods

    public static boolean lockActivityOrientation(@NonNull Activity activity) {
        Guard.notNull(activity, "activity is null");

        // Get default device orientation
        int orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

        if (ActivityUtils.isTablet(activity)) {
            orientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
        }

        // Force LOCK activity orientation
        activity.setRequestedOrientation(orientation);
        return true;
    }

    public static boolean unlockActivityOrientation(@NonNull Activity activity) {
        Guard.notNull(activity, "activity is null");

        // Force UNLOCK activity orientation
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        return true;
    }

    /**
     * Determine if the device is a tablet (i.e. it has a large screen).
     *
     * Ensuring Compatibility with a Utility Class
     * @link http://www.androiddesignpatterns.com/2012/06/compatability-manager-utility-class.html
     */
    public static boolean isTablet(@NonNull Context context) {
        Guard.notNull(context, "context is null");

        int screenSize = (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK);
        return screenSize >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    public static boolean isPhone(Context context) {
        return (context != null) && (!ActivityUtils.isTablet(context));
    }

    /**
     * Hides soft keyboard after typing in EditText.
     *
     * How to hide keyboard after typing in EditText in android?
     * @link http://stackoverflow.com/a/2342856
     */
    public static void hideSoftKeyboard(@NonNull Activity activity, boolean clearFocus) {
        Guard.notNull(activity, "activity is null");

        View view = activity.getCurrentFocus();
        if (view != null) {

            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

            if (view instanceof EditText && clearFocus) {
                view.clearFocus();
            }
        }
    }

    public static void hideSoftKeyboard(Activity activity) {
        hideSoftKeyboard(activity, false);
    }

    /**
     * Launch a new activity.
     */
    public static boolean startActivity(@NonNull Context context, @NonNull Intent intent) {
        Guard.notNull(context, "context is null");
        Guard.notNull(intent, "intent is null");

        boolean result = true;
        try {
            // Launch a new activity
            context.startActivity(intent);
        }
        catch (ActivityNotFoundException | IllegalStateException | NullPointerException e)
        {
            if (Logger.isLoggable(LogLevel.Debug)) {
                throw e;
            }

            // Handle exceptions in release builds
            Logger.e(TAG, e.getMessage());
            result = false;
        }

        // Done
        return result;
    }

    public static boolean startActivityForResult(@NonNull Activity activity, @NonNull Intent intent, int requestCode) {
        Guard.notNull(activity, "activity is null");
        Guard.notNull(intent, "intent is null");

        boolean result = true;
        try {
            // Launch a new activity
            activity.startActivityForResult(intent, requestCode);
        }
        catch (ActivityNotFoundException | IllegalStateException | NullPointerException e)
        {
            if (Logger.isLoggable(LogLevel.Debug)) {
                throw e;
            }

            // Handle exceptions in release builds
            Logger.e(TAG, e.getMessage());
            result = false;
        }

        // Done
        return result;
    }

// MARK: - Constants

    private static final String TAG = ActivityUtils.class.getSimpleName();
}
