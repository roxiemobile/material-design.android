package com.roxiemobile.materialdesign.ui.routing;

import android.support.annotation.LayoutRes;

import com.roxiemobile.materialdesign.data.Resources.Layout;

public class RootScrollIntentBuilder extends RootIntentBuilder
{
// MARK: - Methods

    @Override
    protected @LayoutRes int activityContainerId() {
        return Layout.ROOT_WITH_SCROLL_LAYOUT_ID;
    }
}
