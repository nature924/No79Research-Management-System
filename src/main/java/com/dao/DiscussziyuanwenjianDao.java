package com.dao;

import com.entity.DiscussziyuanwenjianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussziyuanwenjianVO;
import com.entity.view.DiscussziyuanwenjianView;


/**
 * 资源文件评论表
 * 
 * @author 
 * @email 
 * @date 2023-04-25 10:50:41
 */
public interface DiscussziyuanwenjianDao extends BaseMapper<DiscussziyuanwenjianEntity> {
	
	List<DiscussziyuanwenjianVO> selectListVO(@Param("ew") Wrapper<DiscussziyuanwenjianEntity> wrapper);
	
	DiscussziyuanwenjianVO selectVO(@Param("ew") Wrapper<DiscussziyuanwenjianEntity> wrapper);
	
	List<DiscussziyuanwenjianView> selectListView(@Param("ew") Wrapper<DiscussziyuanwenjianEntity> wrapper);

	List<DiscussziyuanwenjianView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussziyuanwenjianEntity> wrapper);
	
	DiscussziyuanwenjianView selectView(@Param("ew") Wrapper<DiscussziyuanwenjianEntity> wrapper);
	

}
