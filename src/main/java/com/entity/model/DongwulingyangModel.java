package com.entity.model;

import com.entity.DongwulingyangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 动物领养
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-06-24 08:54:46
 */
public class DongwulingyangModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
