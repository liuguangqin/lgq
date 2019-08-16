package com.lgq.action;

import com.lgq.service.ILevelService;
import com.lgq.vo.Level;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/*")
public class LevelAction {
    @Resource(name="levelServiceImpl")
    private ILevelService levelService;
    @RequestMapping("/levelList")
    public ModelAndView list(){
        ModelAndView mav=new ModelAndView();
        List<Level>  list=this.levelService.list();
        mav.addObject("levels",list);
        mav.setViewName("/emp-add.jsp");
        return mav;
    }
    @RequestMapping("/logout")
    public ModelAndView logout(){
        ModelAndView mav=new ModelAndView();
        try{
            SecurityUtils.getSubject().logout();
            mav.setViewName("/login.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }
        return mav;
    }
}
