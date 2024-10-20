package com.dao;

import com.entity.DuiwuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DuiwuxinxiVO;
import com.entity.view.DuiwuxinxiView;


/**
 * 队伍信息
 * 
 * @author 
 * @email 
 * @date 2023-04-25 10:50:40
 */
public interface DuiwuxinxiDao extends BaseMapper<DuiwuxinxiEntity> {
	
	List<DuiwuxinxiVO> selectListVO(@Param("ew") Wrapper<DuiwuxinxiEntity> wrapper);
	
	DuiwuxinxiVO selectVO(@Param("ew") Wrapper<DuiwuxinxiEntity> wrapper);
	
	List<DuiwuxinxiView> selectListView(@Param("ew") Wrapper<DuiwuxinxiEntity> wrapper);

	List<DuiwuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DuiwuxinxiEntity> wrapper);
	
	DuiwuxinxiView selectView(@Param("ew") Wrapper<DuiwuxinxiEntity> wrapper);
	

}
