package com.roxiemobile.materialdesign.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.roxiemobile.materialdesign.ui.activity.base.BaseDrawerFragmentActivity;
import com.roxiemobile.materialdesign.ui.routing.RootIntentBuilder;
import com.roxiemobile.materialdesign.util.ActivityUtils;

import org.androidannotations.annotations.EActivity;

@EActivity(resName = "mdg__activity_root_with_drawer")
public class RootDrawerFragmentActivity extends BaseDrawerFragmentActivity
{
// MARK: - Construction

    public static void actionStart(Context context, Class<? extends Fragment> clazz) {
        actionStart(context, clazz, null);
    }

    public static void actionStart(Context context, Class<? extends Fragment> clazz, Bundle args) {
        Intent intent = new RootIntentBuilder().activity(RootDrawerFragmentActivity.class).fragment(clazz, args).build(context);
        ActivityUtils.startActivity(context, intent);
    }

}
