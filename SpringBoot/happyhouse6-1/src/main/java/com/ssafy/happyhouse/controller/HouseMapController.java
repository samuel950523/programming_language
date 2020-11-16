package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ssafy.happyhouse.dto.HouseDealDto;
import com.ssafy.happyhouse.dto.HouseInfoDto;
import com.ssafy.happyhouse.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.service.HouseMapService;

@RestController
public class HouseMapController{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	HouseMapService service;

	@GetMapping(value="/map")
	protected void searchAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String act = request.getParameter("act");
		if("sido".equals(act)) {
			PrintWriter out = response.getWriter();
			List<SidoGugunCodeDto> list = null;
			JsonArray arr = new JsonArray();
			try {
				list = service.getSido();
				for(SidoGugunCodeDto dto : list) {
					JsonObject obj = new JsonObject();
					obj.addProperty("sido_code", dto.getSidoCode());
					obj.addProperty("sido_name", dto.getSidoName());
					arr.add(obj);
				}
			} catch (Exception e) {
				arr = new JsonArray();
				JsonObject obj = new JsonObject();
				obj.addProperty("message_code", "-1");
				arr.add(obj);
				e.printStackTrace();
			} finally {
				out.print(arr.toString());
				out.close();
			}
		}//sido
		else if("gugun".equals(act)) {
			String sido = request.getParameter("sido");
			PrintWriter out = response.getWriter();
			List<SidoGugunCodeDto> list = null;
			JsonArray arr = new JsonArray();
			try {
				list = service.getGugunInSido(sido);
				for(SidoGugunCodeDto dto : list) {
					JsonObject obj = new JsonObject();
					obj.addProperty("gugun_code", dto.getGugunCode());
					obj.addProperty("gugun_name", dto.getGugunName());
					arr.add(obj);
				}
			} catch (Exception e) {
				arr = new JsonArray();
				JsonObject obj = new JsonObject();
				obj.addProperty("message_code", "-1");
				arr.add(obj);
				e.printStackTrace();
			} finally {
				out.print(arr.toString());
				out.close();
			}
		}//gugun
		else if("dong".equals(act)) {
			String gugun = request.getParameter("gugun");
			PrintWriter out = response.getWriter();
			List<HouseInfoDto> list = null;
			JsonArray arr = new JsonArray();
			try {
				list = service.getDongInGugun(gugun);
				for(HouseInfoDto dto : list) {
					JsonObject obj = new JsonObject();
					obj.addProperty("code", dto.getCode());
					obj.addProperty("dong", dto.getDong());
					arr.add(obj);
				}
			} catch (Exception e) {
				arr = new JsonArray();
				JsonObject obj = new JsonObject();
				obj.addProperty("message_code", "-1");
				arr.add(obj);
				e.printStackTrace();
			} finally {
				out.print(arr.toString());
				out.close();
			}
		}//dong
		else if("apt".equals(act)) {
			String dong = request.getParameter("dong");
			PrintWriter out = response.getWriter();
			List<HouseInfoDto> list = null;
			JsonArray arr = new JsonArray();
			try {
				list = service.getAptInDong(dong);
				for(HouseInfoDto dto : list) {
					JsonObject obj = new JsonObject();
					obj.addProperty("no", dto.getNo());
					obj.addProperty("dong", dto.getDong());
					obj.addProperty("aptName", dto.getAptName());
					obj.addProperty("code", dto.getCode());
					obj.addProperty("jibun", dto.getJibun());
					arr.add(obj);
				}
			} catch (Exception e) {
				arr = new JsonArray();
				JsonObject obj = new JsonObject();
				obj.addProperty("message_code", "-1");
				arr.add(obj);
				e.printStackTrace();
			} finally {
				out.print(arr.toString());
				out.close();
			}
		}//dong
		else if("aptdetail".equals(act)) {
			String aptdetail = request.getParameter("aptdetail");
			PrintWriter out = response.getWriter();
			List<HouseInfoDto> list = null;
			JsonArray arr = new JsonArray();
			try {
				list = service.getAptDetail(aptdetail);
				for(HouseInfoDto dto : list) {
					JsonObject obj = new JsonObject();
					obj.addProperty("no", dto.getNo());
					obj.addProperty("dong", dto.getDong());
					obj.addProperty("aptName", dto.getAptName());
					obj.addProperty("code", dto.getCode());
					obj.addProperty("jibun", dto.getJibun());
					arr.add(obj);
				}
			} catch (Exception e) {
				arr = new JsonArray();
				JsonObject obj = new JsonObject();
				obj.addProperty("message_code", "-1");
				arr.add(obj);
				e.printStackTrace();
			} finally {
				out.print(arr.toString());
				out.close();
			}
		}//aptname
		else if("aptDeal".equals(act)) {
			String aptName = request.getParameter("aptName");
			String dongCode = request.getParameter("dongCode");
			PrintWriter out = response.getWriter();
			HouseDealDto dto = null;
			try {
				
				dto = service.getDetail(aptName, dongCode);
					JsonObject obj = new JsonObject();
					obj.addProperty("no", dto.getNo());
					obj.addProperty("AptName", dto.getAptName());
					obj.addProperty("dealAmount", dto.getDealAmount());
					obj.addProperty("rentMoney", dto.getRentMoney());
					obj.addProperty("buildYear", dto.getBuildYear());
					obj.addProperty("area", dto.getArea());
					obj.addProperty("dealYear", dto.getDealYear());
					obj.addProperty("dealMonth", dto.getDealMonth());
					obj.addProperty("dealDay", dto.getDealDay());
					obj.addProperty("dong", dto.getDong());
					obj.addProperty("jibun", dto.getJibun());
					
			} catch (Exception e) {
				JsonObject obj = new JsonObject();
				obj.addProperty("message_code", "-1");
				e.printStackTrace();
			} finally {
				out.close();
			}
		}//detail
	}//process

}