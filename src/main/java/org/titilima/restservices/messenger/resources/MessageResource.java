package org.titilima.restservices.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.titilima.restservices.messenger.service.MessageService;
import org.titilima.restservices.messenger.model.Message;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)// Here the method returns a Message type instance response. Hence, this @Produces annotation helps in converting the Message type instance to application/json format as the response body.
public class MessageResource {
	/*
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessages() {
		return "Hello world!";
	}*/
	
	MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getMessages() {
		return messageService.getAllMessages();
	}
	/*
	@GET
	@Path("/test") //Whatever comes after "/message" in the URL pattern as "/test" this method gets executed
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "test as plain text";
	}
	
	@GET
	@Path("/{messageId}") //Whatever comes after "/message" in the URL pattern as "/xyz" this method gets executed and messageId acts as a variable here
	@Produces(MediaType.TEXT_PLAIN)
	public String test(@PathParam("messageId") String messageId) {//Make sure both @Path and @PathParam annotation use the same variable name
		return "Got the Path Param from the URL : "+messageId;
	}
	*/
	
	@GET
	@Path("/{messageId}") //Whatever comes after "/message" in the URL pattern as "/xyz" this method gets executed and messageId acts as a variable here
	public Message getMessage(@PathParam("messageId") long messageId) {//Make sure both @Path and @PathParam annotation use the same variable name here as "messageId"
		return messageService.getMessage(messageId);
	}
	
	/*@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String addMessage() {
		return "POST works!";
	}*/
	
	@POST
	public Message addMessage(Message message) { //Here the Request body which is in application/json format as mentioned in the @Consumes annotation is converted to a Message type instance named "message" and then this Message message is passed as argument to the method addMessage
		messageService.addMessage(message);
		return message;
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long messageId, Message message) {
		message.setId(messageId);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public Message deleteMessage(@PathParam("messageId") long messageId) {
		return messageService.removeMessage(messageId);
	}

}
