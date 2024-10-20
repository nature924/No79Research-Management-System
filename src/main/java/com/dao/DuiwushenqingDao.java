package com.dao;

import com.entity.DuiwushenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DuiwushenqingVO;
import com.entity.view.DuiwushenqingView;


/**
 * 队伍申请
 * 
 * @author 
 * @email 
 * @date 2023-04-25 10:50:40
 */
public interface DuiwushenqingDao extends BaseMapper<DuiwushenqingEntity> {
	
	List<DuiwushenqingVO> selectListVO(@Param("ew") Wrapper<DuiwushenqingEntity> wrapper);
	
	DuiwushenqingVO selectVO(@Param("ew") Wrapper<DuiwushenqingEntity> wrapper);
	
	List<DuiwushenqingView> selectListView(@Param("ew") Wrapper<DuiwushenqingEntity> wrapper);

	List<DuiwushenqingView> selectListView(Pagination page,@Param("ew") Wrapper<DuiwushenqingEntity> wrapper);
	
	DuiwushenqingView selectView(@Param("ew") Wrapper<DuiwushenqingEntity> wrapper);
	

}
