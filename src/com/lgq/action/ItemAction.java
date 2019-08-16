package com.lgq.action;

import com.lgq.service.IItemService;
import com.lgq.vo.Item;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/*")
public class ItemAction {
    @Resource(name = "itemServiceImpl")
    private IItemService iItemService;

}
