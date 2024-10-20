package com.dao;

import com.entity.KeyanchengguoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KeyanchengguoVO;
import com.entity.view.KeyanchengguoView;


/**
 * 科研成果
 * 
 * @author 
 * @email 
 * @date 2023-04-25 10:50:40
 */
public interface KeyanchengguoDao extends BaseMapper<KeyanchengguoEntity> {
	
	List<KeyanchengguoVO> selectListVO(@Param("ew") Wrapper<KeyanchengguoEntity> wrapper);
	
	KeyanchengguoVO selectVO(@Param("ew") Wrapper<KeyanchengguoEntity> wrapper);
	
	List<KeyanchengguoView> selectListView(@Param("ew") Wrapper<KeyanchengguoEntity> wrapper);

	List<KeyanchengguoView> selectListView(Pagination page,@Param("ew") Wrapper<KeyanchengguoEntity> wrapper);
	
	KeyanchengguoView selectView(@Param("ew") Wrapper<KeyanchengguoEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<KeyanchengguoEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<KeyanchengguoEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<KeyanchengguoEntity> wrapper);



}
