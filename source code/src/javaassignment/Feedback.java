package javaassignment;

public class Feedback {
    private int feedbackID;
    private String feedbackMessage;
    private Book feedbackItem;

    public Feedback(int feedbackID, String feedbackMessage, Book feedbackItem) {
        this.feedbackID = feedbackID;
        this.feedbackMessage = feedbackMessage;
        this.feedbackItem = feedbackItem;
    }

    public int getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getFeedbackMessage() {
        return feedbackMessage;
    }

    public void setFeedbackMessage(String feedbackMessage) {
        this.feedbackMessage = feedbackMessage;
    }

    public Book getFeedbackItem() {
        return feedbackItem;
    }

    public void setFeedbackItem(Book feedbackItem) {
        this.feedbackItem = feedbackItem;
    }
    
    
    
}
