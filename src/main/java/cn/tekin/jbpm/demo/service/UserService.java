package cn.tekin.jbpm.demo.service;

import cn.tekin.jbpm.demo.dao.PermissionDao;
import cn.tekin.jbpm.demo.dao.RoleDao;
import cn.tekin.jbpm.demo.dao.UserDao;
import cn.tekin.jbpm.demo.dao.UserRoleDao;
import cn.tekin.jbpm.demo.domain.Permission;
import cn.tekin.jbpm.demo.domain.Role;
import cn.tekin.jbpm.demo.domain.User;
import cn.tekin.jbpm.demo.domain.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Allen on 18/5/12.
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Autowired
    RoleDao roleDao;

    @Autowired
    UserRoleDao userRoleDao;


    @Autowired
    PermissionDao permissionDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user != null) {
            List<Permission> permissions = permissionDao.findByAdminUserId(user.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (Permission permission : permissions) {
                if (permission != null && permission.getName() != null) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                    //1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
    }

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public List<Role> findRoleByUserName(String userName) {
        User user = userDao.findByUsername(userName);
        if (user != null) {
            return roleDao.findByUserName(user.getId());
        }
        return null;
    }

    /***
     * 查询所有用户
     * @return
     */
    public List<User> findAll() {
        return userDao.findAll();
    }


    public void save(User user,List<UserRole> userRoles) {
        userDao.save(user);
        for(UserRole userRole:userRoles){
            userRole.setUid(user.getId());
            userRoleDao.save(userRole);
        }
    }
}
