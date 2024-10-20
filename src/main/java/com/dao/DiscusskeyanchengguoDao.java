package com.dao;

import com.entity.DiscusskeyanchengguoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusskeyanchengguoVO;
import com.entity.view.DiscusskeyanchengguoView;


/**
 * 科研成果评论表
 * 
 * @author 
 * @email 
 * @date 2023-04-25 10:50:41
 */
public interface DiscusskeyanchengguoDao extends BaseMapper<DiscusskeyanchengguoEntity> {
	
	List<DiscusskeyanchengguoVO> selectListVO(@Param("ew") Wrapper<DiscusskeyanchengguoEntity> wrapper);
	
	DiscusskeyanchengguoVO selectVO(@Param("ew") Wrapper<DiscusskeyanchengguoEntity> wrapper);
	
	List<DiscusskeyanchengguoView> selectListView(@Param("ew") Wrapper<DiscusskeyanchengguoEntity> wrapper);

	List<DiscusskeyanchengguoView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusskeyanchengguoEntity> wrapper);
	
	DiscusskeyanchengguoView selectView(@Param("ew") Wrapper<DiscusskeyanchengguoEntity> wrapper);
	

}
