package com.lgq.Realm;

import com.lgq.service.IEmpService;
import com.lgq.service.ILevelService;
import com.lgq.vo.DeptRole;
import com.lgq.vo.Emp;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class memberRealm extends AuthorizingRealm {
    @Resource(name = "empServiceImpl")
    private IEmpService empService;
    @Resource(name="levelServiceImpl")
    private ILevelService iLevelService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    String eid=(String)principalCollection.getPrimaryPrincipal();
    SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        Map<String,Object> map=this.iLevelService.findById(Long.parseLong(eid));
        Set<String> rids=(Set<String>)map.get("rids");
        Set<String> actids=(Set<String>)map.get("actids");
       info.setRoles(rids);
       info.setStringPermissions(actids);
       return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String eid=(String) authenticationToken.getPrincipal();//取得用户名
        String password=new String((char[])authenticationToken.getCredentials());//取得密码
        //Emp emp=  empService.login(eid);
        Emp emp=empService.findByEid(Long.parseLong(eid));
        if(password.equals(emp.getPassword())){
            SecurityUtils.getSubject().getSession().setAttribute("ename",emp.getEname());
            SecurityUtils.getSubject().getSession().setAttribute("eid",emp.getEid());
            SecurityUtils.getSubject().getSession().setAttribute("photo",emp.getPhoto());
            return new SimpleAuthenticationInfo(eid,password,"memberRealm");
        }else{
            throw new UnknownAccountException("用户不存在");
        }
    }
}
