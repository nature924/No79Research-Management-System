package com.dao;

import com.entity.XiangmuchengguoshenbaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XiangmuchengguoshenbaoVO;
import com.entity.view.XiangmuchengguoshenbaoView;


/**
 * 项目成果申报
 * 
 * @author 
 * @email 
 * @date 2023-04-25 10:50:40
 */
public interface XiangmuchengguoshenbaoDao extends BaseMapper<XiangmuchengguoshenbaoEntity> {
	
	List<XiangmuchengguoshenbaoVO> selectListVO(@Param("ew") Wrapper<XiangmuchengguoshenbaoEntity> wrapper);
	
	XiangmuchengguoshenbaoVO selectVO(@Param("ew") Wrapper<XiangmuchengguoshenbaoEntity> wrapper);
	
	List<XiangmuchengguoshenbaoView> selectListView(@Param("ew") Wrapper<XiangmuchengguoshenbaoEntity> wrapper);

	List<XiangmuchengguoshenbaoView> selectListView(Pagination page,@Param("ew") Wrapper<XiangmuchengguoshenbaoEntity> wrapper);
	
	XiangmuchengguoshenbaoView selectView(@Param("ew") Wrapper<XiangmuchengguoshenbaoEntity> wrapper);
	

}
