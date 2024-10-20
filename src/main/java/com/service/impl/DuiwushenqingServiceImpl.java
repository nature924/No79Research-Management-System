package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DuiwushenqingDao;
import com.entity.DuiwushenqingEntity;
import com.service.DuiwushenqingService;
import com.entity.vo.DuiwushenqingVO;
import com.entity.view.DuiwushenqingView;

@Service("duiwushenqingService")
public class DuiwushenqingServiceImpl extends ServiceImpl<DuiwushenqingDao, DuiwushenqingEntity> implements DuiwushenqingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DuiwushenqingEntity> page = this.selectPage(
                new Query<DuiwushenqingEntity>(params).getPage(),
                new EntityWrapper<DuiwushenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DuiwushenqingEntity> wrapper) {
		  Page<DuiwushenqingView> page =new Query<DuiwushenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DuiwushenqingVO> selectListVO(Wrapper<DuiwushenqingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DuiwushenqingVO selectVO(Wrapper<DuiwushenqingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DuiwushenqingView> selectListView(Wrapper<DuiwushenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DuiwushenqingView selectView(Wrapper<DuiwushenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
