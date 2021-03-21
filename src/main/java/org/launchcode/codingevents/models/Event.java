package org.launchcode.codingevents.models;

import javax.validation.constraints.*;
import java.util.Objects;

public class  Event {

    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Value can not be blank.")
    @Size(min = 3,max = 50, message = "Name must be between 3 and 50 characters.")
    private String name;

    @Size(max = 500, message = "Description too long.")
    private String description;
    private String address;
    private String date;

    @NotBlank(message = "Value can not be blank.")
    @Email(message = "Invalid email. Please try again.")
    private String contactEmail;

    public Event(String name, String description, String address, String date, String contactEmail) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.date = date;
        this.contactEmail = contactEmail;
        this.id = nextId;
        nextId++;
    }
    public Event(){}
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getContactEmail() {
        return contactEmail;    }
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
