package com.google.sps.data;

/*an item on a todo list*/
public final class Task{
    private final long id;
    private final String name;
    // private final String email;
    private final String comment;
    private final long timestamp;

    public Task(long id, String name, String comment, long timestamp){
        this.id = id;
        this.name = name;
        // this.email = email;
        this.comment = comment;
        this.timestamp = timestamp;
    }
}