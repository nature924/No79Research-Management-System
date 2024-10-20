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


import com.dao.DiscusskeyanchengguoDao;
import com.entity.DiscusskeyanchengguoEntity;
import com.service.DiscusskeyanchengguoService;
import com.entity.vo.DiscusskeyanchengguoVO;
import com.entity.view.DiscusskeyanchengguoView;

@Service("discusskeyanchengguoService")
public class DiscusskeyanchengguoServiceImpl extends ServiceImpl<DiscusskeyanchengguoDao, DiscusskeyanchengguoEntity> implements DiscusskeyanchengguoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusskeyanchengguoEntity> page = this.selectPage(
                new Query<DiscusskeyanchengguoEntity>(params).getPage(),
                new EntityWrapper<DiscusskeyanchengguoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusskeyanchengguoEntity> wrapper) {
		  Page<DiscusskeyanchengguoView> page =new Query<DiscusskeyanchengguoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusskeyanchengguoVO> selectListVO(Wrapper<DiscusskeyanchengguoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusskeyanchengguoVO selectVO(Wrapper<DiscusskeyanchengguoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusskeyanchengguoView> selectListView(Wrapper<DiscusskeyanchengguoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusskeyanchengguoView selectView(Wrapper<DiscusskeyanchengguoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
