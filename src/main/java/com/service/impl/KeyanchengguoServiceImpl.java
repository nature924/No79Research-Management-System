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


import com.dao.KeyanchengguoDao;
import com.entity.KeyanchengguoEntity;
import com.service.KeyanchengguoService;
import com.entity.vo.KeyanchengguoVO;
import com.entity.view.KeyanchengguoView;

@Service("keyanchengguoService")
public class KeyanchengguoServiceImpl extends ServiceImpl<KeyanchengguoDao, KeyanchengguoEntity> implements KeyanchengguoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KeyanchengguoEntity> page = this.selectPage(
                new Query<KeyanchengguoEntity>(params).getPage(),
                new EntityWrapper<KeyanchengguoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KeyanchengguoEntity> wrapper) {
		  Page<KeyanchengguoView> page =new Query<KeyanchengguoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KeyanchengguoVO> selectListVO(Wrapper<KeyanchengguoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KeyanchengguoVO selectVO(Wrapper<KeyanchengguoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KeyanchengguoView> selectListView(Wrapper<KeyanchengguoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KeyanchengguoView selectView(Wrapper<KeyanchengguoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<KeyanchengguoEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<KeyanchengguoEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<KeyanchengguoEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
