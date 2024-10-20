package com.dao;

import com.entity.KeyanduiwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KeyanduiwuVO;
import com.entity.view.KeyanduiwuView;


/**
 * 科研队伍
 * 
 * @author 
 * @email 
 * @date 2023-04-25 10:50:40
 */
public interface KeyanduiwuDao extends BaseMapper<KeyanduiwuEntity> {
	
	List<KeyanduiwuVO> selectListVO(@Param("ew") Wrapper<KeyanduiwuEntity> wrapper);
	
	KeyanduiwuVO selectVO(@Param("ew") Wrapper<KeyanduiwuEntity> wrapper);
	
	List<KeyanduiwuView> selectListView(@Param("ew") Wrapper<KeyanduiwuEntity> wrapper);

	List<KeyanduiwuView> selectListView(Pagination page,@Param("ew") Wrapper<KeyanduiwuEntity> wrapper);
	
	KeyanduiwuView selectView(@Param("ew") Wrapper<KeyanduiwuEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<KeyanduiwuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<KeyanduiwuEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<KeyanduiwuEntity> wrapper);



}
