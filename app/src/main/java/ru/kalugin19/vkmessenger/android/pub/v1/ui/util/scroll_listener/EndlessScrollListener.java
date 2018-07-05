package ru.kalugin19.vkmessenger.android.pub.v1.ui.util.scroll_listener;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

/**
 * Custom Scroll Listener for Recycler View
 */
public abstract class EndlessScrollListener extends RecyclerView.OnScrollListener {

    // The minimum amount of items to have below your current scroll position
    // before loading more.
    private int visibleThreshold = 5;
    // The current offset index of data you have loaded
    private int currentPage = 0;
    // True if we are still waiting for the last set of data to load.
    private boolean isLoading = false;
    private boolean isEnd = false;
    // Sets the starting page index
    @SuppressWarnings("FieldCanBeLocal")
    private final int startingPageIndex = 0;
    private boolean isReverse = false;

    private static final int MIN_COUNT_ITEMS_FOR_SCROLL_TO_DOWN = 2;

    private final RecyclerView.LayoutManager mLayoutManager;

    @SuppressWarnings("unused")
    public EndlessScrollListener(LinearLayoutManager layoutManager, @SuppressWarnings("SameParameterValue") int visibleThreshold) {
        this.mLayoutManager = layoutManager;
        this.visibleThreshold = visibleThreshold;
    }

    @SuppressWarnings("unused")
    public EndlessScrollListener(LinearLayoutManager layoutManager, @SuppressWarnings("SameParameterValue") int visibleThreshold, boolean isReverse) {
        this.mLayoutManager = layoutManager;
        this.visibleThreshold = visibleThreshold;
        this.isReverse = isReverse;
    }

    @SuppressWarnings("unused")
    public EndlessScrollListener(LinearLayoutManager layoutManager) {
        this.mLayoutManager = layoutManager;
    }

    @SuppressWarnings("unused")
    public EndlessScrollListener(GridLayoutManager layoutManager) {
        this.mLayoutManager = layoutManager;
        visibleThreshold = visibleThreshold * layoutManager.getSpanCount();
    }

    @SuppressWarnings("unused")
    public EndlessScrollListener(StaggeredGridLayoutManager layoutManager) {
        this.mLayoutManager = layoutManager;
        visibleThreshold = visibleThreshold * layoutManager.getSpanCount();
    }

    @SuppressWarnings("unused")
    public EndlessScrollListener(RecyclerView.LayoutManager mLayoutManager) {
        this.mLayoutManager = mLayoutManager;
    }

    private int getLastVisibleItem(int[] lastVisibleItemPositions) {
        int maxSize = 0;
        for (int i = 0; i < lastVisibleItemPositions.length; i++) {
            if (i == 0) {
                maxSize = lastVisibleItemPositions[i];
            } else if (lastVisibleItemPositions[i] > maxSize) {
                maxSize = lastVisibleItemPositions[i];
            }
        }
        return maxSize;
    }

    /**
     * Поиск минимальной позиции видимого элемнта
     *
     * @param firstVisibleItemPostion - видвимые элементы в начале списка
     * @return - минимальная позиция видимого элемента
     */
    @SuppressWarnings("unused")
    private int getFirstVisibilityItem(int[] firstVisibleItemPostion) {
        int minSize = 0;
        for (int i = 0; i < firstVisibleItemPostion.length; i++) {
            if (i == 0) {
                minSize = firstVisibleItemPostion[i];
            } else if (firstVisibleItemPostion[i] < minSize) {
                minSize = firstVisibleItemPostion[i];
            }
        }
        return minSize;
    }

    // This happens many times a second during a scroll, so be wary of the code you place here.
    // We are given a few useful parameters to help us work out if we need to load some more data,
    // but first we check if we are waiting for the previous load to finish.
    @Override
    public void onScrolled(RecyclerView view, int dx, int dy) {
        super.onScrolled(view, dx, dy);
        int totalItemCount = mLayoutManager.getItemCount();
        if (isReverse) {
            int firstVisiblePosition = getFirstVisibleItem();
            if (!isEnd && !isLoading && visibleThreshold >= firstVisiblePosition && totalItemCount >= visibleThreshold) {
                currentPage++;
                onLoadMore(currentPage, totalItemCount, view);
            }

        } else {
            int lastVisibleItemPosition = getLastVisibleItem();
            if (!isEnd && !isLoading && totalItemCount <= (lastVisibleItemPosition + visibleThreshold) && totalItemCount >= visibleThreshold) {
                currentPage++;
                onLoadMore(currentPage, totalItemCount, view);
            }
        }
    }

    // Call this method whenever performing new searches
    @SuppressWarnings("unused")
    public void resetState() {
        this.currentPage = this.startingPageIndex;
        this.isLoading = true;
        this.isEnd = false;
    }

    // Defines the process for actually loading more data based on page
    @SuppressWarnings("UnusedParameters")
    public abstract void onLoadMore(int page, int totalItemsCount, RecyclerView view);

    @SuppressWarnings("unused")
    public void setEnd(boolean end) {
        isEnd = end;
    }

    @SuppressWarnings("unused")
    public void setLoading(boolean isLoading) {
        this.isLoading = isLoading;
    }

    public void errorLoadLastPage() {
        currentPage--;
    }

    /**
     * Близко ли к концу списка, нужно ли скролить к новому сообщению
     *
     * @return true - еобходимо проскролить к последнему сообщению, false - скролить не нужно
     */
    public boolean isVisibilityLastElement() {
        int totalItemCount = mLayoutManager.getItemCount();
        if (isReverse) {
            int lastVisibleItemPosition = getLastVisibleItem();
            return totalItemCount - MIN_COUNT_ITEMS_FOR_SCROLL_TO_DOWN <= lastVisibleItemPosition && totalItemCount >= visibleThreshold;
        } else {
            int firstVisibleItem = getFirstVisibleItem();
            return MIN_COUNT_ITEMS_FOR_SCROLL_TO_DOWN >= firstVisibleItem && totalItemCount >= visibleThreshold;
        }
    }

    private int getLastVisibleItem() {
        if (mLayoutManager instanceof StaggeredGridLayoutManager) {
            int[] lastVisibleItemPositions = ((StaggeredGridLayoutManager) mLayoutManager).findLastVisibleItemPositions(null);
            // get maximum element within the list
            return getLastVisibleItem(lastVisibleItemPositions);
        } else if (mLayoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) mLayoutManager).findLastVisibleItemPosition();
        } else if (mLayoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) mLayoutManager).findLastVisibleItemPosition();
        }
        return 0;
    }

    private int getFirstVisibleItem() {
        if (mLayoutManager instanceof StaggeredGridLayoutManager) {
            int[] firstVisiblePositions = ((StaggeredGridLayoutManager) mLayoutManager).findFirstVisibleItemPositions(null);
            // get maximum element within the list
            return getLastVisibleItem(firstVisiblePositions);
        } else if (mLayoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) mLayoutManager).findFirstVisibleItemPosition();
        } else if (mLayoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) mLayoutManager).findFirstVisibleItemPosition();
        }
        return 0;
    }
}
