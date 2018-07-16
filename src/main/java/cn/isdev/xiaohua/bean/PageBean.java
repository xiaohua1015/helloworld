package cn.isdev.xiaohua.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/7/16.
 */
public class PageBean<T> {
    private int currentPage = 1;
    private int pageCount = 4;
    private int totalCount;
    private int totalPage;
    private List<T> pageData;

    public int getCurrentPage() {
        return currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        if (totalPage % pageCount == 0){
            return totalPage/pageCount;
        } else {
            return totalPage/pageCount + 1;
        }
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }
}
