package Model;

import java.io.Serializable;

public class Message implements Serializable {
	private String sender;
	private String content;
	private String dateTime;

	public Message(String sender, String content, String dateTime) {
		super();
		this.sender = sender;
		this.content = content;
		this.dateTime = dateTime;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
}
