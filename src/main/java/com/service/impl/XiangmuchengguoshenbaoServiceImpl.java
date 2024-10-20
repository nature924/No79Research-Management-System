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


import com.dao.XiangmuchengguoshenbaoDao;
import com.entity.XiangmuchengguoshenbaoEntity;
import com.service.XiangmuchengguoshenbaoService;
import com.entity.vo.XiangmuchengguoshenbaoVO;
import com.entity.view.XiangmuchengguoshenbaoView;

@Service("xiangmuchengguoshenbaoService")
public class XiangmuchengguoshenbaoServiceImpl extends ServiceImpl<XiangmuchengguoshenbaoDao, XiangmuchengguoshenbaoEntity> implements XiangmuchengguoshenbaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiangmuchengguoshenbaoEntity> page = this.selectPage(
                new Query<XiangmuchengguoshenbaoEntity>(params).getPage(),
                new EntityWrapper<XiangmuchengguoshenbaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiangmuchengguoshenbaoEntity> wrapper) {
		  Page<XiangmuchengguoshenbaoView> page =new Query<XiangmuchengguoshenbaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XiangmuchengguoshenbaoVO> selectListVO(Wrapper<XiangmuchengguoshenbaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XiangmuchengguoshenbaoVO selectVO(Wrapper<XiangmuchengguoshenbaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XiangmuchengguoshenbaoView> selectListView(Wrapper<XiangmuchengguoshenbaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiangmuchengguoshenbaoView selectView(Wrapper<XiangmuchengguoshenbaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
