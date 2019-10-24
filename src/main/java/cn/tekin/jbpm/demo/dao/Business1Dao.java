package cn.tekin.jbpm.demo.dao;

import cn.tekin.jbpm.demo.domain.Business1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Business1Dao  extends JpaRepository<Business1, String> {
}
