package com.lgq.action;

import com.lgq.service.IEmpService;
import com.lgq.vo.Emp;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/*")
public class EmpAction {
    @Resource(name = "empServiceImpl")
    private IEmpService empService;

    @RequestMapping("empList")
    public ModelAndView list(){
        ModelAndView mav=new ModelAndView();
        List<Emp>  list=this.empService.list();
        mav.addObject("emps",list);
        mav.setViewName("/emp-list.jsp");
        return mav;
     }
     @RequestMapping("empUpdate")
     public ModelAndView updateEmp(Emp vo){
        ModelAndView mav=new ModelAndView();
        this.empService.update(vo);
        mav.setViewName("/empList.action");
        return mav;
     }
    @RequestMapping("empUpdatePre")
    public ModelAndView updateEmpPre(Emp vo){
        ModelAndView mav=new ModelAndView();
        Emp emp=this.empService.findByEid(vo.getEid());
        mav.addObject("vo",emp);
        mav.setViewName("/emp-edit.jsp");
        return mav;
    }
    @RequestMapping("empInsertPre")
    public ModelAndView insertPre(Emp vo){
        Emp emp= this.empService.findByEid(vo.getEid());
        ModelAndView mav=new ModelAndView();
        if(emp!=null){
            mav.setViewName("/empList.action");
        }
        mav.setViewName("/deptslist.action");
        mav.setViewName("/empInsert.action");
        return mav;
    }
    @RequestMapping("empInsert")
    public ModelAndView  insert(Emp vo, MultipartFile file, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("redirect:/empList.action");
        String fileExt="jpg";
        String outFilePath="C:\\Users\\刘广琴\\Desktop\\businessTravelProject\\web\\upload\\"+UUID.randomUUID()+"."+fileExt;
        try {
            file.transferTo(new File(outFilePath));
           // System.out.println(outFilePath+"s航船路径**********");
           // System.out.println(request.getServletContext().getRealPath("/"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        vo.setPhoto(outFilePath.substring(47));
        vo.setLocked(0);
        vo.setHiredate(new Date());
         this.empService.insert(vo);
        return mav;
    }
    @RequestMapping("empLocked")
    @ResponseBody
    public boolean locked(@RequestBody String  vo){
        String eid=vo.substring(8,vo.length()-2);
        String  eids[]=eid.split(",");
        return this.empService.locked(eids);
    }
    @RequestMapping("LoginUrl")
    public  ModelAndView login(String eid,String password){
        ModelAndView mav=new ModelAndView();
        UsernamePasswordToken token=new UsernamePasswordToken(eid,password);
        try {
            SecurityUtils.getSubject().login(token);
            mav.setViewName("/empList.action");
        }catch(Exception e){
            e.printStackTrace();

        }
        return mav;
    }
}
