package org.titilima.restservices.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.titilima.restservices.messenger.database.DatabaseClass;
import org.titilima.restservices.messenger.model.Message;

public class MessageService {
	
	//Access all the messages from DatabaseClass.java
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	/*
	public List<Message> getAllMessages(){
		Message m1 = new Message(1L, "Hello world", "Titilima");
		Message m2 = new Message(2L, "Hello Jersey", "Titilima");
		List<Message> list = new ArrayList<>();
		list.add(m1);
		list.add(m2);
		return list;
	}
	 */
	
	//Constructor for the hard coded messages
	public MessageService() {
		messages.put(1L, new Message(1, "Hello world", "Titilima"));
		messages.put(2L, new Message(2, "Hello Jersey", "Titilima"));
	}
	
	//Get List of all messages:
	public List<Message> getAllMessages(){
		//Passing a collection to the ArrayList Constructor initialized the List with those elements
		return new ArrayList<Message>(messages.values());
	}
	
	//Get Messages with respect to a specific Id
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	//Add a specific Message
	public Message addMessage(Message message) {
		message.setId(messages.size()+1);//Sets the Id to the specific message by incrementing the size of the message by 1
		messages.put(message.getId(), message);//It puts the message with the respective Id
		return message;	// Returns the message that is added
	}
	
	//Update a specific Message
	public Message updateMessage(Message message) {
		if(message.getId() <= 0) {
			return null;//If id is less than or equal to 0
		}
		messages.put(message.getId(), message);//It puts the updated message in the specific id
		return message;
	}
	
	//remove a specific Message
	public Message removeMessage(long id) {
		return messages.remove(id);//It removes the message with specific id
	}
	
}
