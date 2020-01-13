package org.starrysea.mail.common.util;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.starrysea.mail.common.entity.dto.PageQueryInfo;
import org.starrysea.mail.common.entity.vo.ListDataWithPageInfo;

import java.util.List;
import java.util.function.Supplier;

public class PageQueryUtils {

    public static <T> ListDataWithPageInfo<T> pageQuery(PageQueryInfo pageQueryInfo, ISelect select) {
        Page<T> page;
        //如果前端传了orderBy字段,说明这次请求需要自定义排序
        if (StrUtil.isNotBlank(pageQueryInfo.getSortField())) {
            page = PageHelper.startPage(pageQueryInfo.getPageNum(), pageQueryInfo.getPageSize(), pageQueryInfo.getSortField() + " " + pageQueryInfo.getSortType());
        } else {
            //如果没有传,就直接使用普通的分页(默认排序就写在sql中,不需要pagehelper干涉)
            page = PageHelper.startPage(pageQueryInfo.getPageNum(), pageQueryInfo.getPageSize());
        }
        PageInfo<T> pageInfo = page.doSelectPageInfo(select);
        ListDataWithPageInfo<T> listDataWithPageInfo = new ListDataWithPageInfo<>();
        listDataWithPageInfo.setTotal(pageInfo.getTotal());
        listDataWithPageInfo.setRows(pageInfo.getList());
        return listDataWithPageInfo;
    }
}
