package wooqer.com.wooqer;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class PostCardItemDecoration extends RecyclerView.ItemDecoration {

    private final int mSpaceHeight;

    public PostCardItemDecoration(int mSpaceHeight) {
        this.mSpaceHeight = mSpaceHeight;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        outRect.bottom = mSpaceHeight;
        outRect.top = mSpaceHeight;
        outRect.left = mSpaceHeight;
        outRect.right = mSpaceHeight;
    }
}
