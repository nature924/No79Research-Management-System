package com.dao;

import com.entity.JiaruduiwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiaruduiwuVO;
import com.entity.view.JiaruduiwuView;


/**
 * 加入队伍
 * 
 * @author 
 * @email 
 * @date 2023-04-25 10:50:40
 */
public interface JiaruduiwuDao extends BaseMapper<JiaruduiwuEntity> {
	
	List<JiaruduiwuVO> selectListVO(@Param("ew") Wrapper<JiaruduiwuEntity> wrapper);
	
	JiaruduiwuVO selectVO(@Param("ew") Wrapper<JiaruduiwuEntity> wrapper);
	
	List<JiaruduiwuView> selectListView(@Param("ew") Wrapper<JiaruduiwuEntity> wrapper);

	List<JiaruduiwuView> selectListView(Pagination page,@Param("ew") Wrapper<JiaruduiwuEntity> wrapper);
	
	JiaruduiwuView selectView(@Param("ew") Wrapper<JiaruduiwuEntity> wrapper);
	

}
