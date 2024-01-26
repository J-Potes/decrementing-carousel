package com.epam.rd.autotasks;

public class CarouselRun {
	
	private DecrementingCarousel parentObject;
	private int currentIndex = 0;
	private boolean isFinished;
	
	public CarouselRun(DecrementingCarousel parent) {
		this.parentObject = parent;
		if(parentObject.hasElements == false) {
			this.isFinished = true; 
		}
		else {
			this.isFinished = false;
		}
	}
	
    public int next() {
    	int countSteps = 0;
    	boolean success = false;
    	int value = 0;
    	
    	if(isFinished == true) {
    	   return -1;
    	}
    	else {
    		while(countSteps < parentObject.capacity) {
    			if(parentObject.elements[currentIndex] != 0) {
    				value = parentObject.elements[currentIndex];
    				success = true;
    				parentObject.elements[currentIndex]--;
    				currentIndex++;
    				if(currentIndex >= parentObject.capacity) {
        				currentIndex = 0;
        			}
    				break;
    			}
    			else {
    				currentIndex++;
        			countSteps++;
        			if(currentIndex >= parentObject.capacity) {
        				currentIndex = 0;
        			}
    			}
    		}
    		if(success == true) {
    			return value;
    		}
    		else {
    			isFinished = true;
    			return -1;
    		}
    	}
    }
    
    public boolean isFilledWithZeros(int[] array) {
    	for (int i : array) {
            if (i != 0) {
                return false;  // Found a non-zero element
            }
        }
        return true;
    }

    public boolean isFinished() {
    	if(isFinished == true) {
    		return true;
    	}
    	else {
    		if(isFilledWithZeros(parentObject.elements) == true) {
    			isFinished = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }

}
