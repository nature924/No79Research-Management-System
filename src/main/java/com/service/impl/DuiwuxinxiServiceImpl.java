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


import com.dao.DuiwuxinxiDao;
import com.entity.DuiwuxinxiEntity;
import com.service.DuiwuxinxiService;
import com.entity.vo.DuiwuxinxiVO;
import com.entity.view.DuiwuxinxiView;

@Service("duiwuxinxiService")
public class DuiwuxinxiServiceImpl extends ServiceImpl<DuiwuxinxiDao, DuiwuxinxiEntity> implements DuiwuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DuiwuxinxiEntity> page = this.selectPage(
                new Query<DuiwuxinxiEntity>(params).getPage(),
                new EntityWrapper<DuiwuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DuiwuxinxiEntity> wrapper) {
		  Page<DuiwuxinxiView> page =new Query<DuiwuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DuiwuxinxiVO> selectListVO(Wrapper<DuiwuxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DuiwuxinxiVO selectVO(Wrapper<DuiwuxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DuiwuxinxiView> selectListView(Wrapper<DuiwuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DuiwuxinxiView selectView(Wrapper<DuiwuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
