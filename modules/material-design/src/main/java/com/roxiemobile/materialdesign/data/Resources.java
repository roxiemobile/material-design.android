package com.roxiemobile.materialdesign.data;

import android.support.annotation.IdRes;
import android.view.View;

import com.roxiemobile.materialdesign.R;

public interface Resources
{
// MARK: - Constants

    /**
     * TODO
     */
    interface Layout
    {
        @IdRes int ROOT_LAYOUT_ID = R.layout.mdg__layout_root;
        @IdRes int ROOT_WITH_SCROLL_LAYOUT_ID = R.layout.mdg__layout_root_with_scroll;
    }

    /**
     * Used to mark a Resource that has no ID.
     */
    interface ResId
    {
        int NO_ID = View.NO_ID;
    }
}
