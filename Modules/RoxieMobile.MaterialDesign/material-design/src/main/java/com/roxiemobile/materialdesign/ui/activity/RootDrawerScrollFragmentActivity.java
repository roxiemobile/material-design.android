package com.roxiemobile.materialdesign.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.roxiemobile.materialdesign.ui.routing.RootScrollIntentBuilder;
import com.roxiemobile.materialdesign.util.ActivityUtils;

public class RootDrawerScrollFragmentActivity extends RootDrawerFragmentActivity
{
// MARK: - Construction

    public static void actionStart(Context context, Class<? extends Fragment> clazz) {
        actionStart(context, clazz, null);
    }

    public static void actionStart(Context context, Class<? extends Fragment> clazz, Bundle args) {
        Intent intent = new RootScrollIntentBuilder().activity(RootDrawerFragmentActivity.class).fragment(clazz, args).build(context);
        ActivityUtils.startActivity(context, intent);
    }
}
