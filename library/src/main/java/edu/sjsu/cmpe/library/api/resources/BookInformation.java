package edu.sjsu.cmpe.library.api.resources;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import edu.sjsu.cmpe.library.domain.Author;
import edu.sjsu.cmpe.library.domain.Review;

import java.util.ArrayList;

@XmlRootElement
public class BookInformation {
		
	@NotEmpty
	@NotNull
        public String title;
		
	@NotEmpty
	@NotNull	
        @JsonProperty ("publication-date")
        public String publicationDate;
        
		public String language;
        
		@JsonProperty ("num-pages")
        public int numOfPages;
        
		public String status;
        		
        @NotEmpty
	@NotNull
        public ArrayList<Author> authors;
        
		public ArrayList<Review> reviews;
     
        public BookInformation() {} 
     
        public BookInformation(String title, String publicationDate, String language, int numOfPages, String status, ArrayList<Author> authors) {
            this.title = title;
            this.publicationDate = publicationDate;
            this.language = language;
            this.numOfPages = numOfPages;
            this.status = status;
            this.authors = authors;
        }
        
        public boolean check_Title(){
        	if (title.isEmpty()|| title==null){
        		return false;
        	}
        	return true;
        }
        
        public boolean check_PublicationDate(){
        	if (publicationDate.isEmpty() || publicationDate == null){
        		return false;
        	}
        	return true;
        }
        
        public boolean check_Authors(){
        	boolean nameValid = false;
        	int counter = 0;
        	for (int i =0; i<authors.size(); i++){
        		if (!authors.get(i).getName().isEmpty() && authors.get(i).getName() != null){
        			counter ++;
        		}
        	}
        	if (authors.size()==0){
        		nameValid = false;
        	}
        	else if (counter==authors.size()){
        		nameValid = true;
        	}
        	else {
        		nameValid = false;
        	}
        	
        	return nameValid;
        }
     
        //check if status is valid
        public boolean check_Status(String status){
        	String book_Status=status.toLowerCase();
        	if (book_Status.equals("lost") || book_Status.equals("checked-in")|| book_Status.equals("in-queue") || book_Status.equals("available"))
        		return true;
        	else if (book_Status.isEmpty()) 
        		return true;
        	else
        		return false;
        }
}
