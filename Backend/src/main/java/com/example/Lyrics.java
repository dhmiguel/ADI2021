package com.example;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Lyrics {
	
	private Integer id;
	private String artist;
	private String song;
	private String lyric;
	
	
	public Lyrics() {
		
	}
	
	public Lyrics(Integer id, String artist, String song, String lyric) {
		super();
		this.id = id;
		this.artist = artist;
		this.song = song;
		this.lyric = lyric;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getSong() {
		return song;
	}
	public void setSong(String song) {
		this.song = song;
	}
	public String getLyric() {
		return lyric;
	}
	public void setLyric(String lyric) {
		this.lyric = lyric;
	}
	
	

}
