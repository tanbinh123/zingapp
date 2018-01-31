/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alpha.aardvard.hello;

/**
 *
 * @author Yuen
 */
public class Greeting {
    private final long id;
    private final String content;
    
    public Greeting() {
    	this.id = -1;
    	this.content = "";
    }
    
    public Greeting (long id, String content){
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
    
    
}
