package com.example.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TestApi {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String addr1;
	//@Column(length = 10)
	//private String addr2;
	//private String gugunNm;
	//private String hompageUrl;
	@Column(length = 500)
	private String cntctTel;
	@Lob
	private String itemcntnts;
	private Double lat; // 타입 맞나?
	private Double lng;
	private String mainImgNormal;
	private String mainImgThumb;
	private String mainTitle;
	//private String place;
	private String rprsntvMenu;
	//@Column(length = 10)
	//private String subtitle;
	//private int ucSeq;
	@Column(length = 500)
	private String usageDayWeekAndTime;

}
