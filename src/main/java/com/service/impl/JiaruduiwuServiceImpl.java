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


import com.dao.JiaruduiwuDao;
import com.entity.JiaruduiwuEntity;
import com.service.JiaruduiwuService;
import com.entity.vo.JiaruduiwuVO;
import com.entity.view.JiaruduiwuView;

@Service("jiaruduiwuService")
public class JiaruduiwuServiceImpl extends ServiceImpl<JiaruduiwuDao, JiaruduiwuEntity> implements JiaruduiwuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiaruduiwuEntity> page = this.selectPage(
                new Query<JiaruduiwuEntity>(params).getPage(),
                new EntityWrapper<JiaruduiwuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiaruduiwuEntity> wrapper) {
		  Page<JiaruduiwuView> page =new Query<JiaruduiwuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JiaruduiwuVO> selectListVO(Wrapper<JiaruduiwuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiaruduiwuVO selectVO(Wrapper<JiaruduiwuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiaruduiwuView> selectListView(Wrapper<JiaruduiwuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiaruduiwuView selectView(Wrapper<JiaruduiwuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
