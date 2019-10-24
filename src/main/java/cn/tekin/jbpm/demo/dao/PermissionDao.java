package cn.tekin.jbpm.demo.dao;

import cn.tekin.jbpm.demo.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionDao extends JpaRepository<Permission, String> {




//    @Query("select new Permission(p.id,p.name,p.url,p.pid,p.createTime) from User u LEFT JOIN Role r ON u.rid = r.id LEFT JOIN RolePermission rp ON r.id = rp.rid LEFT JOIN Permission p ON rp.pid = p.id where u.id = :userId")
    @Query(value = "select p.* from t_permission p LEFT JOIN t_role_permission rp ON rp.pid = p.id LEFT JOIN t_user_role ur ON ur.rid = rp.rid where ur.uid = ?1",nativeQuery = true)
    public List<Permission> findByAdminUserId(@Param("userId")Integer userId);

    public List findAll();

}
