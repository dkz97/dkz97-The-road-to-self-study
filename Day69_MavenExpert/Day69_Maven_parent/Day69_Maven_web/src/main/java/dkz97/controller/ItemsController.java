package dkz97.controller;

import dkz97.dao.ItemsDao;
import dkz97.domain.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 整合ssm中的controller
 */
@Controller
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsDao itemsDao;

    @RequestMapping("/test")
    public ModelAndView test(){
        List<Items> items = itemsDao.findAll();
        System.out.println("测试成功");
        ModelAndView mv = new ModelAndView();
        mv.addObject("item",items.get(0));
        mv.setViewName("success");
        return mv;
    }
}
