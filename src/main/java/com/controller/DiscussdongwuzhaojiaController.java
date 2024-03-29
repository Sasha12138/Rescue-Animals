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

import com.entity.DiscussdongwuzhaojiaEntity;
import com.entity.view.DiscussdongwuzhaojiaView;

import com.service.DiscussdongwuzhaojiaService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 动物找家评论表
 * 后端接口
 * @author 
 * @email
 */
@RestController
@RequestMapping("/discussdongwuzhaojia")
public class DiscussdongwuzhaojiaController {
    @Autowired
    private DiscussdongwuzhaojiaService discussdongwuzhaojiaService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussdongwuzhaojiaEntity discussdongwuzhaojia, 
		HttpServletRequest request){

        EntityWrapper<DiscussdongwuzhaojiaEntity> ew = new EntityWrapper<DiscussdongwuzhaojiaEntity>();


		PageUtils page = discussdongwuzhaojiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussdongwuzhaojia), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussdongwuzhaojiaEntity discussdongwuzhaojia, 
		HttpServletRequest request){
        EntityWrapper<DiscussdongwuzhaojiaEntity> ew = new EntityWrapper<DiscussdongwuzhaojiaEntity>();

		PageUtils page = discussdongwuzhaojiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussdongwuzhaojia), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussdongwuzhaojiaEntity discussdongwuzhaojia){
       	EntityWrapper<DiscussdongwuzhaojiaEntity> ew = new EntityWrapper<DiscussdongwuzhaojiaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussdongwuzhaojia, "discussdongwuzhaojia")); 
        return R.ok().put("data", discussdongwuzhaojiaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussdongwuzhaojiaEntity discussdongwuzhaojia){
        EntityWrapper< DiscussdongwuzhaojiaEntity> ew = new EntityWrapper< DiscussdongwuzhaojiaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussdongwuzhaojia, "discussdongwuzhaojia")); 
		DiscussdongwuzhaojiaView discussdongwuzhaojiaView =  discussdongwuzhaojiaService.selectView(ew);
		return R.ok("查询动物找家评论表成功").put("data", discussdongwuzhaojiaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussdongwuzhaojiaEntity discussdongwuzhaojia = discussdongwuzhaojiaService.selectById(id);
        return R.ok().put("data", discussdongwuzhaojia);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussdongwuzhaojiaEntity discussdongwuzhaojia = discussdongwuzhaojiaService.selectById(id);
        return R.ok().put("data", discussdongwuzhaojia);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussdongwuzhaojiaEntity discussdongwuzhaojia, HttpServletRequest request){
    	discussdongwuzhaojia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussdongwuzhaojia);

        discussdongwuzhaojiaService.insert(discussdongwuzhaojia);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussdongwuzhaojiaEntity discussdongwuzhaojia, HttpServletRequest request){
    	discussdongwuzhaojia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussdongwuzhaojia);

        discussdongwuzhaojiaService.insert(discussdongwuzhaojia);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussdongwuzhaojiaEntity discussdongwuzhaojia, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussdongwuzhaojia);
        discussdongwuzhaojiaService.updateById(discussdongwuzhaojia);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussdongwuzhaojiaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
