package cn.tekin.jbpm.demo.config;

import cn.tekin.jbpm.demo.domain.Role;
import cn.tekin.jbpm.demo.dao.RoleDao;
import org.kie.internal.identity.IdentityProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpringSecurityIdentityProvider implements IdentityProvider {

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public String getName() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated()) {
            return auth.getName();
        }
        return "system";
    }

    @Override
    public List<String> getRoles() {
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		if (auth != null && auth.isAuthenticated()) {
//			List<String> roles = new ArrayList<String>();
//
//			for (GrantedAuthority ga : auth.getAuthorities()) {
//				roles.add(ga.getAuthority());
//			}
//
//			return roles;
//		}


        ArrayList<String> arrayList = new ArrayList<String>();

        List<Role> roles = roleDao.findAll();
        if (roles != null && roles.size() > 0) {
            for (Role r : roles) {
                arrayList.add(r.getName());
            }
        }
        return arrayList.size() == 0 ? Collections.emptyList() : arrayList;
    }

    @Override
    public boolean hasRole(String role) {
        return false;
    }

}
