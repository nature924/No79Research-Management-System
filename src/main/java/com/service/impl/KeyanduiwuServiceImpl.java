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


import com.dao.KeyanduiwuDao;
import com.entity.KeyanduiwuEntity;
import com.service.KeyanduiwuService;
import com.entity.vo.KeyanduiwuVO;
import com.entity.view.KeyanduiwuView;

@Service("keyanduiwuService")
public class KeyanduiwuServiceImpl extends ServiceImpl<KeyanduiwuDao, KeyanduiwuEntity> implements KeyanduiwuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KeyanduiwuEntity> page = this.selectPage(
                new Query<KeyanduiwuEntity>(params).getPage(),
                new EntityWrapper<KeyanduiwuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KeyanduiwuEntity> wrapper) {
		  Page<KeyanduiwuView> page =new Query<KeyanduiwuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KeyanduiwuVO> selectListVO(Wrapper<KeyanduiwuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KeyanduiwuVO selectVO(Wrapper<KeyanduiwuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KeyanduiwuView> selectListView(Wrapper<KeyanduiwuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KeyanduiwuView selectView(Wrapper<KeyanduiwuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<KeyanduiwuEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<KeyanduiwuEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<KeyanduiwuEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
