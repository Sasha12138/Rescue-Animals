package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscussdongwubaikeEntity;
import com.entity.view.DiscussdongwubaikeView;

import com.service.DiscussdongwubaikeService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 动物百科评论表
 * 后端接口
 * @author 
 * @email
 */
@RestController
@RequestMapping("/discussdongwubaike")
public class DiscussdongwubaikeController {
    @Autowired
    private DiscussdongwubaikeService discussdongwubaikeService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussdongwubaikeEntity discussdongwubaike, 
		HttpServletRequest request){

        EntityWrapper<DiscussdongwubaikeEntity> ew = new EntityWrapper<DiscussdongwubaikeEntity>();


		PageUtils page = discussdongwubaikeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussdongwubaike), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussdongwubaikeEntity discussdongwubaike, 
		HttpServletRequest request){
        EntityWrapper<DiscussdongwubaikeEntity> ew = new EntityWrapper<DiscussdongwubaikeEntity>();

		PageUtils page = discussdongwubaikeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussdongwubaike), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussdongwubaikeEntity discussdongwubaike){
       	EntityWrapper<DiscussdongwubaikeEntity> ew = new EntityWrapper<DiscussdongwubaikeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussdongwubaike, "discussdongwubaike")); 
        return R.ok().put("data", discussdongwubaikeService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussdongwubaikeEntity discussdongwubaike){
        EntityWrapper< DiscussdongwubaikeEntity> ew = new EntityWrapper< DiscussdongwubaikeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussdongwubaike, "discussdongwubaike")); 
		DiscussdongwubaikeView discussdongwubaikeView =  discussdongwubaikeService.selectView(ew);
		return R.ok("查询动物百科评论表成功").put("data", discussdongwubaikeView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussdongwubaikeEntity discussdongwubaike = discussdongwubaikeService.selectById(id);
        return R.ok().put("data", discussdongwubaike);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussdongwubaikeEntity discussdongwubaike = discussdongwubaikeService.selectById(id);
        return R.ok().put("data", discussdongwubaike);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussdongwubaikeEntity discussdongwubaike, HttpServletRequest request){
    	discussdongwubaike.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussdongwubaike);

        discussdongwubaikeService.insert(discussdongwubaike);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussdongwubaikeEntity discussdongwubaike, HttpServletRequest request){
    	discussdongwubaike.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussdongwubaike);

        discussdongwubaikeService.insert(discussdongwubaike);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussdongwubaikeEntity discussdongwubaike, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussdongwubaike);
        discussdongwubaikeService.updateById(discussdongwubaike);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussdongwubaikeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
