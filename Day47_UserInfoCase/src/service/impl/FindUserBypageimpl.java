package service.impl;

import dao.impl.UserDoimpl;
import domain.Page;
import domain.User;

import java.util.List;
import java.util.Map;

public class FindUserBypageimpl {

    public static Page<User> findUserByPage(int currentPage, int rows, Map<String, String[]> condition) {
        // 创建空的page对象
        Page<User> page = new Page<>();
        // 给对象设置当前页数和一页查询的数据
        page.setCurrentPage(currentPage);
        page.setRow( rows);

        // 调用dao方法来查询一共有多少条数据
        int totalCount = new UserDoimpl().findTotalCount(condition);
        page.setTotalCount(totalCount);

        // 计算得出，开始的索引
        int start = ( currentPage - 1) * rows;

        // 调用分页查询的方法来返回List集合
        List<User> byPage = new UserDoimpl().findByPage(start, rows,condition);
        page.setList(byPage);

        int totalpage = 0;
        // 设置总页码
        if (totalCount % rows == 0) {
            totalpage = totalCount / rows;
        } else {
            totalpage = (totalCount / rows) + 1;
        }
        page.setTotalPage(totalpage);

        System.out.println(page);
        return page;

    }

}
