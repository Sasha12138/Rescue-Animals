package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 动物领养
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-06-24 08:54:46
 */
@TableName("dongwulingyang")
public class DongwulingyangEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DongwulingyangEntity() {
		
	}
	
	public DongwulingyangEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 动物昵称
	 */
					
	private String dongwunicheng;
	
	/**
	 * 动物种类
	 */
					
	private String dongwuzhonglei;
	
	/**
	 * 动物性别
	 */
					
	private String dongwuxingbie;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 发布账号
	 */
					
	private String yonghuzhanghao;
	
	/**
	 * 发布人
	 */
					
	private String yonghuxingming;
	
	/**
	 * 领养账号
	 */
					
	private String lingyangzhanghao;
	
	/**
	 * 领养人
	 */
					
	private String lingyangren;
	
	/**
	 * 手机号
	 */
					
	private String shoujihao;
	
	/**
	 * 家庭地址
	 */
					
	private String jiatingdizhi;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 审核回复
	 */
					
	private String shhf;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：动物昵称
	 */
	public void setDongwunicheng(String dongwunicheng) {
		this.dongwunicheng = dongwunicheng;
	}
	/**
	 * 获取：动物昵称
	 */
	public String getDongwunicheng() {
		return dongwunicheng;
	}
	/**
	 * 设置：动物种类
	 */
	public void setDongwuzhonglei(String dongwuzhonglei) {
		this.dongwuzhonglei = dongwuzhonglei;
	}
	/**
	 * 获取：动物种类
	 */
	public String getDongwuzhonglei() {
		return dongwuzhonglei;
	}
	/**
	 * 设置：动物性别
	 */
	public void setDongwuxingbie(String dongwuxingbie) {
		this.dongwuxingbie = dongwuxingbie;
	}
	/**
	 * 获取：动物性别
	 */
	public String getDongwuxingbie() {
		return dongwuxingbie;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：发布账号
	 */
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	/**
	 * 获取：发布账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
	/**
	 * 设置：发布人
	 */
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	/**
	 * 获取：发布人
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
	/**
	 * 设置：领养账号
	 */
	public void setLingyangzhanghao(String lingyangzhanghao) {
		this.lingyangzhanghao = lingyangzhanghao;
	}
	/**
	 * 获取：领养账号
	 */
	public String getLingyangzhanghao() {
		return lingyangzhanghao;
	}
	/**
	 * 设置：领养人
	 */
	public void setLingyangren(String lingyangren) {
		this.lingyangren = lingyangren;
	}
	/**
	 * 获取：领养人
	 */
	public String getLingyangren() {
		return lingyangren;
	}
	/**
	 * 设置：手机号
	 */
	public void setShoujihao(String shoujihao) {
		this.shoujihao = shoujihao;
	}
	/**
	 * 获取：手机号
	 */
	public String getShoujihao() {
		return shoujihao;
	}
	/**
	 * 设置：家庭地址
	 */
	public void setJiatingdizhi(String jiatingdizhi) {
		this.jiatingdizhi = jiatingdizhi;
	}
	/**
	 * 获取：家庭地址
	 */
	public String getJiatingdizhi() {
		return jiatingdizhi;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：审核回复
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}

}
