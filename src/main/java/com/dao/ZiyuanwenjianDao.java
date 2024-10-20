package com.dao;

import com.entity.ZiyuanwenjianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZiyuanwenjianVO;
import com.entity.view.ZiyuanwenjianView;


/**
 * 资源文件
 * 
 * @author 
 * @email 
 * @date 2023-04-25 10:50:40
 */
public interface ZiyuanwenjianDao extends BaseMapper<ZiyuanwenjianEntity> {
	
	List<ZiyuanwenjianVO> selectListVO(@Param("ew") Wrapper<ZiyuanwenjianEntity> wrapper);
	
	ZiyuanwenjianVO selectVO(@Param("ew") Wrapper<ZiyuanwenjianEntity> wrapper);
	
	List<ZiyuanwenjianView> selectListView(@Param("ew") Wrapper<ZiyuanwenjianEntity> wrapper);

	List<ZiyuanwenjianView> selectListView(Pagination page,@Param("ew") Wrapper<ZiyuanwenjianEntity> wrapper);
	
	ZiyuanwenjianView selectView(@Param("ew") Wrapper<ZiyuanwenjianEntity> wrapper);
	

}
