package com.itau.twitter.model;

import lombok.Data;

@Data
public class Twitter {
	
	private long id;
	
	private long author_id;
	
	private String created_at;
	
	private String text;
	
}
