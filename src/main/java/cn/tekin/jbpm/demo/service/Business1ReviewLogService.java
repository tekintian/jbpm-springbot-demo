package cn.tekin.jbpm.demo.service;


import cn.tekin.jbpm.demo.dao.Business1ReviewLogDao;
import cn.tekin.jbpm.demo.domain.Business1ReviewLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Business1ReviewLogService {

    @Autowired
    private Business1ReviewLogDao business1ReviewLogDao;

    public List<Business1ReviewLog> findBusiness1ReviewLogByBid(Integer bid){
        return business1ReviewLogDao.findByBid(bid);
    }

    public Business1ReviewLog findBusiness1ReviewLogByTidAndPid(Integer tid,Integer pid){
        return business1ReviewLogDao.findBusiness1ReviewLogByTidAndPid(tid,pid);
    }

    public Business1ReviewLog findBusiness1ReviewLogByPid(Integer pid){
        return business1ReviewLogDao.findBusiness1ReviewLogByPid(pid);
    }

  public void save(Business1ReviewLog business1ReviewLog){
        business1ReviewLogDao.save(business1ReviewLog);
    }

}
