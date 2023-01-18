package com.BeanClasses;

import java.io.Serializable;
import java.util.Date;

public class Tender implements Serializable{
	private String id;
	private String name;
	private String type;
	private int price;
	private String desc;
	private Date deadline;
	private String location;
}
