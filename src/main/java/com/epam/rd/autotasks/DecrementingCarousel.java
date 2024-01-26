package com.epam.rd.autotasks;

public class DecrementingCarousel {
    public int[] elements;
    public int capacity;
    private int newIndex;
    public boolean isRunning;
    private CarouselRun carouselRun;
    public boolean hasElements;

	public DecrementingCarousel(int capacity) {
    	this.elements = new int[capacity];
    	this.capacity = capacity;
    	this.newIndex = 0;
    	this.isRunning = false;
    	this.hasElements = false;
    }

    public boolean addElement(int element){
        if(element > 0 && newIndex < capacity && isRunning == false) {
        	elements[newIndex] = element;
        	newIndex++;
        	hasElements = true;
        	return true;
        }
        else {
        	return false;
        }
    }

    public CarouselRun run(){
       if(isRunning == true) {
    	   return null;
       }
       else {
    	   isRunning = true;
    	   carouselRun = new CarouselRun(this);
    	   return carouselRun;
       }
    }
}
