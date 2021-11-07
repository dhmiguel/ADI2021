package com.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("lyrics")
public class LyricsResource {
	
	private static List<Lyrics> lyrics = new ArrayList<Lyrics>();
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Lyrics> lyrics(){
		
		return lyrics;
	}
	
	@GET
	@Path("{artist}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Lyrics> lyricsByArtist(@PathParam("artist") String artist){
		List<Lyrics> listaByArtist = new ArrayList<Lyrics>();
		for(Lyrics l : lyrics) {
			if(l.getArtist().equals(artist)) {
				listaByArtist.add(l);
			}
		}
		return listaByArtist;
		
	}
	
	@DELETE
	@Path("remove/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response remove (@PathParam("id") int id) {
		
		try {
			
			Lyrics Deletar = lyrics.stream().filter(i->i.getId() == id).findFirst().get();
			
			lyrics.remove(Deletar);
		    
			return Response.status(Response.Status.OK).build();
			
		}
		catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
			//return new Lyrics();
		}
	}
	
	@POST
	@Path("save")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save (Lyrics lyric) {
		
		lyric.setId(lyrics.size() + 1);
		try {
			lyrics.add(lyric);
			
			return Response.status(Response.Status.CREATED).entity(lyric).build();
			
			
		}catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	
	}
	

}
