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


import com.dao.DiscussziyuanwenjianDao;
import com.entity.DiscussziyuanwenjianEntity;
import com.service.DiscussziyuanwenjianService;
import com.entity.vo.DiscussziyuanwenjianVO;
import com.entity.view.DiscussziyuanwenjianView;

@Service("discussziyuanwenjianService")
public class DiscussziyuanwenjianServiceImpl extends ServiceImpl<DiscussziyuanwenjianDao, DiscussziyuanwenjianEntity> implements DiscussziyuanwenjianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussziyuanwenjianEntity> page = this.selectPage(
                new Query<DiscussziyuanwenjianEntity>(params).getPage(),
                new EntityWrapper<DiscussziyuanwenjianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussziyuanwenjianEntity> wrapper) {
		  Page<DiscussziyuanwenjianView> page =new Query<DiscussziyuanwenjianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussziyuanwenjianVO> selectListVO(Wrapper<DiscussziyuanwenjianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussziyuanwenjianVO selectVO(Wrapper<DiscussziyuanwenjianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussziyuanwenjianView> selectListView(Wrapper<DiscussziyuanwenjianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussziyuanwenjianView selectView(Wrapper<DiscussziyuanwenjianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
