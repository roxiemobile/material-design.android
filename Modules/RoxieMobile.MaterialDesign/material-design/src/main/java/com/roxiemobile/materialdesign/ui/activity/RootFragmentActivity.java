package com.roxiemobile.materialdesign.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.roxiemobile.materialdesign.R2;
import com.roxiemobile.materialdesign.ui.activity.base.BaseFragmentActivity;
import com.roxiemobile.materialdesign.ui.routing.LeafIntentBuilder;
import com.roxiemobile.materialdesign.util.ActivityUtils;

import org.androidannotations.annotations.EActivity;

@EActivity(R2.layout.mdg__activity_root)
public class RootFragmentActivity extends BaseFragmentActivity
{
// MARK: - Construction

    public static void actionStart(Context context, Class<? extends Fragment> clazz) {
        actionStart(context, clazz, null);
    }

    public static void actionStart(Context context, Class<? extends Fragment> clazz, Bundle args) {
        Intent intent = new LeafIntentBuilder().activity(RootFragmentActivity.class).fragment(clazz, args).build(context);
        ActivityUtils.startActivity(context, intent);
    }
}
