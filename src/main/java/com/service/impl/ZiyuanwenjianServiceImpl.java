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


import com.dao.ZiyuanwenjianDao;
import com.entity.ZiyuanwenjianEntity;
import com.service.ZiyuanwenjianService;
import com.entity.vo.ZiyuanwenjianVO;
import com.entity.view.ZiyuanwenjianView;

@Service("ziyuanwenjianService")
public class ZiyuanwenjianServiceImpl extends ServiceImpl<ZiyuanwenjianDao, ZiyuanwenjianEntity> implements ZiyuanwenjianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZiyuanwenjianEntity> page = this.selectPage(
                new Query<ZiyuanwenjianEntity>(params).getPage(),
                new EntityWrapper<ZiyuanwenjianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZiyuanwenjianEntity> wrapper) {
		  Page<ZiyuanwenjianView> page =new Query<ZiyuanwenjianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZiyuanwenjianVO> selectListVO(Wrapper<ZiyuanwenjianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZiyuanwenjianVO selectVO(Wrapper<ZiyuanwenjianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZiyuanwenjianView> selectListView(Wrapper<ZiyuanwenjianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZiyuanwenjianView selectView(Wrapper<ZiyuanwenjianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
